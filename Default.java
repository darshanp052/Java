class Default{
    String fname = "Darshan";
    String lname = "Parmar";
    String email = "darshanparmrar052@gmail.com";
    int age = 24;
    
    public static void main(String[] args) {
      Default myObj = new Default();
      System.out.println("Name: " + myObj.fname + " " + myObj.lname);
      System.out.println("Email: " + myObj.email);
      System.out.println("Age: " + myObj.age);
    }
  }