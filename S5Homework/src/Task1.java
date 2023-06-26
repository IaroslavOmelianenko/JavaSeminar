import java.util.*;

public class Task1 {
    /***
     * 1)Реализуйте структуру телефонной книги с помощью HashMap.
     * Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
     * их необходимо считать, как одного человека с разными телефонами.
     * Вывод должен быть отсортирован по убыванию числа телефонов.
     * (можно выводить без сортировки, но обязательно в отдельном методе)
     */
    public static void fillAndPrintPhoneBook(){
        printPhoneBook(fillPhoneBook());
    }

    public static HashMap<String, List<String>> fillPhoneBook() {
        HashMap<String, List<String>> phoneBook = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of contacts:");
        int contactsQuantity = scanner.nextInt();

        for (int i = 0; i < contactsQuantity; i++) {
            System.out.println("Name:");
            String name = scanner.next();
            System.out.println("Phone number:");
            String phone = scanner.next();

            if (phoneBook.containsKey(name)) {
                List<String> phones = phoneBook.get(name);
                phones.add(phone);
            } else {
                List<String> phones = new ArrayList<>();
                phones.add(phone);
                phoneBook.put(name, phones);
            }
        }
        return phoneBook;
    }


    public static void printPhoneBook(HashMap<String, List<String>> phoneBook) {
        System.out.println("\n[PHONEBOOK]");
        for (String name : phoneBook.keySet()) {
            List<String> phones = phoneBook.get(name);
            System.out.print(name + ": " + phones.get(0));
            if (phones.size() > 1) {
                for (int i = 1; i < phones.size(); i++) {
                    System.out.print("," + phones.get(i));
                }
            }
            System.out.println();
        }
    }
}
