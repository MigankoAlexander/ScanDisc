package scandiscng;

/**
 * Created with IntelliJ IDEA.
 * User: Александр
 * Date: 02.05.12
 * Time: 10:26
 * To change this template use File | Settings | File Templates.
 */
public class RDirInstance {
    private String fileName;
    private int firstCluster;

    public RDirInstance(String fileName, int firstCluster) {
        this.fileName = fileName;
        this.firstCluster = firstCluster;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFirstCluster() {
        return firstCluster;
    }

    public void setFirstCluster(int firstCluster) {
        this.firstCluster = firstCluster;
    }
}
