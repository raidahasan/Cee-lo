public class Banker {
    public static int bankerPoints;
    public static int bankerCoins = 1000;
    static boolean win = false;
    public static boolean getWin(){return win;}
    public static void turn(){
        Die die = new Die();
        die.rollThree();
        die.printThree();
        if (die.determine().equals("true")) {
            bankerCoins += Ceelo.getTotalWager();
            die.determine();
            win = true;
        } else if (die.determine().equals("false")) {
            bankerCoins -= Ceelo.getTotalWager();
            die.determine();
            win = false;
        }else if(die.determine().equals("score")){
            die.determine();
        } else if(die.determine().equals("reroll")){
            die.rollThree();
            die.printThree();
        }else{

        }

    }
}
