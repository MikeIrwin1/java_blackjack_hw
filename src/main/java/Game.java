public class Game {

    private Dealer dealer;
    private Player player;

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
}
