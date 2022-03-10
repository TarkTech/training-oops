using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IplDataScrapper
{
    class GenerateCSV
    {
        public static void GenerateTeamCSV(List<Team> teams)
        {
            StringBuilder sb = new StringBuilder();
            sb.AppendLine("Team, Captain");
            foreach (var team in teams)
            {
                sb.AppendLine(team.Name + ", " + team.Captain);
            }
            string filename = "Teams.csv";
            Generate(filename, sb);
        }

        public static void GenerateTeamCSV(List<Player> players)
        {
            StringBuilder sb = new StringBuilder();
            sb.AppendLine("Team Name, Player Name, Auction Price, Role, Country");
            foreach (var player in players)
            {
                sb.AppendLine(player.TeamName + ", " + player.Name + ", " + player.AuctionPrice.ToString() + ", " +  player.Role +", "+ player.Nation);
            }
            string filename = "Players.csv";

            Generate(filename, sb);
        }

        static void Generate(string filename, StringBuilder fileData)
        {
            File.WriteAllText(CommonVariables.PathToGenerate + filename, fileData.ToString());
        }
    }
}
