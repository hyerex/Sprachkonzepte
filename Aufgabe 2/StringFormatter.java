import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringFormatter {

    public static void main(String[] args) {
        
        String strFormat = "%(\\d+\\$)?([-#+ 0,(\\<]*)?(\\d+)?(\\.\\d+)?([tT])?([a-zA-Z%])";
        
        Scanner scn = new Scanner(System.in);
        System.out.println("Insert input:");
        String input = scn.nextLine();
        System.out.println("Input: " + input);
        
        int n = 0;

        Pattern pattern = Pattern.compile(strFormat);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            if (n != matcher.start()) {
                System.out.printf("TEXT(%s)", input.substring(n, matcher.start()));
            }
            System.out.printf("Format(%s)", matcher.group());

            n = matcher.end();
        }
        if (!input.substring(n).isEmpty()) {
            System.out.printf("TEXT(%s)", input.substring(n));
        }

        scn.close();
    }
}
