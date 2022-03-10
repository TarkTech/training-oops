using HtmlAgilityPack;
using System;
using System.Collections.Generic;

namespace IplDataScrapper
{
    class Program
    {
        static void Main(string[] args)
        {
            var htmlDoc = getHTMLDoc();
            List<Team> teamList = DocumentParser.getTeamNameList(htmlDoc);
            List<Player> playerList = DocumentParser.getPlayersList(htmlDoc, teamList);
            GenerateCSV.GenerateTeamCSV(teamList);
            GenerateCSV.GenerateTeamCSV(playerList);
        }

        static HtmlDocument getHTMLDoc()
        {
            HtmlWeb web = new HtmlWeb();
            return web.Load(CommonVariables.url);
        }

    }
}
