import java.util.ArrayList;

public class Player {


    private ArrayList<Card> hand;
    private Boolean isBust;
    private Boolean twist;

    public Player(){
        this.hand = new ArrayList<>();
        this.isBust = false;
        this.twist = false;

    }

    public Boolean getBust() {
        return isBust;
    }

    public Boolean getTwist(){
        return this.twist;
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public void receiveCard(Card dealtCard){
        this.hand.add(dealtCard);
    }

    public int getHandValue() {
        int total = 0;
        for(Card card : hand){
            total += card.getRankFromEnum();
        }
        return total;
    }
}
