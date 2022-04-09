/**
 * Варіант - 16
 * Завдання 5,13,17,25
 */
public class Main {
    public static void main(String[] args) throws Exception {
        var taskExecute = args[0];
        switch (taskExecute) {
            case "task5" -> Task5.execute(args);
            case "task13" -> Task13.execute(args);
            case "task17" -> Task17.execute(args);
            case "task25" -> Task25.execute(args);
            default -> {
                throw new Exception("No specific task argument passed");
            }
        }
    }
}