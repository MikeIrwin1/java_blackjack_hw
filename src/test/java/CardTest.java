import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {

    Card card;

    @Before
    public void before(){
        card = new Card(SuitType.SPADES, RankType.ACE);
    }

    @Test
    public void cardHasSuit(){
        assertEquals(SuitType.SPADES, card.getSuit());
    }

    @Test
    public void cardHasRank(){
        assertEquals(RankType.ACE, card.getRank());
    }

    @Test
    public void cardHasRankValue(){
        assertEquals(11, card.getRankFromEnum());
    }

}
