import java.util.ArrayList;

public class Die {

    int res;
    static Die[] three = new Die[3];
    public Die(){
        res = (int)(Math.random()*6)+1;
    }

    public int getRoll(){return res;}
    public static Die[] getThreeRolls(){return three;}

    public static Die[] rollThree(){
        three[0]= new Die();
        three[1]= new Die();
        three[2]= new Die();
        return three;
    }
    public void printResult(){
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
            str+="│  ○   ○  │\n│         │\n│  ○   ○  │";
        }else{
            str+="│  ○   ○  │\n│  ○   ○  │\n│  ○   ○  │";
        }
        str+="\n───────────\n";
        System.out.println(str);
    }

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
            str+="│  ○   ○  │\n│         │\n│  ○   ○  │";
        }else{
            str+="│  ○   ○  │\n│  ○   ○  │\n│  ○   ○  │";
        }
        str+="\n───────────\n";
        System.out.println(str);
    }

    public void printThree(){
        printResult(three[0].getRoll());
        printResult(three[1].getRoll());
        printResult(three[2].getRoll());
    }

    public String determine(){
        String str = "";
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(three[0].getRoll());
        list.add(three[1].getRoll());
        list.add(three[2].getRoll());
        if(list.contains("4")&&list.contains("5")&&list.contains("6")){
            str = "true";
        }else if((list.get(0)==list.get(1)) && (list.get(2)==list.get(1))){
            str = "true";
        }else if(list.contains("1")&&list.contains("2")&&list.contains("3")){
            str = "false";
        }else if((list.get(0)==list.get(1))){
            Banker.bankerPoints += list.get(2);
            str = "false";
        }else if((list.get(1)==list.get(2))) {
            Banker.bankerPoints += list.get(0);
            str = "false";
        }else if((list.get(0)==list.get(2))) {
            Banker.bankerPoints += list.get(1);
            str = "false";
        }else{
            str = "reroll";
        }
        return str;
    }
}
