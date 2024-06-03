import java.util.Scanner;
import java.util.Random;

class game{
    public int number;
    public int inputnumber;
    public int noOfGusses = 0;

    public int getNoOfGusses(){
        return noOfGusses;
    }

    public void setNoOfGusses(int noOfGusses){
        this.noOfGusses = noOfGusses;

    }
    
    game(){
        Random random  = new Random();
        this.number = random.nextInt(100);
    }

    void takeUserInput(){
        System.out.println("Guss The Number : ");
        Scanner sc = new Scanner (System.in);
        inputnumber = sc.nextInt();
    }
    boolean isCorrectNumber(){
        noOfGusses ++ ;
        if (inputnumber == number){
            System.out.format("Yes You gussed it right, it was %d and You Gussed it in %d attempts.", number, noOfGusses);
            return true;
        }
        else if(inputnumber<number){
            System.out.println("Too low.....");
        }
        else if (inputnumber>number){
            System.out.println("Too high.....");
        }
        return false;
    }

    }

class gussgame{
    public static void main (String []args){

        game g = new game();
        boolean b =false;
        while (!b){
        g.takeUserInput();
        b = g.isCorrectNumber();
        }
    }

}