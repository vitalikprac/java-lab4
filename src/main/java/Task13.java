import java.util.*;

/**
 * 13.	Створити додаток для пошуку та зміни абонента бібліотечної мережі.
 * Список абонентів (5 записів) створюється в програмі і є об'єктом класу HashMap.
 * Ключем запису є номер абонента (типу Integer), а значенням - об'єкт Abonent,
 * що містить чотири значення типу String: прізвище, ім'я, по батькові та адреса.
 * Передбачити можливість сортування на прізвище за допомогою ArrayList
 */
public class Task13 {
    public static void execute(String[] args) {
        var abonents = createAbonents();
        runCommands(Arrays.stream(args).toList().subList(1, args.length), abonents);
    }

    public static HashMap<Integer, Abonent> createAbonents() {
        HashMap<Integer, Abonent> abonents = new HashMap<>();
        abonents.put(111, new Abonent("Nikolay", "Zahi", "Stepanovich", "Union Avenue 33"));
        abonents.put(222, new Abonent("Vitaliy", "Dou", "Nikolayovich", "New Kensington 15"));
        abonents.put(333, new Abonent("Pavlo", "Akirov", "Igorevich", "Nampa 19"));
        abonents.put(444, new Abonent("Stepan", "Baia", "Vitaliyovich", "Fairhope 55"));
        abonents.put(555, new Abonent("Igor", "Cayman", "Pavlovich", "Spartanburg 2"));
        return abonents;
    }

    public static void runCommands(List<String> commands, HashMap<Integer, Abonent> abonents) {
        Abonent selectedAbonent = null;
        for (int i = 0; i < commands.size(); i++) {
            if (commands.get(i).equals("print")) {
                printAllAbonents(abonents);
            }
            if (commands.get(i).equals("sort")) {
                var sortedListAbonents = sortAbonents(abonents, "surname");
                System.out.println("[TASK13] Abonents after sort:");
                printAllAbonents(sortedListAbonents);
            }
            if (commands.get(i).equals("find")) {
                var value = commands.get(i + 1);
                var foundedAbonent = findAbonent(abonents, value);
                if (foundedAbonent.isPresent()) {
                    selectedAbonent = foundedAbonent.get();
                    System.out.println("[TASK13] Founded abonent: " + selectedAbonent);
                }
            }
            if (commands.get(i).equals("change")) {
                var indexOfStop = i;
                do {
                    indexOfStop++;
                } while (!commands.get(indexOfStop).equals("stop"));
                var name = commands.get(i + 1);
                var surname = commands.get(i + 2);
                var lastName = commands.get(i + 3);
                var address = String.join(" ", commands.subList(i + 4, indexOfStop));
                assert selectedAbonent != null;
                selectedAbonent.setName(name);
                selectedAbonent.setSurname(surname);
                selectedAbonent.setLastName(lastName);
                selectedAbonent.setAddress(address);
                System.out.println("[TASK13] Abonent changed!");
            }
        }
    }

    public static Optional<Abonent> findAbonent(HashMap<Integer, Abonent> abonents, String value) {
        ArrayList<Abonent> listAbonents = new ArrayList<>(abonents.values());
        return listAbonents.stream().filter(abonent -> abonent.getName().equals(value)
                || abonent.getSurname().equals(value)
                || abonent.getLastName().equals(value)
                || abonent.getAddress().equals(value)).findFirst();
    }

    public static ArrayList<Abonent> sortAbonents(HashMap<Integer, Abonent> abonents, String field) {
        ArrayList<Abonent> listAbonents = new ArrayList<>(abonents.values());
        Comparator<Abonent> comparator;
        if ("surname".equals(field)) {
            comparator = Comparator.comparing(Abonent::getSurname, String::compareTo);
        } else {
            comparator = null;
        }
        listAbonents.sort(comparator);
        return listAbonents;
    }

    public static void printAllAbonents(HashMap<Integer, Abonent> abonents) {
        System.out.println("[TASK13] HashMap Abonents:");
        var abonentsIndexList = new ArrayList<>(abonents.keySet());
        for (Integer abonentIndex : abonentsIndexList) {
            System.out.println("[TASK13] {" + abonentIndex + "} " + abonents.get(abonentIndex));
        }
    }

    public static void printAllAbonents(ArrayList<Abonent> abonents) {
        System.out.println("[TASK13] ArrayList Abonents:");
        for (Abonent abonent : abonents) {
            System.out.println("[TASK13] " + abonent);
        }
    }

}
