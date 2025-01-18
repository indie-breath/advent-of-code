// no clues on how to do this one
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> reports =
            new ArrayList<ArrayList<Integer>>();

        try {
            File file = new File("input.txt");
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String regex = "[  *]";

                String data = reader.nextLine();
                String[] tmp = data.split(regex);
                ArrayList<Integer> tmp2 = new ArrayList<Integer>();

                for (String i : tmp) {
                    tmp2.add(Integer.parseInt(i));
                }

                reports.add(tmp2);
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }

        int unsafeReports = 0;
        int safeReports = 0;

        for (ArrayList<Integer> workingReport : reports) {
            if (workingReport.size() == 1) {
                safeReports++;
                continue;
            }

            Integer[] tmp = new Integer[workingReport.size()];
            workingReport.toArray(tmp);

            boolean safe = true;

            for (int i = 0; i < workingReport.size() - 1; i++) {
                int differences = workingReport.get(i) - workingReport.get(i++);
                if (differences > 3 || differences < -3 || differences == 0) {
                    safe = false;
                    unsafeReports++;
                }

                if (!safe) {
                    break;
                }
            }

            if (safe) {
                safeReports++;
            }
        }

        System.out.println("Unsafe reports: " + unsafeReports);
        System.out.println("Safe reports: " + safeReports);
    }
}
