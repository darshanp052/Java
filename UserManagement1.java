//import java.util.Scanner;
//
//interface UserOperations {
//    void addUser(new user);
//    void removeUserById(int id);
//    void updateUser(int id, int newId, String newName, int newAge, String newMobile, String newMail);
//    void printUsers();
//}
//
//public class UserManagement1 implements UserOperations {
//    public static final int DEFAULT_CAPACITY = 10;
//    public User[] users;
//    public int size;
//
//    public UserManagement1() {
//        users = new User[DEFAULT_CAPACITY];
//        size = 0;
//    }
//
//    @Override
//    public void addUser(new user) {
//        if (size == users.length) {
//            expandCapacity();
//        }
//        users[size++] = user;
//    }
//
//    @Override
//    public void removeUserById(int id) {
//        int indexToRemove = -1;
//        for (int i = 0; i < size; i++) {
//            if (users[i].getId() == id) {
//                indexToRemove = i;
//                break;
//            }
//        }
//        if (indexToRemove != -1) {
//            removeUserByIndex(indexToRemove);
//        } else {
//            System.out.println("User with ID " + id + " not found.");
//        }
//    }
//
//    @Override
//    public void updateUser(int id, int newId, String newName, int newAge, String newMobile, String newMail) {
//        for (int i = 0; i < size; i++) {
//            if (users[i].getId() == id) {
//                if (newId != id && isIdExists(newId)) {
//                    System.out.println("ID " + newId + " already exists.");
//                    return;
//                }
//                users[i].setId(newId);
//                users[i].setName(newName);
//                users[i].setAge(newAge);
//                try {
//                    users[i].setMobile(newMobile);
//                    users[i].setMail(newMail);
//                } catch (IllegalArgumentException e) {
//                    System.out.println(e.getMessage());
//                    return;
//                }
//                return;
//            }
//        }
//        System.out.println("User with ID " + id + " not found.");
//    }
//
//    @Override
//    public void printUsers() {
//        System.out.println("User List:");
//        for (int i = 0; i < size; i++) {
//            System.out.println(users[i]);
//        }
//    }
//
//    public void removeUserByIndex(int index) {
//        for (int i = index; i < size - 1; i++) {
//            users[i] = users[i + 1];
//        }
//        users[size - 1] = null;
//        size--;
//    }
//
//    public void expandCapacity() {
//        int newCapacity = users.length * 2;
//        User[] newArray = new User[newCapacity];
//        System.arraycopy(users, 0, newArray, 0, size);
//        users = newArray;
//    }
//
//    public boolean isIdExists(int id) {
//        for (int i = 0; i < size; i++) {
//            if (users[i].getId() == id) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public static class new {
//        public static int lastAssignedId = 0;
//        public int id;
//        public String name;
//        public int age;
//        public String mobile;
//        public String mail;
//
//        public new(String name, int age, String mobile, String mail) {
//            this.id = ++lastAssignedId;
//            this.name = name;
//            this.age = age;
//            try {
//                this.mobile = validateMobileNumber(mobile);
//                this.mail = validateEmail(mail);
//            } catch (IllegalArgumentException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//
//        private String validateMobileNumber(String mobile) {
//            if (mobile.matches("\\d{10}")) {
//                return mobile;
//            } else {
//                throw new IllegalArgumentException("Invalid mobile number format");
//            }
//        }
//
//        private String validateEmail(String email) {
//            if (email.matches("\\w+@\\w+\\.\\w+")) {
//                return email;
//            } else {
//                throw new IllegalArgumentException("Invalid email format");
//            }
//        }
//
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public int getAge() {
//            return age;
//        }
//
//        public void setAge(int age) {
//            this.age = age;
//        }
//
//        public String getMobile() {
//            return mobile;
//        }
//
//        public void setMobile(String mobile) {
//            try {
//                this.mobile = validateMobileNumber(mobile);
//            } catch (IllegalArgumentException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//
//        public String getMail() {
//            return mail;
//        }
//
//        public void setMail(String mail) {
//            try {
//                this.mail = validateEmail(mail);
//            } catch (IllegalArgumentException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//
//        @Override
//        public String toString() {
//            return "ID: " + id + " | Name: " + name + " | Age: " + age + " | Mobile No. :" + mobile + " | Mail Id :" + mail;
//        }
//    }
//
//    public static void main(String[] args) {
//        UserOperations userManager = new UserManagement1();
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Welcome to the Program");
//
//        while (true) {
//            System.out.println("\nChoose any option:");
//            System.out.println("1. Add User");
//            System.out.println("2. Delete User");
//            System.out.println("3. Update User");
//            System.out.println("4. Print Users");
//            System.out.println("5. Exit");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (choice) {
//                case 1:
//                    System.out.print("Enter user name: ");
//                    String name = scanner.nextLine();
//                    System.out.print("Enter user age: ");
//                    int age = scanner.nextInt();
//                    scanner.nextLine();
//                    System.out.print("Enter user Mobile No. : ");
//                    String mobile = scanner.nextLine();
//                    System.out.print("Enter Mail Id : ");
//                    String mail = scanner.nextLine();
//                    userManager.addUser(new User(name, age, mobile, mail));
//                    break;
//                case 2:
//                    System.out.print("Enter the ID of the user to delete: ");
//                    int idToDelete = scanner.nextInt();
//                    userManager.removeUserById(idToDelete);
//                    break;
//                case 3:
//                    System.out.print("Enter the ID of the user to update: ");
//                    int idToUpdate = scanner.nextInt();
//                    scanner.nextLine();
//                    System.out.print("Enter new ID: ");
//                    int newId = scanner.nextInt();
//                    scanner.nextLine();
//                    System.out.print("Enter new name: ");
//                    String newName = scanner.nextLine();
//                    System.out.print("Enter new age: ");
//                    int newAge = scanner.nextInt();
//                    scanner.nextLine();
//                    System.out.print("Enter new mobile number: ");
//                    String newMobile = scanner.nextLine();
//                    System.out.print("Enter new mail id: ");
//                    String newMail = scanner.nextLine();
//                    userManager.updateUser(idToUpdate, newId, newName, newAge, newMobile, newMail);
//                    break;
//                case 4:
//                    userManager.printUsers();
//                    break;
//                case 5:
//                    System.out.println("Exit the Program......");
//                    scanner.close();
//                    System.exit(0);
//                    break;
//                default:
//                    System.out.println("Invalid choice.");
//            }
//        }
//    }
//}
