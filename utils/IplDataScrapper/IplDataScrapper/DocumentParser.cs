using HtmlAgilityPack;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IplDataScrapper
{
    class DocumentParser
    {
        public static List<Team> getTeamNameList(HtmlDocument htmlDoc)
        {
            List<Team> teams = new List<Team>();
            var nodes = htmlDoc.DocumentNode.SelectNodes("//*[@id='post-18219']/div[2]/div[1]/div/div/h3");
            foreach (var node in nodes)
            {
                string name = String.Empty;
                int strongNodeCount = node.SelectNodes("strong").Count;
                if (strongNodeCount == 2)
                {
                    name = node.SelectSingleNode("strong[2]").InnerHtml;
                }
                else if (strongNodeCount == 1)
                {
                    var wordArray = node.SelectSingleNode("strong").InnerHtml.Split(";");
                    if (wordArray.Length > 1)
                        name = wordArray[1].Trim();
                }
                if (name != String.Empty)
                    teams.Add(new Team(name));
            }
            return teams;
        }

        public static List<Player> getPlayersList(HtmlDocument htmlDoc, List<Team> teams)
        {
            List<Player> players = new List<Player>();
            var nodes = htmlDoc.DocumentNode.SelectNodes("//table[@dir=\"ltr\"]");

            for (int i = 0; i < 10; i++)
            {
                string teamName = teams[i].Name;

                var node = nodes[i];
                var rows = node.SelectNodes("tbody//tr");
                for (int j = 1; j < rows.Count; j++)
                {
                    var cols = rows[j].SelectNodes("td");

                    string name = getName(cols[0].InnerText);
                    string role = cols[1].InnerText;
                    double auctionPrice = getAuctionPrice(cols[2].InnerText);
                    string nation = cols[3].InnerText;

                    if (isCaptain(cols[0].InnerText))
                    {
                        teams[i].AddCaptain(name);
                    }

                    players.Add(new Player(teamName, name, role, auctionPrice, nation));

                }
            }
            return players;
        }

        private static bool isCaptain(string tdData)
        {
            return tdData.Contains("(c");
        }

        private static string getName(string tdData)
        {
            if (tdData.Contains("("))
            {
                return tdData.Remove(tdData.IndexOf("("));
            }
            else
            {
                return tdData;
            }
        }

        private static double getAuctionPrice(string tdData)
        {
            double price = 0;
            tdData = tdData.ToLower();
            if (tdData.Contains("cr") || tdData.Contains("la"))
            {
                price = Convert.ToDouble(tdData.Replace("cr", " ").Split(" ")[1]);
                price = tdData.Contains("cr") ? price * 100 : price;
            }

            return price;
        }
    }
}
