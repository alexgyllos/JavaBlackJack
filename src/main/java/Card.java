public class Card {

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit(){
        return this.suit.getSuit();
    }

    public int getRank() {
        return this.rank.getRank();
    }
}
