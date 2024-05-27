package contacts.Actions;

import java.util.Scanner;

import static contacts.Actions.Actions.*;

public class Menu {
    public static void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("\n[menu] Enter action (add, list, search, count, exit): ");
            String action = sc.nextLine();

            switch (action) {
                case "add" -> add(sc);
                case "list" -> listContacts(sc);
                case "search" -> search(sc);
                case "count" -> System.out.println("The Phone book has " + contactsList.size() + " records");
                case "exit" -> {
                    sc.close();
                    System.exit(0);
                }
            }
        }
    }
}
