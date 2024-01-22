import java.util.Scanner;
public class Ceelo {
    Player p1;
    Player p2;
    Player p3;
    Scanner scan = new Scanner(System.in);
    private static int totalWager;
    boolean dcj = true;
    private static int topScore;
    Die die = new Die();

    public Ceelo() {
        while(dcj) {
            totalWager = 0;
            System.out.println("\n      Main Menu\n. . . . . . . . . . .\n" + "Top Score: " + topScore + " coins");
            System.out.println("Enter 'G' to play new game");
            System.out.println("Enter 'Q' to quit");
            String enter = scan.nextLine();
            enter = enter.toLowerCase();
            if (enter.equals("g")) {
                introduce();
                Banker.bankerCoins = 1000;
                System.out.println("\nYou are all starting with 700 chips ");
                play();
            } else {
                System.exit(0);
            }
        }
    }

    public static int getTotalWager(){return totalWager;}
    public void play() {
        totalWager = 0;
        enterBets();
        System.out.println("\nThe Banker's turn");
        Banker.turn();
        if (Banker.getGo()) {
            while (Banker.bankerCoins > 0 && (p1.getCoins() > 0 || p2.getCoins() > 0 || p3.getCoins() > 0)) {
                if (p1.getCoins() > 0) {
                    System.out.println("\n"  + p1.getName() + "'s turn");
                    playerTurn(p1);
                    System.out.println("\n" + p1.getName() + " Chips : " + p1.getCoins() + "\n" + p1.getName() + " Points : " + p1.playerPoints + "\n");
                }
                if (p2.getCoins() > 0) {
                    System.out.println("\n" +p2.getName() + "'s turn");
                    playerTurn(p2);
                    System.out.println("\n" + p2.getName() + " Chips : " + p2.getCoins() + "\n" + p2.getName() + " Points : " + p2.playerPoints + "\n");
                }
                if (p3.getCoins() > 0) {
                    System.out.println("\n" + p3.getName() + "'s turn");
                    playerTurn(p3);
                    System.out.println("\n" + p3.getName() + " Chips : " + p3.getCoins() + "\n" + p3.getName() + " Points : " + p3.playerPoints + "\n");

                }
                if(p1.getCoins()<=0 && p2.getCoins()<=0 && p3.getCoins()<=0){
                    printInfo();
                }
                if(Banker.bankerCoins>0) {
                    printInfo();
                    totalWager = 0;
                    enterBets();
                    System.out.println("\nThe Banker's turn");
                    Banker.turn();
                }
            }
            if (p1.getCoins() > p2.getCoins() && p1.getCoins() > p2.getCoins()) {
                System.out.println("You broke the bank! " + p1.getName() + " wins!");
                if(p1.getCoins()>topScore){
                    topScore = p1.getCoins();
                }
            } else if (p2.getCoins() > p3.getCoins() && p2.getCoins() > p1.getCoins()) {
                System.out.println("You broke the bank! " + p2.getName() + " wins!");
                if(p2.getCoins()>topScore){
                    topScore = p2.getCoins();
                }
            } else if (p3.getCoins() > p2.getCoins() && p3.getCoins() > p1.getCoins()) {
                System.out.println("You broke the bank! " + p3.getName() + " wins!");
                if(p3.getCoins()>topScore){
                    topScore = p3.getCoins();
                }
            }else if((p1.getCoins()<=0 && p2.getCoins()<=0 && p3.getCoins()<=0) && Banker.bankerCoins>0) {
                printInfo();
                System.out.println("The Banker won\n");
            }else{
                System.out.println("You broke the bank! There is a tie between players ");
                printInfo();
                if(p1.getCoins()==p2.getCoins()){
                    if(p2.getCoins()>topScore){
                        topScore = p2.getCoins();
                    }
                }else if(p1.getCoins()==p3.getCoins()){
                    if(p3.getCoins()>topScore){
                        topScore = p3.getCoins();
                    }
                }else{
                    if(p2.getCoins()>topScore){
                        topScore = p2.getCoins();
                    }
                }
            }
        }else if(Banker.getwinOrLose()){
            System.out.println("The Banker won\n");
            p1.addCoins(p1.getCurrentAmountWagered()*-1);
            p2.addCoins(p2.getCurrentAmountWagered()*-1);
            p3.addCoins(p3.getCurrentAmountWagered()*-1);
            printInfo();
        }
    }

    public void enterBets(){
        System.out.println("\nEnter your bets \n");
        if (p1.getCoins() > 0) {
            System.out.print(p1.getName() + ": ");
            int wager = scan.nextInt();
            scan.nextLine();
            if(wager>p1.getCoins()){
                wager = p1.getCoins();
            }
            p1.setWager(wager);
            totalWager = wager;
        }
        if (p2.getCoins() > 0) {
            System.out.print(p2.getName() + ": ");
            int wager = scan.nextInt();
            scan.nextLine();
            if(wager>p2.getCoins()){
                wager = p2.getCoins();
            }
            totalWager += wager;
            p2.setWager(wager);
        }
        if (p3.getCoins() > 0) {
            System.out.print(p3.getName() + ": ");
            int wager = scan.nextInt();
            scan.nextLine();
            if(wager>p3.getCoins()){
                wager = p3.getCoins();
            }
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
        System.out.print("Player 3, enter your name: ");
        name = scan.nextLine();
        p3 = new Player(name);
    }
    public void playerTurn(Player player){
        Die die = new Die();
        boolean result = true;
        while (result) {
            System.out.print("Enter key to roll: ");
            String reroll = scan.nextLine();
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
        System.out.println("\nBanker Chips :  " + Banker.bankerCoins + "\nBanker Points: " + Banker.bankerPoints);
        if(p1.getCoins()>0){
            System.out.println("\n" + p1.getName() + " Chips : " + p1.getCoins() + "\n" + p1.getName() + " Points : " + p1.playerPoints);
        }else{
            System.out.println(p1.getName() + " is out of the game");
        }
        if(p2.getCoins()>0){
            System.out.println("\n" + p2.getName() + " Chips : " + p2.getCoins() + "\n" + p2.getName() + " Points : " + p2.playerPoints);

        }else{
            System.out.println(p2.getName() + " is out of the game");
        }
        if(p3.getCoins()>0){
            System.out.println("\n" + p3.getName() + " Chips : " + p3.getCoins() + "\n" + p3.getName() + " Points : " + p3.playerPoints);

        }else{
            System.out.println(p3.getName() + " is out of the game");
        }
    }
}