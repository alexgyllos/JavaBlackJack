import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {

    Card card;

    @Before
    public void setUp(){
        card = new Card(Suit.HEARTS, Rank.ACE);
    }

    @Test
    public void hasSuit(){
        assertEquals("Hearts", card.getSuit());
    }

    @Test
    public void hasRank(){
        assertEquals(1, card.getRank());
    }
}
