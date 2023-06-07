package Lesson5;

import java.util.*;

//Реализуйте структуру телефонной книги с помощью HashMap.
//Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
//их необходимо считать, как одного человека с разными телефонами.
//Вывод должен быть отсортирован по убыванию числа телефонов.


public class Task1 {
    private HashMap<String, HashSet<String>> phoneBook;


    public Task1() {
        phoneBook = new HashMap<>();
    }


    public void addContact(String name, String phoneNumber) {
        phoneBook.computeIfAbsent(name, k -> new HashSet<>()).add(phoneNumber);
    }


    public void removeContact(String name) {
        phoneBook.remove(name);
    }


    public void removePhoneNumber(String name, String phoneNumber) {
        HashSet<String> phoneNumbers = phoneBook.get(name);
        if (phoneNumbers != null) {
            phoneNumbers.remove(phoneNumber);
            if (phoneNumbers.isEmpty()) {
                phoneBook.remove(name);
            }
        }
    }


    public void displayContacts() {
        List<Map.Entry<String, HashSet<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort(Comparator.comparingInt(e -> -e.getValue().size()));

        for (Map.Entry<String, HashSet<String>> entry : sortedEntries) {
            String name = entry.getKey();
            HashSet<String> phoneNumbers = entry.getValue();

            System.out.println(name + ": " + phoneNumbers);
        }
    }


    public static void PhoneBook() {
        Task1 phoneBook = new Task1();

        phoneBook.addContact("Vladimir", "7123123123");
        phoneBook.addContact("Vladimir", "7987654321");
        phoneBook.addContact("Alex", "7444444444");
        phoneBook.addContact("Dmitriy", "7111222333");
        phoneBook.addContact("Alex", "7888888555");
        phoneBook.addContact("Dmitriy", "7777777777");

        phoneBook.removeContact("Alex");
        phoneBook.removePhoneNumber("Vladimir", "7123123123");

        phoneBook.displayContacts();
    }
}