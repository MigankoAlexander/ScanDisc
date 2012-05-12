package scandiscng;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Александр
 * Date: 02.05.12
 * Time: 10:36
 * To change this template use File | Settings | File Templates.
 */
public class ScanDiskRunner {
    public static void main(String[] args) {
        try {
            ArrayList<Integer> clusters = FatReader.readFat("test.txt");
            ArrayList<RDirInstance> rDirInstances = RDirReader.readRDir("test2.txt");
            fixAllProblems(rDirInstances, clusters);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot read file: " + e);  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static void fixAllProblems(ArrayList<RDirInstance> rDirInstances,
                                      ArrayList<Integer> clusters) {
        ClustersScanner scanner = new ClustersScanner();
        scanner.fixEmptyLinks(rDirInstances, clusters);


    }
}
