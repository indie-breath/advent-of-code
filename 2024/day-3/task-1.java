import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String output = "";

        try {
            File file = new File("input.txt");
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                output += data;
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }

        Pattern regex = Pattern.compile("mul\\([0-9]+,[0-9]+\\)");
        Matcher matcher = regex.matcher(output);
        ArrayList<String> expressions = new ArrayList<String>();

        while (matcher.find()) {
            expressions.add(matcher.group(0));
        }

        regex = Pattern.compile("[0-9]+");
        Integer result = 0;

        for (String x : expressions) {
            matcher = regex.matcher(x);
            Integer num1 = 0;
            Integer num2 = 0;

            if (matcher.find()) {
                num1 = Integer.parseInt(matcher.group(0));
            }
            if (matcher.find()) {
                num2 = Integer.parseInt(matcher.group(0));
            }

            Integer tmp = num1 * num2;
            result += tmp;
        }

        System.out.println(result);
    }
}
