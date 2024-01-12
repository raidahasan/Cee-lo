public class Die {

    int res;
    int[] three = new int[3];
    public Die(){
        res = 0;
        three = new int[3];
    }

    public int getRoll(){return res;}
    public int[]getThreeRolls(){return three;}

    public int rollDie(){
        res = (int)(Math.random()*6)+1;
        return res;
    }

    public int[] rollThree(){
        three[0]=rollDie();
        three[1]=rollDie();
        three[2]=rollDie();
        return three;
    }
    public void printResult(){
        if(res ==1){
            System.out.println("\n * \n\n");
        }else if(res==2){
            System.out.println("*\n \n  *\n");
        }else if(res==3){
            System.out.println("*\n *\n  *\n");
        }else if(res==4){
            System.out.println("* *\n\n* *\n");
        }else if(res==5){
            System.out.println("* *\n *\n* *\n");
        }else{
            System.out.println("* *\n* *\n* *\n");
        }
    }

    public void printResult(int res){
        if(res ==1){
            System.out.println("\n * \n\n");
        }else if(res==2){
            System.out.println("*\n \n  *\n");
        }else if(res==3){
            System.out.println("*\n *\n  *\n");
        }else if(res==4){
            System.out.println("*  *\n\n*  *\n");
        }else if(res==5){
            System.out.println("*  *\n *\n*  *\n");
        }else{
            System.out.println("*  *\n*  *\n*  *\n");
        }
    }

    public void printThree(){
        printResult(three[0]);
        printResult(three[1]);
        printResult(three[2]);
    }
}
