import java.util.Scanner;

public class UserManagementApp implements UserOperations {
    private final UserManagement userManager;

    public UserManagementApp() {
        userManager = new UserManagement();
    }

    public static void main(String[] args) {
        UserManagementApp app = new UserManagementApp();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Program");

        while (true) {
            System.out.println("\nChoose any option:");
            System.out.println("1. Add User");
            System.out.println("2. Delete User");
            System.out.println("3. Update User");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    app.addUser();
                    break;
                case 2:
                    app.removeUserById();
                    break;
                case 3:
                    app.updateUser();
                    break;
                case 4:
                    System.out.println("Exiting the Program...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
            app.printUsers();

            try {
                Thread.sleep(5000);
                System.out.println("Choices are here....");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    @Override
    public void addUser() {
        userManager.addUser();
    }

    @Override
    public void removeUserById() {
        userManager.removeUserById();
    }

    @Override
    public void updateUser() {
        userManager.updateUser();
    }

    @Override
    public void printUsers() {
        userManager.printUsers();
    }
}

interface UserOperations {
    void addUser();
    void removeUserById();
    void updateUser();
    void printUsers();
}

class UserManagement implements UserOperations {
    private static final int DEFAULT_CAPACITY = 10;
    private User[] users;
    private int size;

    public UserManagement() {
        users = new User[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void addUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        System.out.print("Enter user age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter user Mobile No. : ");
        String mobile = scanner.nextLine();
        while (!mobile.matches("\\d{10}")) { // Assuming mobile number should be 10 digits
            System.out.print("Enter a Valid Mobile No. : ");
            mobile = scanner.nextLine();
        }
        System.out.print("Enter Mail Id : ");
        String mail = scanner.nextLine();
        while (!mail.matches("\\w+@\\w+\\.\\w+")) {
            System.out.print("Enter a valid Email Id : ");
            mail = scanner.nextLine();
        }
        addUser(new User(name, age, mobile, mail));
        System.out.println("Data has been Added");
    }

    @Override
    public void removeUserById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the user to delete: ");
        int idToDelete = scanner.nextInt();
        scanner.nextLine();
        removeUserById(idToDelete);
        System.out.println("Data Of ID has been deleted.....");
    }

    @Override
    public void updateUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the user to update: ");
        int idToUpdate = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new age: ");
        int newAge = scanner.nextInt();
        while (newAge <= 125 && newAge > 0) {
            System.out.print("Enter A Valid Age : ");
            newAge = scanner.nextInt();
        }
        scanner.nextLine();
        System.out.print("Enter new mobile number: ");
        String newMobile = scanner.nextLine();
        while (!newMobile.matches("\\d{10}")) { // Assuming mobile number should be 10 digits
            System.out.print("Enter A Valid new Mobile Number : ");
            newMobile = scanner.nextLine();
        }
        System.out.print("Enter new mail id: ");
        String newMail = scanner.nextLine();
        while (!newMail.matches("\\w+@\\w+\\.\\w+")) {
            System.out.print("Enter A Valid new Mail ID : ");
            newMail = scanner.nextLine();
        }
        updateUser(idToUpdate, newName, newAge, newMobile, newMail);
    }

    @Override
    public void printUsers() {
        System.out.println("User List:");
        for (int i = 0; i < size; i++) {
            System.out.println(users[i]);
        }
    }

    private void addUser(User user) {
        if (size == users.length) {
            expandCapacity();
        }
        users[size++] = user;
    }

    private void removeUserById(int id) {
        int indexToRemove = -1;
        for (int i = 0; i < size; i++) {
            if (users[i].getId() == id) {
                indexToRemove = i;
                break;
            }
        }
        if (indexToRemove != -1) {
            removeUserByIndex(indexToRemove);
        } else {
            System.out.println("User with ID " + id + " not found.");
        }
    }

    private void removeUserByIndex(int index) {
        for (int i = index; i < size - 1; i++) {
            users[i] = users[i + 1];
        }
        users[size - 1] = null;
        size--;
    }

    private void updateUser(int id, String newName, int newAge, String newMobile, String newMail) {
        for (int i = 0; i < size; i++) {
            if (users[i].getId() == id) {
                users[i].setName(newName);
                users[i].setAge(newAge);
                try {
                    users[i].setMobile(newMobile);
                    users[i].setMail(newMail);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    return;
                }
                return;
            }
        }
        System.out.println("User with ID " + id + " not found.");
    }

    private void expandCapacity() {
        int newCapacity = users.length * 2;
        User[] newArray = new User[newCapacity];
        System.arraycopy(users, 0, newArray, 0, size);
        users = newArray;
    }

    public static class User {
        private static int lastAssignedId = 0;
        private int id;
        private String name;
        private int age;
        private String mobile;
        private String mail;

        public User(String name, int age, String mobile, String mail) {
            this.id = ++lastAssignedId;
            this.name = name;
            this.age = age;
            try {
                this.mobile = validateMobileNumber(mobile);
                this.mail = validateEmail(mail);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            
            }
        }

        private String validateMobileNumber(String mobile) {
            if (mobile.matches("\\d{10}")) {
            } else {
                throw new IllegalArgumentException("Invalid mobile number format");
            }
        }

        private String validateEmail(String mail) {
            if (mail.matches("\\w+@\\w+\\.\\w+")) {
                return mail;
            } else {
                throw new IllegalArgumentException("Invalid email format");
            }
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            try {
                this.mobile = validateMobileNumber(mobile);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        public String getMail() {
            return mail;
        }

        public void setMail(String mail) {
            try {
                this.mail = validateEmail(mail);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        @Override
        public String toString() {
            return "ID: " + id + " | Name: " + name + " | Age: " + age + " | Mobile No. :" + mobile + " | Mail Id :" + mail;
        }
    }
}
