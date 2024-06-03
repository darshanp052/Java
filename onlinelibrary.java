class Library{
    String[] books;
    int no_of_books;
    
    Library(){
        this.books = new String[100];
        this.no_of_books=0;
    }
    void addBook(String book){
        this.books[no_of_books]= book;
        no_of_books++;
        System.out.println(book +"has been added !");
    }
    void showAvailableBooks(){
        System.out.println("Avilable Books are: ");
        for (String book : this.books){
            System.out.println("*" + book);
            if (book == null){
                break;
            }
        }
    }
    void issueBook(String book){
        for (int i=0;i<this.books.length;i++){
            if (this.books[i].equals(book)){
                System.out.println("The book has been issued!");
                this.books[i] = null;
                return;
            }
        }
        System.out.println("This book does not exist");
    }

    void returnBook(String book){
        addBook(book);
    }
}

class onlinelibrary{
    public static void main(String []args){

        Library centralLibrary = new Library();
        centralLibrary.addBook("The One Indian Girl");
        centralLibrary.addBook("Algorithms");
        centralLibrary.addBook("C++");
        centralLibrary.addBook("Java");
        centralLibrary.showAvailableBooks();

        centralLibrary.issueBook("C++");
        centralLibrary.showAvailableBooks();
        centralLibrary.returnBook("C++");
        centralLibrary.showAvailableBooks();
    }
}
