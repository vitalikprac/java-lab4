import java.util.*;

/**
 * 5.	Створити додаток для перегляду списку книг і видалення книг в бібліотечному каталозі.
 * Записи в списку (5 записів) є об'єктами класу HashMap, де ключем є індекс ISBN книги (типу Integer),
 * а значенням - об'єкт Book, що містить найменування книги, прізвище, ім'я та по батькові (ПІБ) учасника,
 * видавництво (всі поля типу String), рік видання (типу int) і ціну книги (типу float).
 * Передбачити можливість сортування книг по 2-3 полях, для чого використовувати ArrayList.
 */

public class Task5 {
    public static void execute(String[] args) {
        var books = createBooks();
        runCommands(Arrays.stream(args).toList().subList(1, args.length), books);
    }

    public static HashMap<Integer, Book> createBooks() {
        HashMap<Integer, Book> books = new HashMap<>();
        books.put(523, new Book("Book 1", "Joel Zahi", "Prachov", 2001, 100));
        books.put(131, new Book("Book 3", "Dou Mariana", "Prachov", 2003, 50));
        books.put(152, new Book("Book 2", "Kirov Hakan", "Prachov", 2005, 130));
        books.put(967, new Book("Book 5", "Gaia Aeronwy", "Prachov", 2005, 200));
        books.put(552, new Book("Book 4", "Layman Harry", "Prachov", 2009, 22));
        return books;
    }

    public static void runCommands(List<String> commands, HashMap<Integer, Book> books) {
        for (int i = 0; i < commands.size(); i++) {
            if (commands.get(i).equals("print")) {
                printAllBooks(books);
            }
            if (commands.get(i).equals("sort")) {
                var field = commands.get(i + 1);
                var sortedListBooks = sortBooks(books, field);
                System.out.println("[TASK5] Books after sort:");
                printAllBooks(sortedListBooks);
            }
            if (commands.get(i).equals("delete")) {
                var number = Integer.parseInt(commands.get(i + 1));
                books.remove(number);
            }
        }
    }

    public static ArrayList<Book> sortBooks(HashMap<Integer, Book> books, String field) {
        ArrayList<Book> listBooks = new ArrayList<>(books.values());
        Comparator<Book> comparator;
        switch (field) {
            case "name" -> comparator = Comparator.comparing(Book::getName, String::compareTo);
            case "authorFullName" -> comparator = Comparator.comparing(Book::getAuthorFullName, String::compareTo);
            case "publication" -> comparator = Comparator.comparing(Book::getPublication, String::compareTo);
            case "publicationYear" -> comparator = Comparator.comparing(Book::getPublicationYear, Comparator.naturalOrder());
            case "price" -> comparator = Comparator.comparing(Book::getPrice, Comparator.naturalOrder());
            default -> comparator = null;
        }
        listBooks.sort(comparator);
        return listBooks;
    }

    public static void printAllBooks(HashMap<Integer, Book> books) {
        System.out.println("[TASK5] HashMap Books:");
        var booksIndexList = new ArrayList<>(books.keySet());
        for (Integer bookIndex : booksIndexList) {
            System.out.println("[TASK5] {" + bookIndex + "} " + books.get(bookIndex));
        }
    }

    public static void printAllBooks(ArrayList<Book> books) {
        System.out.println("[TASK5] ArrayList Books:");
        for (Book book : books) {
            System.out.println("[TASK5] " + book);
        }
    }
}