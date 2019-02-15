import java.util.ArrayList;
import java.util.Random;

public class Dealer {

    private ArrayList<Card> toBeDealt;
    private Deck deck;

    public Dealer(Deck deck){
        this.deck = deck;
        this.toBeDealt = new ArrayList<>();
    }

    public ArrayList<Card> getToBeDealt() {
        return toBeDealt;
    }

    public void drawCard(){
        deck.dealCard();
        this.toBeDealt = deck.getDealtCards();
    }

    public void dealCard(Player player){
        Card dealtCard = this.toBeDealt.remove(0);
        player.receiveCard(dealtCard);

    }


}
