public class Private{
    private String fname="Darshan";
    private String lname="Parmar";
    private String mail="darshanparmar052@gmail.com";
    private int age = 20;
    
public static void main(String[] args){
    Private myObj = new Private();
    System.out.println("Name: " +myObj.fname+ " "+myObj.lname);
    System.out.println("Email: "+myObj.mail);
    System.out.println("Age: "+myObj.age);
    }
}