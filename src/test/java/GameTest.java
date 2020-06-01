import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameTest {

    Game game;
    Deck deck;
    Player dealer;
    Player player1;
    Card card1;
    Card card2;

    @Before
    public void setUp(){
        deck = new Deck();
        game = new Game(deck);
        player1 = new Player();
        dealer = new Player();
        card1 = new Card(Suit.HEARTS, Rank.ACE);
        card2 = new Card(Suit.HEARTS, Rank.JACK);
        game.addPlayer(player1);
        game.addPlayer(dealer);
        deck.populate();
        deck.shuffleDeck();
    }

    @Test
    public void canCountPlayers(){
        assertEquals(2, game.countPlayers());
    }

    @Test
    public void canDealCards(){
       game.dealCards(deck);
       assertEquals(2, player1.countCards());
       assertEquals(2, dealer.countCards());
    }

    @Test
    public void playerOneWins(){
        player1.addCard(card1);
        dealer.addCard(card2);
        String result = game.checkSomebodyWins(player1, dealer);
        assertEquals("Player 2 wins",result);
    }

    @Test
    public void playerTwoWins(){
        player1.addCard(card2);
        dealer.addCard(card1);
        String result = game.checkSomebodyWins(player1, dealer);
        assertEquals("Player 1 wins",result);
    }

    @Test
    public void itsATie(){
        player1.addCard(card2);
        dealer.addCard(card2);
        String result = game.checkSomebodyWins(player1, dealer);
        assertEquals("It's a tie",result);
    }

    @Test
    public void checkDealerWins(){
        dealer.addCard(card1);
        dealer.addCard(card2);
        dealer.addCard(card2);
        player1.addCard(card1);
        Player result = game.checkWhoWins();
        assertEquals(dealer, result);
    }

    @Test
    public void checkPlayerWins(){
        dealer.addCard(card1);
        player1.addCard(card1);
        player1.addCard(card2);
        player1.addCard(card2);
        Player result = game.checkWhoWins();
        assertEquals(player1, result);
    }

}
