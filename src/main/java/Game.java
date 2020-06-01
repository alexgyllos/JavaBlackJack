import java.util.ArrayList;

public class Game {

    private Deck deck;
    private ArrayList<Player> players;

    public Game(Deck deck){
        this.deck = deck;
        this.players = new ArrayList<Player>();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public int countPlayers(){
        return this.players.size();
    }

    public void dealCards(Deck deck) {
        for (Player player: players){

                Card card1 = deck.dealCard();
                Card card2 = deck.dealCard();
                player.addCard(card1);
                player.addCard(card2);
        }
    }

    public String checkSomebodyWins(Player player1, Player player2) {

            if(player1.getCard().getRank() > player2.getCard().getRank()){
                return "Player 1 wins";
            } else if (player1.getCard().getRank() < player2.getCard().getRank()){
                return "Player 2 wins";
            } else {
                return "It's a tie";
            }

    }

    public Player checkWhoWins(){
        Player winner = null;
        int biggestHand = 0;
        for(Player player: players){
            if (player.getHandValue() > 21) {
                players.remove(player);
            } else if (player.getHandValue() > biggestHand){
                biggestHand = player.getHandValue();
                winner = player;
            }
        }
        return winner;
    }


}
