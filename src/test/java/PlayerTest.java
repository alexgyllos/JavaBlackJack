import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    Player player;
    Card card1;
    Card card2;

    @Before
    public void setUp(){
        card1 = new Card(Suit.HEARTS, Rank.ACE);
        card2 = new Card(Suit.HEARTS, Rank.JACK);
        player = new Player();
    }

    @Test
    public void startsEmpty(){
        assertEquals(0, player.countCards());
    }

    @Test
    public void canAddCard(){
        player.addCard(card1);
        assertEquals(1, player.countCards());
    }

    @Test
    public void canGetHandValue(){
        player.addCard(card1);
        player.addCard(card2);
        assertEquals(11, player.getHandValue());
    }

    @Test
    public void playerTwists(){
        player.addCard(card1);
        player.addCard(card2);
        player.getHandValue();
        boolean result = player.twistOrStick();
        assertTrue(result);
    }

    @Test
    public void playerSticks(){
        player.addCard(card1);
        player.addCard(card2);
        player.addCard(card2);
        player.getHandValue();
        boolean result = player.twistOrStick();
        assertFalse(result);
    }
}
