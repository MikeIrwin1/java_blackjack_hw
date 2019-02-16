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

    public int checkPlayerHandValue() {

        return player.getHandValue();
    }

    public int checkDealerHandValue() {
        return dealer.getHandValue();
    }

    public Boolean checkDealerHandValid(){
        Boolean valid = false;
        int value = checkDealerHandValue();
        if(value >= 16){
            valid = true;
        }
        else {
            Card card = dealer.drawCard();
            dealer.retainCard(card);
        }
        return valid;
    }

    public String determineWinner() {
        int playerValue = checkPlayerHandValue();
        if (playerValue == 21 && player.getHand().size() == 2){
            return "Blackjack! player wins!";
        }
        int dealerValue = checkDealerHandValue();
        if(playerValue > dealerValue){
            return "player wins!";
        }
        else {
            return "dealer wins!";
        }
    }


}
