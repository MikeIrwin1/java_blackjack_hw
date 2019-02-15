import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player player;
    Deck deck;
    Dealer dealer;
    Card card1;
    Card card2;

    @Before
    public void before(){
        deck = new Deck();
        player = new Player();
        dealer = new Dealer(deck);
        card1 = new Card(SuitType.SPADES, RankType.FOUR);
        card2 = new Card(SuitType.SPADES, RankType.FIVE);

    }

    @Test
    public void playerHasEmptyHand(){
        assertEquals(0, player.getHand().size());
    }

    @Test
    public void playerCanReceiveCard(){
        dealer.drawCard();
        dealer.dealCard(player);
        assertEquals(1, player.getHand().size());
    }

    @Test
    public void playerCanCheckHandValue(){
        player.receiveCard(card1);
        player.receiveCard(card2);
        assertEquals(9, player.getHandValue());
    }
}
