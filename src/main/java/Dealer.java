import java.util.ArrayList;


public class Dealer {

    private ArrayList<Card> hand;
    private Deck deck;

    public Dealer(Deck deck){
        this.deck = deck;
        this.hand = new ArrayList<>();
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
