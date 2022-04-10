import java.util.*;


/**
 * 17. Створити додаток для пошуку книг в бібліотечному каталозі по заданому критерію.
 * Список книг (5 записів) створюється в програмі і є об'єктом класу HashMap.
 * Ключем записи є індекс ISBN книги (типу Integer), а значенням - об'єкт Book,
 * що містить найменування книги, прізвище, ім'я та по батькові (ПІБ) учасника,
 * видавництво (всі записи типу String), рік видання (типу int) і ціну книги (типу float).
 * Передбачити можливість сортування каталогу по ПІБ автора або роком видання,
 * для чого використовувати ArrayList.
 * Передбачити можливість перевірки унікальності книги за допомогою TreeSet.
 */

public class Task17 {
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
                System.out.println("[TASK17] Books after sort:");
                printAllBooks(sortedListBooks);
            }
            if (commands.get(i).equals("unique")) {
                var indexOfStop = i;
                do {
                    indexOfStop++;
                } while (!commands.get(indexOfStop).equals("stop"));
                var bookName = String.join(" ", commands.subList(i + 1, indexOfStop));
                if (isBookUnique(books,new Book(bookName,"","",0,0))){
                    System.out.println("[TASK17] Book with name '"+bookName+"' already exists!");
                }else{
                    System.out.println("[TASK17] Book with name '"+bookName+"' not exists!");
                }

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

    public static boolean isBookUnique(HashMap<Integer, Book> books,Book book) {
        ArrayList<Book> listBooks = new ArrayList<>(books.values());
        TreeSet<Book> bookTreeSet = new TreeSet<>(listBooks);
        var sizeBefore = bookTreeSet.size();
        bookTreeSet.add(book);
        var sizeAfter = bookTreeSet.size();
        return sizeBefore==sizeAfter;
    }

    public static void printAllBooks(HashMap<Integer, Book> books) {
        System.out.println("[TASK17] HashMap Books:");
        var booksIndexList = new ArrayList<>(books.keySet());
        for (Integer bookIndex : booksIndexList) {
            System.out.println("[TASK17] {" + bookIndex + "} " + books.get(bookIndex));
        }
    }

    public static void printAllBooks(ArrayList<Book> books) {
        System.out.println("[TASK17] ArrayList Books:");
        for (Book book : books) {
            System.out.println("[TASK17] " + book);
        }
    }
}
