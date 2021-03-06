import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DealerTest {

    private Dealer dealer;
    private Player player1;
    private Deck deck;

    @Before
    public void before(){
        deck = new Deck();
        deck.shuffle();
        dealer = new Dealer(deck);
        player1 = new Player();
    }

    @Test
    public void dealerCanGetDeck(){
        assertEquals(deck, dealer.getDeck());
    }

    @Test
    public void dealerCanDrawCard(){
        assertNotNull(dealer.drawCard().getSuit());
    }

    @Test
    public void dealerCanDealCardToPlayer(){
        Card card = dealer.drawCard();
        dealer.dealCard(player1, card);
        assertEquals(1, player1.getHand().size());
    }


    @Test
    public void dealerCanHaveHand(){
        assertEquals(0, dealer.getHand().size());
    }

    @Test
    public void dealerCanAddToHand(){
        Card card = dealer.drawCard();
        dealer.retainCard(card);
        assertEquals(1,dealer.getHand().size());
    }

    @Test
    public void dealerCanCheckValue(){
        Card card1 = new Card(SuitType.SPADES, RankType.TEN);
        Card card2 = new Card(SuitType.SPADES, RankType.NINE);
        dealer.retainCard(card1);
        dealer.retainCard(card2);
        assertEquals(19, dealer.getHandValue());
    }
}
