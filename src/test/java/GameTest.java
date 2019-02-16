import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;
    private Player player;
    private Dealer dealer;

    @Before
    public void before(){
        Deck deck = new Deck();
        player = new Player();
        dealer = new Dealer(deck);
        game = new Game(dealer, player);
    }

    @Test
    public void gameHasPlayer(){
        assertEquals(player, game.getPlayer());
    }

    @Test
    public void gameHasDealer(){
        assertEquals(dealer, game.getDealer());
    }

    @Test
    public void canSetUpRound(){
        Card card1 = dealer.drawCard();
        dealer.dealCard(player, card1);
        Card card2 = dealer.drawCard();
        dealer.retainCard(card2);
        Card card3 = dealer.drawCard();
        dealer.dealCard(player, card2);
        Card card4 = dealer.drawCard();
        dealer.retainCard(card4);

    }


}
