import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileNotFoundException;
// wtf are these imports? I gotta import errors now?

public class TaskOne {
    public static void main(String[] args) {
        ArrayList<Integer> coords1 =
            new ArrayList<Integer>(); // I hate this list type, why
                                      // can't Java be a normal language?
        ArrayList<Integer> coords2 = new ArrayList<Integer>();

        try {
            File file = new File("input.txt");
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String regex = "[  *]";

                String data = reader.nextLine();
                String[] tmp = data.split(regex);
                coords1.add(Integer.parseInt(tmp[0]));
                coords2.add(Integer.parseInt(
                    tmp[3])); // Why tf does the second words start at 3 in Java
                              // but 1 in Python?
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }

        Collections.sort(coords1);
        Collections.sort(coords2);
        // Why can't sorting be in the base array class?

        ArrayList<Integer> distances = new ArrayList<Integer>();

        // Messy messy messy, and I hate get()
        for (int i = 0; i < coords1.size(); i++) {
            if (coords1.get(i) >= coords2.get(i)) {
                distances.add(coords1.get(i) - coords2.get(i));
            } else if (coords1.get(i) < coords2.get(i)) {
                distances.add(coords2.get(i) - coords1.get(i));
            }
        }

        int totalDistance = 0;

        for (int j : distances) {
            totalDistance += j;
        }

        System.out.println(totalDistance);
    }
}
