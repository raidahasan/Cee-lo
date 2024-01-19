public class Player {
    int coins = 700;
    String name = "";
    int currentAmountWagered;
    public Player(String name){
        coins = 700;
        this.name = name;
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
    public void addCoins(int addOrSub){
        coins += addOrSub;
    }
    public void turn(){
        Die die = new Die();
        die.rollThree();
        die.printThree();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("error");
        }
        if(die.determine().equals(true)){

        }
    }
}
