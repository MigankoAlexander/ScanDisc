package scandiscng;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Александр
 * Date: 02.05.12
 * Time: 10:26
 * To change this template use File | Settings | File Templates.
 */
public class FatReader {
    public static ArrayList<Integer> readFat (String fileName) throws FileNotFoundException {
        Scanner s = new Scanner(new File(fileName));

        ArrayList<Integer> clusters = new ArrayList<Integer>();

        while(s.hasNext()) {
            Integer cluster = Integer.parseInt(s.next());
            clusters.add(cluster);
        }

        return clusters;
    }
}
