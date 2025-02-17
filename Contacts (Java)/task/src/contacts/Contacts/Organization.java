package contacts.Contacts;

import java.time.LocalDateTime;
import java.util.Scanner;

import static java.lang.System.*;

public class Organization extends Contacts {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static Organization add(Scanner sc) {
        Organization newOrganization = new Organization();

        out.print("Enter the organization name: ");
        String organizationName = sc.nextLine();
        newOrganization.setName(organizationName);

        out.print("Enter the company address: ");
        String companyAddress = sc.nextLine();
        newOrganization.setAddress(companyAddress);

        out.print("Enter the number: ");
        String number = sc.nextLine();
        newOrganization.setPhoneNumber(number);

        newOrganization.setTimeCreated(LocalDateTime.now().withSecond(0).withNano(0));
        newOrganization.setTimeModified(LocalDateTime.now().withSecond(0).withNano(0));

        out.println("The record added.");
        return newOrganization;
    }

    @Override
    public void editFields(Scanner sc) {
        out.print("Select a field (name, address, number): ");
        String action = sc.nextLine();

        switch (action) {
            case "name" -> {
                out.print("Enter name: ");
                setName(sc.nextLine());
            }
            case "address" -> {
                out.print("Enter address: ");
                setAddress(sc.nextLine());
            }
            case "number" -> {
                out.print("Enter number: ");
                setPhoneNumber(sc.nextLine());
            }
        }

        out.println("Saved");
        this.setTimeModified(LocalDateTime.now().withSecond(0).withNano(0));
    }

    @Override
    public void getFields() {
        out.println("Organization name: " + getName());
        out.println("Address: " + getAddress());
        out.println("Number: " + getPhoneNumber());
        out.println("Time created: " + getTimeCreated());
        out.println("Time last edit: " + getTimeModified());
    }

    @Override
    public String getAllInfo() {
        return this.getName() + " " + this.getAddress() + " " + this.getPhoneNumber();
    }
}
