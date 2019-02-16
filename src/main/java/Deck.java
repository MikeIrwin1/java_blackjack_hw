import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;
    private ArrayList<Card> dealtCards;

    public Deck(){
        this.cards = new ArrayList<>();
        this.dealtCards = new ArrayList<>();
        makeCardset();
    }

    public ArrayList<Card> getDealtCards() {
        return dealtCards;
    }

    public int numberOfCards() {
        return this.cards.size();
    }


    public void addCard(Card card) {
        this.cards.add(card);
    }

    public Card makeCard() {
        Card card = new Card(SuitType.SPADES, RankType.ACE);
        return card;
    }

    public void makeCardset(){
        SuitType suits[] = SuitType.values();
        RankType ranks[] = RankType.values();

        for (SuitType suit : suits){
            for (RankType rank : ranks){
                Card card = new Card(suit, rank);
                addCard(card);
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(this.cards);
    }

    public Card dealCard(){
        shuffle();
        Card dealtCard = this.cards.remove(0);
        this.dealtCards.add(dealtCard);
        return dealtCard;

    }

    public int numberOfDealtCards() {
        return this.dealtCards.size();
    }

    public void reset(){
        this.cards.addAll(this.dealtCards);
    }
}
