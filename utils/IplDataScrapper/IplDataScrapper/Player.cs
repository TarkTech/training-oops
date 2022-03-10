namespace IplDataScrapper
{
    class Player
    {
        public string TeamName { get; set; }
        public string Name { get; set; }
        public string Role { get; set; }
        public double AuctionPrice { get; set; }
        public string Nation { get; set; }

        public Player(string teamName, string name, string role, double auctionPrice, string nation)
        {
            TeamName = teamName;
            Name = name;
            Role = role;
            AuctionPrice = auctionPrice;
            Nation = nation;
        }
    }
}
