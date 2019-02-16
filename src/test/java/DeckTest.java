import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    private Deck deck;
    private Card card;

    @Before
    public void before(){
        deck = new Deck();
        card = new Card(SuitType.SPADES, RankType.ACE);
    }

    @Test
    public void deckCanAddCardToList(){
        deck.addCard(card);
        assertEquals(53, deck.numberOfCards());
    }

    @Test
    public void deckCanMakeCard(){
        Card card = deck.makeCard();
        deck.addCard(card);
        assertEquals(53, deck.numberOfCards());
    }

    @Test
    public void deckHas52Cards(){
        deck.shuffle();
        assertEquals(52, deck.numberOfCards());
    }

    @Test
    public void deckHasDealtCards(){
        deck.dealCard();
        assertEquals(1, deck.getDealtCards().size());
    }

    @Test
    public void deckCanDealCard(){
        deck.dealCard();
        assertEquals(51, deck.numberOfCards());
        assertEquals(1, deck.numberOfDealtCards());
    }

    @Test
    public void deckCanBeReset(){
        deck.dealCard();
        deck.dealCard();
        assertEquals(50, deck.numberOfCards());
        deck.reset();
        assertEquals(52, deck.numberOfCards());
    }
}
