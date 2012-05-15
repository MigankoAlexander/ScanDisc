package scandiskng.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import scandiscng.ClustersConstants;
import scandiscng.ClustersScanner;
import scandiscng.RDirInstance;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Александр
 * Date: 15.05.12
 * Time: 10:01
 * To change this template use File | Settings | File Templates.
 */
public class ClustersScannerTest {
    private ClustersScanner scanner;

    @BeforeMethod
    public void setUp() {
        System.out.println("set up");
        scanner = new ClustersScanner();
    }

    @Test (dataProvider = "empty links provider")
    public void fixEmptyLinksTest(ArrayList<Integer> clusters, ArrayList<ArrayList<RDirInstance>> rDirArrayLists) {

        scanner.fixEmptyLinks(rDirArrayLists.get(0), clusters);
        Assert.assertEquals(rDirArrayLists.get(0), rDirArrayLists.get(1));
    }

    @DataProvider(name = "empty links provider")
    public Object[][] provideEmptyLinks() {

        ArrayList<Integer> clusters = new ArrayList<Integer>();
        clusters.add(1);

        ArrayList<RDirInstance> actual = new ArrayList<>();
        actual.add(new RDirInstance("A", 0));

        ArrayList<RDirInstance> expectedResult = new ArrayList<>();
        expectedResult.add(new RDirInstance("A", 0));

        ArrayList<ArrayList<RDirInstance>> rDirArrayList = new ArrayList<>();
        rDirArrayList.add(actual);
        rDirArrayList.add(expectedResult);

        return new Object[][] {
                {clusters, rDirArrayList}
        };
    }
}
