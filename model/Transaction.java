package model;
import java.time.LocalDate;
public class Transaction {
   private Book book;
   private User user;
   private LocalDate issueDate;
   private LocalDate dueDate;
   private LocalDate returnDate;
   public Transaction(Book book, User user, LocalDate issueDate, LocalDate dueDate) {
       this.book = book;
       this.user = user;
       this.issueDate = issueDate;
       this.dueDate = dueDate;
   }
   public void returnBook(LocalDate returnDate) {
       this.returnDate = returnDate;
   }
   public long calculateFine() {
       if (returnDate != null && returnDate.isAfter(dueDate)) {
           return java.time.temporal.ChronoUnit.DAYS
                   .between(dueDate, returnDate) * 5;
       }
       return 0;
   }
}
