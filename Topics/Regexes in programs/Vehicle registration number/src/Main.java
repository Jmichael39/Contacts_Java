import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regNum = scanner.nextLine();

        String regEx = "[ABEKMHOPCTYX][0-9]{3}[ABEKMHOPCTYX]{2}";

        System.out.println(regNum.matches(regEx));
    }
}