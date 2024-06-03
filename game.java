import java.util.Scanner;
import java.util.Random;

class game{
    public static void main(String []args){
    
    Scanner sc =new Scanner(System.in);
    System.out.println("Enter Your Choise : (0 for Rock, 1 for Paper, 2 for Scissor) ");
    int UserInput = sc.nextInt();

    Random random = new Random();
    int ComputerInput = random.nextInt(3);

    if (UserInput==ComputerInput){
        System.out.println("Draw");
    }
    else if(UserInput == 0 && ComputerInput == 2 || UserInput == 1 && ComputerInput == 0 || ComputerInput == 1 && UserInput == 2)
    {
        System.out.println("You Win !!");
    }
    else
    {
        System.out.println("Computer Win !!");
    }
    System.out.print("Computers Choise is: ");
    if (ComputerInput == 0){
        System.out.println("Rock");
    }
    else if(ComputerInput == 1){
        System.out.println("Paper");
    }
    else{
        System.out.println("Scissor");
    }
    }
}