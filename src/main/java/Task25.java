import java.util.*;

/**
 * 25.	Створити додаток для перегляду списку товарів і видалення товару в електронному магазині.
 * Список товарів (5 записів) створюється в програмі і є об'єктом класу HashMap.
 * Ключем записи є артикул товару (типу Integer), а значенням - об'єкт Article,
 * що містить найменування товару (типу String) і ціну товару (типу float).
 */
public class Task25 {
    public static void execute(String[] args) {
        var articles = createArticles();
        runCommands(Arrays.stream(args).toList().subList(1, args.length), articles);
    }

    public static HashMap<Integer, Article> createArticles() {
        HashMap<Integer, Article> articles = new HashMap<>();
        articles.put(523, new Article("PC1", 100));
        articles.put(131, new Article("Processor Pentium", 50));
        articles.put(152, new Article("Video Card", 130));
        articles.put(967, new Article("Intel", 200));
        articles.put(552, new Article("NVIDIA", 500));
        return articles;
    }

    public static void runCommands(List<String> commands, HashMap<Integer, Article> articles) {
        for (int i = 0; i < commands.size(); i++) {
            if (commands.get(i).equals("print")) {
                printAllArticles(articles);
            }
            if (commands.get(i).equals("delete")) {
                var number = Integer.parseInt(commands.get(i + 1));
                articles.remove(number);
            }
        }
    }

    public static void printAllArticles(HashMap<Integer, Article> articles) {
        System.out.println("[TASK25] HashMap Articles:");
        var articlesIndexList = new ArrayList<>(articles.keySet());
        for (Integer bookIndex : articlesIndexList) {
            System.out.println("[TASK25] {" + bookIndex + "} " + articles.get(bookIndex));
        }
    }

}
