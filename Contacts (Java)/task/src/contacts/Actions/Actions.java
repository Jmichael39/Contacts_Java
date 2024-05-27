package contacts.Actions;

import contacts.Contacts.Contacts;
import contacts.Contacts.Organization;
import contacts.Contacts.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Actions implements Serializable {
    public static List<Contacts> contactsList = new ArrayList<>();

    public static void add(Scanner sc) {
        System.out.print("Enter the type (person, organization): ");
        String type = sc.nextLine();

        if (type.equals("person")) {
            contactsList.add(Person.add(sc));
        } else {
            contactsList.add(Organization.add(sc));
        }
    }

    public static void search(Scanner sc) {

        System.out.print("Enter search query: ");
        String query = sc.nextLine();
        List<Contacts> foundContacts = new ArrayList<>();

        Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);
        int count = 0;

        for (Contacts contact : contactsList) {
            Matcher matcher = pattern.matcher(contact.getAllInfo());
            if (matcher.find()) {
                count++;
                foundContacts.add(contact);
            }
        }

        System.out.printf("Found %d results: \n", count);
        int i = 1;
        for (Contacts contact : foundContacts) {
            System.out.println(i + ". " + contact.getAllInfo());
            i++;
        }

        searchMenu(sc, foundContacts);
    }

    private static void searchMenu(Scanner sc, List<Contacts> foundContacts) {
        if (checkEmptyList()){
            System.out.println("No contacts in the list");
            return;
        }

        System.out.print("\n[search] Enter action ([number], back, again): ");
        String action = sc.nextLine();
        switch (action) {
            case "back" -> Menu.start();
            case "again" -> search(sc);
            default -> editDeleteContact(sc, foundContacts, action);
        }
    }

    private static void editDeleteContact(Scanner sc, List<Contacts> foundContacts, String action) {
        int index = Integer.parseInt(action);
        Contacts selectedContact = foundContacts.get(index - 1);
        selectedContact.getFields();
        System.out.print("\n[record] Enter action (edit, delete, menu): ");

        switch (sc.nextLine()) {
            case "edit" -> selectedContact.editFields(sc);
            case "delete" -> contactsList.remove(selectedContact);
            case "menu" -> Menu.start();
        }
    }

    public static void listContacts(Scanner sc) {
        if (checkEmptyList()) {
            System.out.println("No records to list");
        }
        contactsList.forEach(item -> System.out.println(contactsList.indexOf(item) + 1 + ". " + item.getAllInfo()));

        System.out.print("\n[list] Enter action ([number], back): ");
        String action = sc.nextLine();

        if ("back".equals(action)) {
            Menu.start();
        } else {
            editDeleteContact(sc, contactsList, action);
        }
    }
    
    public static boolean checkEmptyList(){
        return contactsList.isEmpty();
    }
}
