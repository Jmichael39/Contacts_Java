// You can experiment here, it won’t be checked
/*
1. The phone number should be split into groups using a space or dash. One group is also possible.
2. Before the first group, there may or may not be a plus symbol.
3. The first group or the second group can be wrapped in parentheses,
   but there should be no more than one group that is wrapped in parentheses. There may also be no groups wrapped in parentheses.
4. A group can contain numbers, uppercase, and lowercase English letters. A group should be at least 2 symbols in length.
   But the first group may be only one symbol in length.
 */

public class Task {
    public static void main(String[] args) {
        String regex = "^\\+?(\\(\\w+\\)|\\w+[ -]\\(\\w{2,}\\)|\\w+)([ -]\\w{2,})*";

        String[] test = {"+0 (123) 456-789-ABcd",
                "+0 (123) 456",
                "(123) 234 345-456",
                "1111111111111",
                "+1 123 123 123 123",
                "123",
                "123-(456)",
                "123 (456) 789",
                "+(phone)",
                "(123)",
                "(+0) 123 456 789 ABcd",
                "+0(123)456-789-9999",
                "(+0) (123) 456 789",
                "123+456 78912",
                "()()"};

        for (String s : test) {
            if (s.matches(regex)) {
                System.out.println(s + " valid");
            } else {
                System.out.println(s + " invalid");
            }
        }
    }
}
