package service;
import model.*;
import java.time.LocalDate;
import java.util.*;
public class LibraryService {
   private List<Book> books = new ArrayList<>();
   private List<User> users = new ArrayList<>();
   private List<Transaction> transactions = new ArrayList<>();
   public void addBook(Book book) {
       books.add(book);
   }
   public void registerUser(User user) {
       users.add(user);
   }
   public void searchBook(String keyword) {
       books.stream()
               .filter(b -> b.getTitle().toLowerCase().contains(keyword.toLowerCase())
                       || b.getAuthor().toLowerCase().contains(keyword.toLowerCase()))
               .forEach(System.out::println);
   }
   public void issueBook(int bookId, int userId) {
       Book book = books.stream().filter(b -> b.getId() == bookId && !b.isIssued()).findFirst().orElse(null);
       User user = users.stream().filter(u -> u.getUserId() == userId).findFirst().orElse(null);
       if (book != null && user != null) {
           book.issue();
           Transaction t = new Transaction(book, user, LocalDate.now(), LocalDate.now().plusDays(14));
           transactions.add(t);
           System.out.println("Book issued successfully.");
       } else {
           System.out.println("Issue failed.");
       }
   }
   public void returnBook(int bookId) {
       for (Transaction t : transactions) {
           if (t.toString().contains(String.valueOf(bookId))) {
               t.returnBook(LocalDate.now());
               t.book.returnBook();
               System.out.println("Fine: ₹" + t.calculateFine());
               return;
           }
       }
       System.out.println("Transaction not found.");
   }
}