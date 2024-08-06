import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    private final String name;
    private final int libraryCardNumber;
    private final List<Book> booksOnLoan;

    public User(String name, int libraryCardNumber) {
        this.name = name;
        this.libraryCardNumber = libraryCardNumber;
        this.booksOnLoan = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getLibraryCardNumber() {
        return libraryCardNumber;
    }

    public List<Book> getBooksOnLoan() {
        return booksOnLoan;
    }

    public void borrowBook(Book book) {
        booksOnLoan.add(book);
    }

    public void returnBook(Book book) {
        booksOnLoan.remove(book);
    }

    public boolean hasOverdueBooks() {
        return booksOnLoan.stream().anyMatch(book -> book.getLoanDate().plusWeeks(2).isBefore(LocalDate.now()));
    }

    public double calculateLateFees() {
        return booksOnLoan.stream()
                .filter(book -> book.getLoanDate().plusWeeks(2).isBefore(LocalDate.now()))
                .mapToDouble(book -> LocalDate.now().toEpochDay() - book.getLoanDate().plusWeeks(2).toEpochDay())
                .sum() * 1.0; // 1 unit fee per day
    }

    @Override
    public String toString() {
        return name + " (Card: " + libraryCardNumber + ")";
    }
}
