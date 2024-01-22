import java.util.Scanner;
public class Ceelo {
    Player p1;
    Player p2;
    Player p3;
    Scanner scan = new Scanner(System.in);
    private static int totalWager;
    private boolean gameRunning = true;
    Die die = new Die();

    public Ceelo(){
        totalWager = 0;
        introduce();
        play();

    }


    public static int getTotalWager(){return totalWager;}
    public void play() {
        totalWager = 0;
        enterBets();
        System.out.println("\nYou are all starting with 700 coins \n");
        System.out.println("The Banker's turn");
        Banker.turn();
        printInfo();
        if (Banker.getGo()) {
            while (Banker.bankerCoins > 0 && (p1.getCoins() > 0 || p2.getCoins() > 0 || p3.getCoins() > 0)) {
                if (p1.getCoins() > 0) {
                    System.out.println(p1.getName() + "'s turn");
                    playerTurn(p1);
                    System.out.println(p1.getName() + " Coins : " + p1.getCoins() + "\n" + p1.getName() + " Points : " + p1.playerPoints);
                }
                if (p2.getCoins() > 0) {
                    System.out.println(p2.getName() + "'s turn");
                    playerTurn(p2);
                    System.out.println(p2.getName() + " Coins : " + p2.getCoins() + "\n" + p2.getName() + " Points : " + p2.playerPoints);
                }
                if (p3.getCoins() > 0) {
                    System.out.println(p3.getName() + "'s turn");
                    playerTurn(p3);
                    System.out.println(p3.getName() + " Coins : " + p3.getCoins() + "\n" + p3.getName() + " Points : " + p3.playerPoints);

                }
                if(p1.getCoins()<=0 && p2.getCoins()<=0 && p3.getCoins()<=0){
                    System.exit(0);
                }
                if(Banker.bankerCoins>0) {
                    printInfo();
                    totalWager = 0;
                    enterBets();
                    System.out.println("The Banker's turn");
                    Banker.turn();
                }else{
                    System.exit(0);
                    break;
                }
            }
            if (p1.getCoins() > p2.getCoins() && p1.getCoins() > p2.getCoins()) {
                System.out.println("You broke the bank! " + p1.getName() + " wins!");
                System.exit(0);
            } else if (p2.getCoins() > p3.getCoins() && p2.getCoins() > p1.getCoins()) {
                System.out.println("You broke the bank! " + p2.getName() + " wins!");
                System.exit(0);
            } else if (p3.getCoins() > p2.getCoins() && p3.getCoins() > p1.getCoins()) {
                System.out.println("You broke the bank! " + p3.getName() + " wins!");
                System.exit(0);
            } else {
                System.out.println("You broke the bank! There is a tie between players ");
                System.exit(0);
            }
        }else if(Banker.getwinOrLose()){
            System.out.println("The Banker won");
            p1.addCoins(p1.getCurrentAmountWagered()*-1);
            p2.addCoins(p2.getCurrentAmountWagered()*-1);
            p3.addCoins(p3.getCurrentAmountWagered()*-1);
        }else{
            System.out.println("The Banker lost");
        }
    }

    public void enterBets(){
        System.out.println("Enter your bets \n");
        if (p1.getCoins() > 0) {
            System.out.print(p1.getName() + ": ");
            int wager = scan.nextInt();
            p1.setWager(wager);
            totalWager = wager;
        }
        if (p1.getCoins() > 0) {
            System.out.print(p2.getName() + ": ");
            int wager = scan.nextInt();
            totalWager += wager;
            p2.setWager(wager);
        }
        if (p1.getCoins() > 0) {
            System.out.print(p3.getName() + ": ");
            int wager = scan.nextInt();
            totalWager += wager;
            p3.setWager(wager);
        }
    }

    public void introduce(){
        System.out.print("Player 1, enter your name: ");
        String name = scan.nextLine();
        p1 = new Player(name);
        System.out.print("Player 2, enter your name: ");
        name = scan.nextLine();
        p2 = new Player(name);
        System.out.print("Player 2, enter your name: ");
        name = scan.nextLine();
        p3 = new Player(name);
    }
    public void playerTurn(Player player){
        Die die = new Die();
        boolean result = true;
        while (result) {
            die.rollThree();
            die.printThree();
            if (die.determine(player).equals("true")) {
                die.determine(player);
                player.addCoins(player.getCurrentAmountWagered()*2);
                Banker.bankerCoins -= player.getCurrentAmountWagered();
                System.out.println( player.getName() + " won their wager!");
                result = false;
                break;
            } else if (die.determine(player).equals("false")) {
                System.out.println( player.getName() + " lost their wager");
                player.addCoins(player.getCurrentAmountWagered() * -1);
                Banker.bankerCoins += player.getCurrentAmountWagered();
                die.determine(player);
                result = false;
                break;
            }else if(die.determine(player).equals("score")){
                die.determine(player);
                if(player.playerPoints>=Banker.bankerPoints){
                    System.out.println(player.getName() + " wins wager");
                    player.addCoins(player.getCurrentAmountWagered()*2);
                    Banker.bankerCoins -= player.currentAmountWagered;
                    result = false;
                    break;
                }else{
                    System.out.println("Banker wins wager");
                    Banker.bankerCoins += player.currentAmountWagered;
                    player.addCoins(player.currentAmountWagered*-1);
                    result = false;
                    break;
                }
            } else {
                System.out.println("Player Reroll");
            }
        }
    }
    public void printInfo(){
        System.out.println("Banker Coins :  " + Banker.bankerCoins + "\nBanker Points: " + Banker.bankerPoints);
        System.out.println(p1.getName() + " Coins : " + p1.getCoins() + "\n" + p1.getName() + " Points : " + p1.playerPoints);
        System.out.println(p2.getName() + " Coins : " + p2.getCoins() + "\n" + p2.getName() + " Points : " + p2.playerPoints);
        System.out.println(p3.getName() + " Coins : " + p3.getCoins() + "\n" + p3.getName() + " Points : " + p3.playerPoints);
    }
}
