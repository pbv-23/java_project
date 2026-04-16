import model.*;
import service.LibraryService;
public class Main {
   public static void main(String[] args) {
       LibraryService service = new LibraryService();
       service.addBook(new Book(1, "Clean Code", "Robert Martin"));
       service.addBook(new Book(2, "Effective Java", "Joshua Bloch"));
       service.registerUser(new User(101, "Rohith"));
       service.searchBook("Java");
       service.issueBook(2, 101);
       service.returnBook(2);
   }
}
