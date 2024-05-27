import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        String upperRegex = ".*[A-Z].*";
        String lowerRegex = ".*[a-z].*";
        String digitsRegex = ".*[0-9].*";
        String lengthRegex = ".{12,}";


        if (password.matches(upperRegex) && password.matches(lowerRegex)
                && password.matches(digitsRegex) && password.matches(lengthRegex)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}