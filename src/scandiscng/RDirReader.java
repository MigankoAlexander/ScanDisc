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
public class RDirReader {
    public static ArrayList<RDirInstance> readRDir(String fileName) throws FileNotFoundException {
        Scanner s = new Scanner(new File(fileName));
        s.useDelimiter("[\t\n]");

        ArrayList<RDirInstance> rDirInstances = new ArrayList<RDirInstance>();

        while(s.hasNext()) {
            String rDirFileName = s.next();
            if(s.hasNext()) {
                int firstCluster = Integer.parseInt(s.next());
                RDirInstance rDirInstance = new RDirInstance(rDirFileName, firstCluster);
                rDirInstances.add(rDirInstance);
            }
        }

        return rDirInstances;
    }
}
