import java.util.ArrayList;

public class Player {

    Card card;
    private ArrayList<Card> hand;

    public Player(){
        this.hand = new ArrayList<>();
    }

    public void receiveCard(Card dealtCard){
        this.hand.add(dealtCard);
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public int getHandValue() {
        int total = 0;
        for(Card card : hand){
            total += card.getRankFromEnum();
        }
        return total;
    }
}
