import java.util.ArrayList;

public class Die {

    int res;
    static Die[] three = new Die[3];
    ArrayList<Integer> list = new ArrayList<Integer>();

    public Die(){
        res = (int)(Math.random()*6)+1;
    }

    public int getRoll(){return res;}
    public static Die[] getThreeRolls(){return three;}

    public void rollThree(){
        three[0]= new Die();
        three[1]= new Die();
        three[2]= new Die();
    }

    //prints the value of the dice
    public void printResult(int res){
        String str = "───────────\n";
        if(res ==1){
            str+="│         │\n│    ○    │\n│         │";
        }else if(res==2){
            str+="│  ○      │\n│         │\n│      ○  │";
        }else if(res==3){
            str+="│  ○      │\n│    ○    │\n│      ○  │";
        }else if(res==4){
            str+="│  ○   ○  │\n│         │\n│  ○   ○  │";
        }else if(res==5){
            str+="│  ○   ○  │\n│    ○    │\n│  ○   ○  │";
        }else{
            str+="│  ○   ○  │\n│  ○   ○  │\n│  ○   ○  │";
        }
        str+="\n───────────\n";
        System.out.println(str);
    }

    //prints all three die
    public void printThree(){
        printResult(three[0].getRoll());
        printResult(three[1].getRoll());
        printResult(three[2].getRoll());
    }

    //determines the result of the banker's role accoridng to ceelo rules
    public String determine(){
        String str = "";
        list = new ArrayList<Integer>();
        list.add(three[0].getRoll());
        list.add(three[1].getRoll());
        list.add(three[2].getRoll());
        if(list.contains(4)&&list.contains(5)&&list.contains(6)){
            str = "true";
        }else if((three[0].getRoll()==three[1].getRoll()) && (three[2].getRoll()==three[1].getRoll()) && (three[2].getRoll()==three[0].getRoll())){
            str = "true";
        }else if(list.contains(1)&&list.contains(2)&&list.contains(3)){
            str = "false";
        }else if(three[0].getRoll()==three[1].getRoll()){
            Banker.bankerPoints = three[2].getRoll();
            str = "score";
        }else if(three[2].getRoll()==three[1].getRoll()) {
            Banker.bankerPoints = three[0].getRoll();
            str = "score";
        }else if(three[2].getRoll()==three[0].getRoll()) {
            Banker.bankerPoints = three[1].getRoll();
            str = "score";
        }else{
            str = "reroll";
        }
        return str;
    }

    //determines tbe result of the player's die based on the rules of ceelo
    public String determine(Player player){
        String str = "";
        list = new ArrayList<Integer>();
        list.add(three[0].getRoll());
        list.add(three[1].getRoll());
        list.add(three[2].getRoll());
        if(list.contains(4)&&list.contains(5)&&list.contains(6)){
            str = "true";
        }else if((three[0].getRoll()==three[1].getRoll()) && (three[2].getRoll()==three[1].getRoll()) && (three[2].getRoll()==three[0].getRoll())){
            str = "true";
        }else if(list.contains(1)&&list.contains(2)&&list.contains(3)){
            str = "false";
        }else if(three[0].getRoll()==three[1].getRoll()){
            player.setPlayerPoints(three[2].getRoll());
            str = "score";
        }else if(three[2].getRoll()==three[1].getRoll()) {
            player.setPlayerPoints(three[0].getRoll());
            str = "score";
        }else if(three[2].getRoll()==three[0].getRoll()) {
            player.setPlayerPoints(three[1].getRoll());
            str = "score";
        }else{
            str = "reroll";
        }
        return str;
    }
}
