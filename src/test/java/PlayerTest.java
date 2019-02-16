import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player player;
    Deck deck;
    Dealer dealer;
    Card card1;
    Card card2;
    Card card3;

    @Before
    public void before(){
        deck = new Deck();
        player = new Player();
        dealer = new Dealer(deck);
        card1 = new Card(SuitType.SPADES, RankType.TEN);
        card2 = new Card(SuitType.SPADES, RankType.NINE);
        card3 = new Card(SuitType.HEARTS, RankType.FOUR);

    }

    @Test
    public void playerHasEmptyHand(){
        assertEquals(0, player.getHand().size());
    }

    @Test
    public void playerIsNotBust(){
        assertEquals(false, player.getBust());
    }

    @Test
    public void playerCanReceiveCard(){
        Card drawnCard = dealer.drawCard();
        dealer.dealCard(player, drawnCard);
        assertEquals(1, player.getHand().size());
    }

    @Test
    public void playerCanCheckHandValue(){
        player.receiveCard(card1);
        player.receiveCard(card2);
        assertEquals(19, player.getHandValue());
    }
}
