public class Game {

    private Dealer dealer;
    private Player player;
    private Deck deck;

    public Game(Dealer dealer, Player player) {
        this.dealer = dealer;
        this.player = player;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public Player getPlayer() {
        return player;
    }

    public void setupRound(){

        for(int i = 0; i<2; i++){
            Card cardi = dealer.drawCard();
            dealer.dealCard(player, cardi);
        }
        for(int j = 0; j<2; j++){
            Card cardj = dealer.drawCard();
            dealer.retainCard(cardj);
        }
    }
}
