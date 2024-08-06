# Taking-Library-Management-Further

## Project Description
Create a Book class with the following attributes:

- title (String)
- author (String)
- publicationYear (int)
- pages (int)

Implement a Library class that maintains a list of books and provides the following functionality:

- Add a book to the library.
- Remove a book from the library by title.
- Find all books published in a specific year.
- Find all books by a specific author.
- Find the book with the most pages.
- Find all books with more than n pages.
- Print all book titles in the library, sorted alphabetically.
- Update the Book class to include a category attribute (String). Categories could be things like "Fiction", "Non-Fiction", "Science", "History", etc. Add functionality to the Library class to find all books in a specific category.
- Implement a system to keep track of which books are currently on loan. This could involve adding a isOnLoan attribute to the Book class, and methods to the Library class to loan out a book and return a book. The library should not be able to loan out a book that is already on loan.
- Implement a User class, and allow users to register with the library. The User class should contain attributes like name, libraryCardNumber, and a List of Book objects to represent the books currently on loan to that user.
- If a book is not returned within 2 weeks, the user should start accruing late fees. Implement a system to track and calculate these fees.
- Use Java's built-in functional interfaces such as Predicate, Function, Consumer, and Supplier in your implementation.
