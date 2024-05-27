import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class FindTheKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().trim();
        String regex = "the\\s+key\\s+is\\s+([b-df-hj-np-tv-yz0-9]+|[aeiou?!#]+)(?=\\s|$)";
        Matcher matcher = Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }

    }
}