public class Player {
    int coins = 700;
    String name = "";
    public Player(String name){
        coins = 700;
        this.name = name;
    }
    public void turn(){
        Die die = new Die();
        die.rollThree();
        die.printThree();
    }
}
