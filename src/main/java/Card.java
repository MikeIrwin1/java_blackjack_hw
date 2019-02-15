public class Card {

    private SuitType suit;
    private RankType rank;

    public Card(SuitType suit, RankType rank){
        this.rank = rank;
        this.suit = suit;
    }

    public SuitType getSuit() {
        return this.suit;
    }

    public RankType getRank() {
        return rank;
    }

    public int getRankFromEnum() {
        return this.rank.getValue();
    }
}
