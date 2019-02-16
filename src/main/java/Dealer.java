import java.util.ArrayList;


public class Dealer {

    private ArrayList<Card> hand;
    private Deck deck;
    private Boolean isBust;


    public Dealer(Deck deck){
        this.deck = deck;
        this.hand = new ArrayList<>();
        this.isBust = false;
    }

    public Deck getDeck() {
        return deck;
    }

    public Boolean getBust() {
        return isBust;
    }

    public Card drawCard(){
        return deck.dealCard();
    }

    public void dealCard(Player player, Card drawnCard){
        player.receiveCard(drawnCard);
    }

    public void retainCard(Card drawnCard){
        this.hand.add(drawnCard);
    }

    public ArrayList getHand() {
        return this.hand;
    }

    public int getHandValue() {
        int totalValue = 0;
        for(Card card : this.hand){
            totalValue += card.getRankFromEnum();
        }
        return totalValue;
    }
}
