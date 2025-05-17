package lab4;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Library library = new Library();

        System.out.println("--- Тестирование добавления книг ---");
        Book book1 = new Book("book1", "author1", 1999);
        Book book2 = new Book("book2", "author2", 2000);
        Book book3 = new Book("book3", "author1", 1677);
        Book book4 = new Book("book4", "author2", 2011);
        Book book5 = new Book("book5", "author3", 2000);
        Book book6_duplicate = new Book("book1", "author1", 1999); // для теста удаления

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(null);
        library.addBook(book1);

        library.printAllBooks();

        library.printUniqueAuthors();

        library.printAuthorStatistics();

        System.out.println("\n--- Тестирование поиска книг по автору ---");
        String authorToFind = "author1";
        List<Book> booksByTolstoy = library.findBooksByAuthor(authorToFind);
        if (!booksByTolstoy.isEmpty()) {
            System.out.println("Книги автора '" + authorToFind + "':");
            booksByTolstoy.forEach(System.out::println);
        } else {
            System.out.println("Книги автора '" + authorToFind + "' не найдены.");
        }

        String nonExistentAuthor = "author7";
        List<Book> booksByPushkin = library.findBooksByAuthor(nonExistentAuthor);
        if (!booksByPushkin.isEmpty()) {
            System.out.println("Книги автора '" + nonExistentAuthor + "':");
            booksByPushkin.forEach(System.out::println);
        } else {
            System.out.println("Книги автора '" + nonExistentAuthor + "' не найдены.");
        }

        System.out.println("\n--- Тестирование поиска книг по году ---");
        int yearToFind = 1869;
        List<Book> booksFrom1869 = library.findBooksByYear(yearToFind);
        if (!booksFrom1869.isEmpty()) {
            System.out.println("Книги, изданные в " + yearToFind + " году:");
            booksFrom1869.forEach(System.out::println);
        } else {
            System.out.println("Книги, изданные в " + yearToFind + " году, не найдены.");
        }

        int nonExistentYear = 2025;
        List<Book> booksFrom2025 = library.findBooksByYear(nonExistentYear);
        if (!booksFrom2025.isEmpty()) {
            System.out.println("Книги, изданные в " + nonExistentYear + " году:");
            booksFrom2025.forEach(System.out::println);
        } else {
            System.out.println("Книги, изданные в " + nonExistentYear + " году, не найдены.");
        }

        System.out.println("\n--- Тестирование удаления книги ---");
        library.removeBook(book6_duplicate);
        library.removeBook(new Book("Несуществующая книга", "Неизвестный Автор", 2000));
        library.removeBook(null);

        System.out.println("\n--- Состояние библиотеки после удаления ---");
        library.printAllBooks();
        library.printUniqueAuthors();
        library.printAuthorStatistics();

        System.out.println("\n--- Удаление последней книги автора ---");
        library.removeBook(book5);
        library.printAllBooks();
        library.printUniqueAuthors();
        library.printAuthorStatistics();
    }
}