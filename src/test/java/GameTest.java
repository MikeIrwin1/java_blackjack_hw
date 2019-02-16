import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;
    private Player player;
    private Dealer dealer;
    private Deck deck;

    @Before
    public void before(){
        deck = new Deck();
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
        game.setupRound();
        assertEquals(2, dealer.getHand().size());
        assertEquals(2, player.getHand().size());
        assertEquals(48, deck.numberOfCards());
    }

    @Test
    public void canCheckPlayersHandValue(){
        Card card1 = new Card(SuitType.HEARTS, RankType.FIVE);
        Card card2 = new Card(SuitType.HEARTS, RankType.FOUR);
        player.receiveCard(card1);
        player.receiveCard(card2);
        assertEquals(9, game.checkPlayerHandValue());
    }

    @Test
    public void canCheckDealerHandValue(){
        Card card1 = new Card(SuitType.HEARTS, RankType.FIVE);
        Card card2 = new Card(SuitType.HEARTS, RankType.FOUR);
        dealer.retainCard(card1);
        dealer.retainCard(card2);
        assertEquals(9, game.checkDealerHandValue());
    }

    @Test
    public void canCompareHands(){
        Card card1 = new Card(SuitType.HEARTS, RankType.FIVE);
        Card card2 = new Card(SuitType.HEARTS, RankType.FOUR);
        player.receiveCard(card1);
        player.receiveCard(card2);
        Card card3 = new Card(SuitType.HEARTS, RankType.FIVE);
        Card card4 = new Card(SuitType.HEARTS, RankType.SIX);
        dealer.retainCard(card3);
        dealer.retainCard(card4);
        assertEquals(9, game.checkPlayerHandValue());
        assertEquals(11, game.checkDealerHandValue());
        assertEquals("dealer wins!", game.determineWinner());
    }

    @Test
    public void playerHasBlackjack(){
        Card card1 = new Card(SuitType.HEARTS, RankType.ACE);
        Card card2 = new Card(SuitType.HEARTS, RankType.TEN);
        player.receiveCard(card1);
        player.receiveCard(card2);
        assertEquals("Blackjack! player wins!", game.determineWinner());
    }

    @Test
    public void dealerMustHaveValidHand(){
        Card card1 = new Card(SuitType.HEARTS, RankType.FOUR);
        Card card2 = new Card(SuitType.HEARTS, RankType.TEN);
        dealer.retainCard(card1);
        dealer.retainCard(card2);
        game.checkDealerHandValid();
        assertEquals(true, game.checkDealerHandValid());
    }
}
