import java.util.ArrayList;
public class Rules {
    Die[] result = Die.getThreeRolls();


    public String determine(){
        String str = "";
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(result[0].getRoll());
        list.add(result[1].getRoll());
        list.add(result[2].getRoll());
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
