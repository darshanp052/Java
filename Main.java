import java.util.Scanner; // Import Scanner class for user input
import java.util.Arrays; // Import Arrays class for array manipulation
import java.util.ArrayList; // Import ArrayList class for dynamic arrays
import java.util.List; // Import List interface for lists
import java.util.Collections; // Import Collections class for sorting
import java.util.concurrent.*; // Import concurrent package for multitheading

// Define a class
public class Main {
    
    // Define variables
    int variableDataType;
    String literals;
    
    // Define methods
    public void method() {
        // Code goes here
    }
    
    // Define a constructor
    public Main(int var) {
        this.variableDataType = var;
    }
    
    // Define main method
    public static void main(String[] args) {
        // Variable data types
        int num = 10;
        double decimalNum = 10.5;
        char character = 'a';
        boolean isTrue = true;
        
        // Literals
        String strLiteral = "Hello";
        int intLiteral = 5;
        char charLiteral = 'A';
        
        // User input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int userInput = scanner.nextInt();
        
        // Operators
        int result = num + userInput;
        
        // Associativity and precedence
        int equation = 2 + 3 * 5;
        
        // Increment & Decrement
        int x = 5;
        x++; // Increment
        x--; // Decrement
        
        // Strings
        String str = "Java";
        String str2 = new String("Programming");
        
        // String methods
        int length = str.length();
        String upperCase = str.toUpperCase();
        
        // Escape sequences
        String escape = "This is a \"quote\"";
        
        // Conditionals
        if (num > 0) {
            System.out.println("Positive");
        } else if (num < 0) {
            System.out.println("Negative");
        } else {
            System.out.println("Zero");
        }
        
        // Relational & Logical Operators
        if (num > 0 && num < 100) {
            System.out.println("Number is between 0 and 100");
        }
        
        // Switch Case
        int choice = 1;
        switch (choice) {
            case 1:
                System.out.println("Choice 1");
                break;
            case 2:
                System.out.println("Choice 2");
                break;
            default:
                System.out.println("Default choice");
        }
        
        // Loop And Instruction
        for (int i = 0; i < 5; i++) {
            System.out.println("Iteration: " + i);
        }
        
        // Break And Continue
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                break; // exit the loop
            }
            if (i % 2 == 0) {
                continue; // skip the current iteration
            }
            System.out.println("Odd number: " + i);
        }
        
        // Arrays
        int[] array = {1, 2, 3, 4, 5};
        int[] newArray = new int[5];
        
        // Methods
        Main obj = new Main(10);
        obj.method();
        
        // Method Overloading
        obj.method(5);
        
        // Variables Arguments
        obj.method(1, 2, 3);
        
        // Recursion
        int factorial = factorial(5);
        
        // Object Oriented Programming
        // Creating Your Own Class
        // Access Modifiers, Getters and Setters
        // Constructors
        // Inheritance
        // Constructors in Inheritance
        // This and Super Keywords in Java
        // Method Overriding in Java
        // Dynamic Method Dispatch
        // Abstract Class and Abstract Methods
        // Introduction Of Interfaces
        // Abstract vs Interfaces
        // Default Methods
        
        // Interpreted vs Compiled languages
        // Packages
        // Creating Packages in Java
        
        // Multithreading in Java
        Thread thread = new Thread();
        thread.start();
        
        // Thread Runnable reference
        Runnable runnable = () -> {
            // Code to run in a separate thread
        };
        Thread thread2 = new Thread(runnable);
        thread2.start();
        
        // Lifecycle of thread
        // Constructors Form Thread Class
        // Java Thread Priorities
        // Threads Methods
        
        // Error And Exception
        try {
            // Code that may throw an exception
            int division = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        } finally {
            // Code that always runs, regardless of whether an exception occurred or not
        }
        
        // Handling Specific Exceptions
        // Nested Try-Catch
        // Exception Class
        // Throw Vs Throws
        // Finally Blocks In Java
        
        // Java Collections Framework
        // Lists
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        
        // Sets
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        
        // Maps
        Map<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
    }
    
    // Factorial method using recursion
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    
    // Method Overloading
    public void method(int num) {
        // Code goes here
    }
    
    // Variables Arguments
    public void method(int... nums) {
        // Code goes here
    }
}
