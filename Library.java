import java.util.ArrayList;

class Book{
    public String name, author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return "\nBook{" +
                "Name='" + name + '\'' +
                ",Author='" + author + '\'' +
                '}';
    }
}

class MyLibrary{
    public ArrayList<Book> books;
    public MyLibrary(ArrayList<Book> books) {
        this.books = books;
    }
    public void addBook(Book book){
        System.out.println("The book has been added to the library");
        this.books.add(book);
    }
    public void issueBook(Book book, String issued_to){
        System.out.println("The book has been issued from the library to " + issued_to);
        this.books.remove(book);
    }
    public void returnBook(Book b){
        System.out.println("The book has been returned");
        this.books.add(b);
    }

}
public class Library {
    public static void main(String[] args) {
        // Exercise 7 Solution
        ArrayList<Book> bk = new ArrayList<>();
        Book b1 = new Book("Mathura", "Raghuvir Chaudhary");
        bk.add(b1);

        Book b2 = new Book("Dwarka", "Raghuvir Chaudhary");
        bk.add(b2);

        Book b3 = new Book("Valamana", "Pannalal Patel");
        bk.add(b3);

        Book b4 = new Book("Half Girlfriend", "Chetan Bhagat");
        bk.add(b4);
        MyLibrary l = new MyLibrary(bk);
        l.addBook(new Book("Gokul", "Raghuvir Chaudhary"));
        System.out.println(l.books);
        l.issueBook(b4, "Darshan");
        System.out.println(l.books);

    }
}
