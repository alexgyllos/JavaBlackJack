import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private boolean shuffleStatus;
    private ArrayList<Card> deck;

    public Deck(){
        this.deck = new ArrayList<Card>();
        this.shuffleStatus = false;
    }

    public int countCards() {
        return this.deck.size();
    }

    public void populate() {
        for (Suit suit: Suit.values()){
            for (Rank rank: Rank.values()){
              Card card = new Card(suit, rank);
              this.deck.add(card);
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(this.deck);
        this.shuffleStatus = true;
    }

    public boolean getShuffleStatus(){
        return this.shuffleStatus;
    }

    public Card dealCard() {
        return this.deck.remove(0);
    }
}
