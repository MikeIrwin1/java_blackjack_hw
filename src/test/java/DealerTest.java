import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    Dealer dealer;
    Deck deck;
    Player player1;
    Player player2;

    @Before
    public void before(){
        deck = new Deck();
        deck.shuffle();
        dealer = new Dealer(deck);

        player1 = new Player();
        player2 = new Player();
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

}
