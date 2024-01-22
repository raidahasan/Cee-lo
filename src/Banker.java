public class Banker {
    public static int bankerPoints;
    public static int bankerCoins = 1000;
    static boolean go = false;
    static boolean winOrLose = false;
    public static boolean getGo(){return go;}
    public static boolean getwinOrLose(){return winOrLose;}


    //determines results of banker's rolls
    public static void turn(){
        Die die = new Die();
        boolean g = true;
        while(g) {
            die.rollThree();
            die.printThree();
            try {
                Thread.sleep(2250);
            } catch (Exception e) {
                System.out.println("error");
            }
            if (die.determine().equals("true")) {
                bankerCoins += Ceelo.getTotalWager();
                die.determine();
                go = false;
                winOrLose = true;
                g = false;
            } else if (die.determine().equals("false")) {
                bankerCoins -= Ceelo.getTotalWager();
                die.determine();
                go = false;
                winOrLose = false;
                g = false;
            } else if (die.determine().equals("score")) {
                bankerPoints = 0;
                die.determine();
                System.out.println("Banker score added\n");
                go = true;
                g = false;
            } else if (die.determine().equals("reroll")) {
                System.out.println("Banker reroll");
            }
        }
    }
}
