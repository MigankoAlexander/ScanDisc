package scandiscng;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Александр
 * Date: 02.05.12
 * Time: 10:26
 * To change this template use File | Settings | File Templates.
 */
public class ClustersScanner {
    public void fixEmptyLinks(ArrayList<RDirInstance> rDirInstances,
                              ArrayList<Integer> clusters) {
        for (RDirInstance rDirInstance : rDirInstances) {
            int clusterValue = clusters.get(rDirInstance.getFirstCluster());
            if (clusterValue == ClustersConstants.EMPTY_CLUSTER) {
                rDirInstance.setFirstCluster(ClustersConstants.DELETED_FILE);
            }
        }
    }

    public void fixBadLinks(ArrayList<RDirInstance> rDirInstances,
                            ArrayList<Integer> clusters) {
        for (RDirInstance rDirInstance : rDirInstances) {
            int clusterValue = clusters.get(rDirInstance.getFirstCluster());
            if (clusterValue == ClustersConstants.BAD_CLUSTER) {
                rDirInstance.setFirstCluster(ClustersConstants.DELETED_FILE);
            }
        }
    }

    public void fixLongEmptyLinks(ArrayList<RDirInstance> rDirInstances,
                                  ArrayList<Integer> clusters) {
        for (RDirInstance rDirInstance : rDirInstances) {
            int clusterValue = clusters.get(rDirInstance.getFirstCluster());

            do {
                clusterValue = clusters.get(clusterValue);
            }
            while (clusterValue != ClustersConstants.EMPTY_CLUSTER);


            if (clusterValue == ClustersConstants.EMPTY_CLUSTER) {
                clusters.set(ClustersConstants.END_OF_FILE);
            }
        }
    }

    public void fixLongBadLinks(ArrayList<RDirInstance> rDirInstances,
                                ArrayList<Integer> clusters) {
        for (RDirInstance rDirInstance : rDirInstances) {
            int clusterValue = clusters.get(rDirInstance.getFirstCluster());

            do {
                clusterValue = clusters.get(clusterValue);
            }
            while (clusterValue != ClustersConstants.BAD_CLUSTER);


            if (clusterValue == ClustersConstants.BAD_CLUSTER) {
                clusters.set(ClustersConstants.END_OF_FILE);
            }
        }
    }

    public void fixLostFiles(ArrayList<Integer> clusters) {
        for (Integer cluster : clusters) {
            if (cluster >-3){
                if()
            }

        }


    }
}
