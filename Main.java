public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 218, "Fiction"));
        library.addBook(new Book("A Brief History of Time", "Stephen Hawking", 1988, 212, "Science"));
        library.addBook(new Book("1984", "George Orwell", 1949, 328, "Fiction"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", 1960, 281, "Fiction"));

        User user1 = new User("Alice", 1);
        User user2 = new User("Bob", 2);
        library.registerUser(user1);
        library.registerUser(user2);

        library.loanBook("1984", user1);
        library.loanBook("The Great Gatsby", user2);

        library.returnBook("1984", user1);

        System.out.println("Books published in 1925: " + library.findBooksByYear(1925));
        System.out.println("Books by George Orwell: " + library.findBooksByAuthor("George Orwell"));
        System.out.println("Book with the most pages: " + library.findBookWithMostPages());
        System.out.println("Books with more than 250 pages: " + library.findBooksWithMoreThanNPages(250));
        System.out.println("All book titles sorted: " + library.getAllBookTitlesSorted());
        System.out.println("Books in Fiction category: " + library.findBooksByCategory("Fiction"));

        System.out.println("User1 overdue books: " + user1.hasOverdueBooks());
        System.out.println("User1 late fees: " + user1.calculateLateFees());

        library.printAllBooks();
    }
}
