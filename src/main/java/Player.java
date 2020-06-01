import java.util.ArrayList;

public class Player {

    private ArrayList<Card> cards;
    private int handValue;

    public Player(){
        this.cards = new ArrayList<Card>();
        this.handValue = 0;
    }

    public int countCards() {
        return this.cards.size();
    }

    public void addCard(Card card){
        this.cards.add(card);
    }

    public Card getCard(){
        if(this.cards.size()>0){
            for(Card card: cards){
                return card;
            }
        }
        return null;
    }

    public int getHandValue(){
        if(this.cards.size() > 0){
            int handValue = 0;
            for(Card card: cards){
                handValue += card.getRank();
            }
            this.handValue = handValue;
        }
        return this.handValue;
    }

    public boolean twistOrStick(){
        return this.handValue < 16;
    }
}
