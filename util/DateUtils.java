package util;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class DateUtils {
   private static final int DEFAULT_LOAN_DAYS = 14;
   private static final int FINE_PER_DAY = 5;
   // Get due date based on issue date
   public static LocalDate getDueDate(LocalDate issueDate) {
       return issueDate.plusDays(DEFAULT_LOAN_DAYS);
   }
   // Calculate fine based on due date and return date
   public static long calculateFine(LocalDate dueDate, LocalDate returnDate) {
       if (returnDate.isAfter(dueDate)) {
           long lateDays = ChronoUnit.DAYS.between(dueDate, returnDate);
           return lateDays * FINE_PER_DAY;
       }
       return 0;
   }
}