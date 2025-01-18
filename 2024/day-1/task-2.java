import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
// wtf are these fucking imports? I gotta import errors now?

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> coords1 = new ArrayList<Integer>();
        ArrayList<Integer> coords2 = new ArrayList<Integer>();

        try {
            File file = new File("input.txt");
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String regex = "[  *]";

                String data = reader.nextLine();
                String[] tmp = data.split(regex);
                coords1.add(Integer.parseInt(tmp[0]));
                coords2.add(Integer.parseInt(tmp[3]));
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }

        ArrayList<Integer> similarities = new ArrayList<Integer>();

        for (int i : coords1) {
            int tmp = 0;

            for (int j : coords2) {
                if (i == j) {
                    tmp++;
                }
            }

            similarities.add(i * tmp);
        }

        int similarityScore = 0;

        for (int k : similarities) {
            similarityScore += k;
        }

        System.out.println(similarityScore);
    }
}
