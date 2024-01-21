public class Player {
    int coins = 700;
    String name = "";
    int currentAmountWagered;
    int playerPoints;
    Die die = new Die();

    public Player(String name){
        coins = 700;
        this.name = name;
        playerPoints = 0;
    }
    public String getName(){
        return name;
    }
    public int getCoins(){
        return coins;
    }
    public int getCurrentAmountWagered(){
        return currentAmountWagered;
    }
    public void setWager(int wagered){
        currentAmountWagered = wagered;
    }
    public void setPlayerPoints(int points){
        playerPoints = points;
    }
    public void addCoins(int addOrSub){
        coins += addOrSub;
    }

}
