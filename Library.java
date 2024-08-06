import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    public List<Book> findBooksByYear(int year) {
        return books.stream()
                .filter(book -> book.getPublicationYear() == year)
                .collect(Collectors.toList());
    }

    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public Book findBookWithMostPages() {
        return books.stream()
                .max(Comparator.comparingInt(Book::getPages))
                .orElse(null);
    }

    public List<Book> findBooksWithMoreThanNPages(int pages) {
        return books.stream()
                .filter(book -> book.getPages() > pages)
                .collect(Collectors.toList());
    }

    public List<String> getAllBookTitlesSorted() {
        return books.stream()
                .map(Book::getTitle)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Book> findBooksByCategory(String category) {
        return books.stream()
                .filter(book -> book.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public void loanBook(String title, User user) {
        Book book = books.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title) && !b.isOnLoan())
                .findFirst()
                .orElse(null);

        if (book != null) {
            book.setOnLoan(true);
            book.setLoanDate(LocalDate.now());
            user.borrowBook(book);
        } else {
            System.out.println("Book is not available for loan.");
        }
    }

    public void returnBook(String title, User user) {
        Book book = user.getBooksOnLoan().stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);

        if (book != null) {
            book.setOnLoan(false);
            book.setLoanDate(null);
            user.returnBook(book);
        } else {
            System.out.println("Book not found in user's loans.");
        }
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public User findUserByCardNumber(int cardNumber) {
        return users.stream()
                .filter(user -> user.getLibraryCardNumber() == cardNumber)
                .findFirst()
                .orElse(null);
    }

    public void printAllBooks() {
        books.forEach(System.out::println);
    }
}
