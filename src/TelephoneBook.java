import java.util.*;

public class TelephoneBook {
    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();

        addContact(phoneBook, "Иванов", "123-456-789");
        addContact(phoneBook, "Петров", "987-654-321");
        addContact(phoneBook, "Иванов", "555-555-555");
        addContact(phoneBook, "Сидоров", "111-222-333");
        addContact(phoneBook, "Петров", "999-888-777");
        addContact(phoneBook, "Смирнов", "444-333-222");
        addContact(phoneBook, "Козлов", "666-777-888");
        addContact(phoneBook, "Соколов", "123-987-654");
        addContact(phoneBook, "Иванов", "777-888-999");
        addContact(phoneBook, "Петров", "555-111-222");
        addContact(phoneBook, "Сидоров", "999-444-555");

        printContacts(phoneBook);
    }

    // Добавление
    private static void addContact(Map<String, List<String>> phoneBook, String name, String phoneNumber) {
        phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNumber);
    }

    // Вывод
    private static void printContacts(Map<String, List<String>> phoneBook) {

        List<Map.Entry<String, List<String>>> sortedContacts = new ArrayList<>(phoneBook.entrySet());
        sortedContacts.sort(Comparator.comparingInt(entry -> entry.getValue().size()));

        for (int i = sortedContacts.size() - 1; i >= 0; i--) {
            Map.Entry<String, List<String>> entry = sortedContacts.get(i);
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println(name + ": " + phoneNumbers.size() + " телефон(ов) - " + phoneNumbers);
        }
    }
}
