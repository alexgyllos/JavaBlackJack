import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeckTest {

    Deck deck;
    ArrayList<Card> cards;

    @Before
    public void setUp(){
        deck = new Deck();
        cards = new ArrayList<Card>();
    }

    @Test
    public void deckStartsEmpty(){
        assertEquals(0, deck.countCards());
    }

    @Test
    public void canPopulateDeck(){
        deck.populate();
        assertEquals(52, deck.countCards());
    }

    @Test
    public void canShuffleDeck(){
        deck.shuffleDeck();
        assertEquals(true, deck.getShuffleStatus());
    }

    @Test
    public void canDealCard(){
        deck.populate();
        deck.dealCard();
        assertEquals(51, deck.countCards());
    }
}
