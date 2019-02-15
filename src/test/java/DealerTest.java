import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    private Dealer dealer;
    private Player player1;

    @Before
    public void before(){
        Deck deck = new Deck();
        deck.shuffle();
        dealer = new Dealer(deck);
        player1 = new Player();
    }

    @Test
    public void dealerHasCardsToDeal(){
        dealer.drawCard();
        assertEquals(1, dealer.getToBeDealt().size());
    }

    @Test
    public void dealerCanPassOverCard(){
        dealer.drawCard();
        dealer.dealCard(player1);
        assertEquals(0, dealer.getToBeDealt().size());
    }

    @Test
    public void dealerCanHaveHand(){
        assertEquals(0, dealer.getHand().size());
    }

    @Test
    public void dealerCanAddToHand(){
        dealer.drawCard();
        dealer.retainCard();
        assertEquals(1,dealer.getHand().size());
    }

}
