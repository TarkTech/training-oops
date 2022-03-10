using System;

namespace IplDataScrapper
{
    class Team
    {
        public string Name { get; set; }
        public string Captain { get; set; }

        public Team(string name)
        {
            Name = name;
        }

        public void AddCaptain(string captainName)
        {
            Captain = captainName;
        }
    }
}
