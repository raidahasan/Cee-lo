public class Die {

    int res;
    Die[] three = new Die[3];
    public Die(){
        res = (int)(Math.random()*6)+1;
    }

    public int getRoll(){return res;}
    public Die[] getThreeRolls(){return three;}

    public Die[] rollThree(){
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
}
