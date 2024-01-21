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
        play();
    }


    public static int getTotalWager(){return totalWager;}
    public void play(){
        introduce();
        System.out.println("You are all starting with 700 coins \n");
        placeBets();
        Banker.turn();
        if(!Banker.getWin()){
            while(Banker.bankerCoins>0 && (p1.getCoins()>0 || p2.getCoins()>0 || p3.getCoins()>0)){
                Banker.turn();
                if(p1.getCoins()>0){
                    playerTurn(p1);
                }
                if(p2.getCoins()>0){
                    playerTurn(p2);
                }
                if(p3.getCoins()>0){
                    playerTurn(p3);
                }
            }
            if(p1.getCoins()>p2.getCoins() && p1.getCoins()> p2.getCoins()){
                System.out.println("You broke the bank! " + p1.getName() + " wins!");
            }else if(p2.getCoins()>p3.getCoins() && p2.getCoins()> p1.getCoins()){
                System.out.println("You broke the bank! " + p2.getName()  + " wins!");
            }else if(p3.getCoins()>p2.getCoins() && p3.getCoins()> p1.getCoins()){
                System.out.println("You broke the bank! " + p3.getName() + " wins!");
            }else{
                System.out.println("You broke the bank! There is a tie between players ");
            }
        }else{
            System.out.println("The Banker won");
        }
    }

    public void placeBets(){
        System.out.println(" Enter your bets: \n");
        System.out.print(p1.getName() + ": ");
        int wager = scan.nextInt();
        p1.setWager(wager);
        totalWager = wager;
        System.out.print(p2.getName() + ": ");
        wager = scan.nextInt();
        totalWager+=wager;
        p2.setWager(wager);
        System.out.print(p3.getName() + ": ");
        wager = scan.nextInt();
        totalWager+=wager;
        p3.setWager(wager);
    }

    public void introduce(){
        System.out.println("Player 1, enter your name: ");
        String name = scan.nextLine();
        p1 = new Player(name);
        System.out.println("Player 2, enter your name: ");
        name = scan.nextLine();
        p2 = new Player(name);
        System.out.println("Player 2, enter your name: ");
        name = scan.nextLine();
        p3 = new Player(name);
    }
    public void playerTurn(Player player){
        die.rollThree();
        die.printThree();
        while (player.getCoins() > 0) {
            if (die.determine(player).equals("true")) {
                player.addCoins(player.getCoins()*2);
                System.out.println( player.getName() + " won their wager!");
                die.determine(player);
                break;
            } else if (die.determine(player).equals("false")) {
                System.out.println( player.getName() + " lost their wager");
                player.addCoins(player.getCoins() * -1);
                die.determine(player);
                break;
            }else if(die.determine(player).equals("score")){
                die.determine(player);
                System.out.println("Score added");
                break;
            } else {
                die.rollThree();
                die.printThree();
                System.out.println("reroll");
            }
        }
    }
}
