import java.util.Scanner;

public class UserManagement {
    public static final int DEFAULT_CAPACITY = 10;
    public User[] users;
    public int size;

    public UserManagement() {
        users = new User[DEFAULT_CAPACITY];
        size = 0;
    }

    public void addUser(User user) {
        if (size == users.length) {
            expandCapacity();
        }
        users[size++] = user;
    }

    public void removeUserById(int id) {
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

    public void removeUserByIndex(int index) {
        for (int i = index; i < size - 1; i++) {
            users[i] = users[i + 1];
        }
        users[size - 1] = null;
        size--;
    }

    public void updateUser(int id, int newId, String newName, int newAge, String newMobile, String newMail) {
        for (int i = 0; i < size; i++) {
            if (users[i].getId() == id) {
                // If the new ID is different from the old one, check if it conflicts with existing IDs
                if (newId != id && isIdExists(newId)) {
                    System.out.println("ID " + newId + " already exists.");
                    return;
                }
                users[i].setId(newId);
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

    public void printUsers() {
        System.out.println("User List:");
        for (int i = 0; i < size; i++) {
            System.out.println(users[i]);
        }
    }

    public void expandCapacity() {
        int newCapacity = users.length * 2;
        User[] newArray = new User[newCapacity];
        System.arraycopy(users, 0, newArray, 0, size);
        users = newArray;
    }

    public boolean isIdExists(int id) {
        for (int i = 0; i < size; i++) {
            if (users[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static class User {
        private static int lastAssignedId = 0; // Keep track of the last assigned ID
        private int id;
        private String name;
        private int age;
        private String mobile;
        private String mail;

        public User(int id, String name, int age, String mobile, String mail) {
            this.id = ++lastAssignedId; // Increment last assigned ID and use it as the current ID
            this.name = name;
            this.age = age;
            try {
                this.mobile = validateMobileNumber(mobile); // Validate mobile number format
                this.mail = validateEmail(mail); // Validate email format
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        private String validateMobileNumber(String mobile) {
            if (mobile.matches("\\d{10}")) { // Assuming mobile number should be 10 digits
                return mobile;
            } else {
                throw new IllegalArgumentException("Invalid mobile number format");
            }
        }

        private String validateEmail(String email) {
            if (email.matches("\\w+@\\w+\\.\\w+")) { // Assuming a basic email format
                return email;
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

    public static void main(String[] args) {
        UserManagement userManager = new UserManagement();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Program");

        while (true) {
            System.out.println("\nChoose any option:");
            System.out.println("1. Add User");
            System.out.println("2. Delete User");
            System.out.println("3. Update User");
            System.out.println("4. Print Users");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter user age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter user Mobile No. : ");
                    String mobile = scanner.nextLine();
                    System.out.print("Enter Mail Id : ");
                    String mail = scanner.nextLine();
                    userManager.addUser(new User(2, "mukesh", 192, "1234567890", "helo@bhosdiwala.com"));
                    System.out.println("Data has been Added");
                    break;
//                case 2:
//                    System.out.print("Enter the ID of the user to delete: ");
//                    int idToDelete = scanner.nextInt();
//                    userManager.removeUserById(idToDelete);
//                    System.out.println("Data Of ID has been deleted.....");
//                    break;
//                case 3:
//                    System.out.print("Enter the ID of the user to update: ");
//                    int idToUpdate = scanner.nextInt();
//                    scanner.nextLine();
//                    System.out.print("Enter Updated Name: ");
//                    String newName = scanner.nextLine();
//                    System.out.print("Enter Updated Age: ");
//                    int newAge = scanner.nextInt();
//                    scanner.nextLine();
//                    System.out.print("Enter Updated Mobile Number: ");
//                    String newMobile = scanner.nextLine();
//                    System.out.print("Enter Updated Mail Id: ");
//                    String newMail = scanner.nextLine();
//                    userManager.updateUser(idToUpdate, newName, newAge, newMobile, newMail);
//                    System.out.println("Data of  ID Has been Updated.....");
//                    break;

                case 4:
                    userManager.printUsers();
                    break;
                case 5:
                    System.out.println("Exit the Program......");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}