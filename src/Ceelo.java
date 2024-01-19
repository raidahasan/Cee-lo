import java.util.Scanner;
public class Ceelo {
    Player p1;
    Player p2;
    Player p3;
    Scanner scan = new Scanner();


    public void play(){
        System.out.println("Player 1, enter your name: ");
        String name = scan.nextLine();
        p1 = new Player(name);
        System.out.println("Player 2, enter your name: ");
        name = scan.nextLine();
        p2 = new Player(name);
        System.out.println("Player 2, enter your name: ");
        name = scan.nextLine();
        p3 = new Player(name);
        System.out.println("You are all starting with 700 coins \n");
    }

    public void placeBets(){
        System.out.println(" Enter your bets: \n");
        System.out.print(p1.getName() + ": ");
        int wager = scan.nextInt();
        p1.setWager(wager);
        System.out.print(p2.getName() + ": ");
        wager = scan.nextInt();
        p2.setWager(wager);
        System.out.print(p3.getName() + ": ");
        wager = scan.nextInt();
        p3.setWager(wager);
    }

}
