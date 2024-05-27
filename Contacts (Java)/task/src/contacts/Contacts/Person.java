package contacts.Contacts;

import java.time.LocalDateTime;
import java.util.Scanner;

import static java.lang.System.*;

public class Person extends Contacts{
    private String surname;
    private String birthDate;
    private String gender;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        if (birthDate.isEmpty()){
            out.println("Bad birth date!");
            this.birthDate = "[no data]";
        } else {
            this.birthDate = birthDate;
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (!gender.equalsIgnoreCase("M") && !gender.equalsIgnoreCase("F")){
            out.println("Bad gender!");
            this.gender = "[no data]";
        } else {
            this.gender = gender;
        }
    }

    public static Person add(Scanner sc) {
        Person newPerson = new Person();

        out.print("Enter the name: ");
        String name = sc.nextLine();
        newPerson.setName(name);

        out.print("Enter the surname: ");
        String surname = sc.nextLine();
        newPerson.setSurname(surname);

        out.print("Enter the birth of date: ");
        String birth = sc.nextLine();
        newPerson.setBirthDate(birth);

        out.print("Enter the gender (M,F): ");
        String gender = sc.nextLine();
        newPerson.setGender(gender);

        out.print("Enter the number: ");
        String number = sc.nextLine();
        newPerson.setPhoneNumber(number);

        newPerson.setTimeCreated(LocalDateTime.now().withSecond(0).withNano(0));
        newPerson.setTimeModified(LocalDateTime.now().withSecond(0).withNano(0));

        out.println("The record added.");
        return newPerson;
    }

    @Override
    public void editFields(Scanner sc) {
        out.print("Select a field (name, surname, birth, gender, number): ");
        String field = sc.nextLine();

        switch (field) {
            case "name" -> {
                out.print("Enter name: ");
                setName(sc.nextLine());
            }
            case "surname" -> {
                out.print("Enter surname: ");
                setSurname(sc.nextLine());
            }
            case "birth" -> {
                out.print("Enter birth date: ");
                setBirthDate(sc.nextLine());
            }
            case "gender" -> {
                out.print("Enter gender: ");
                setGender(sc.nextLine());
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
        out.println("Name: " + getName());
        out.println("Surname: " + getSurname());
        out.println("Birth date: " + getBirthDate());
        out.println("Gender: " + getGender());
        out.println("Number: " + getPhoneNumber());
        out.println("Time created: " + getTimeCreated());
        out.println("Time last edit: " + getTimeModified());
    }

    @Override
    public String getAllInfo() {
        return this.getName() + " " + this.getSurname() + " " + this.getPhoneNumber();
    }
}
