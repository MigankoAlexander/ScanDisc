package org.scandsk;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: пользователь1
 * Date: 21.03.12
 * Time: 19:30
 * To change this template use File | Settings | File Templates.
 */
public class Fat extends AbstractIO {
    private String IFile;
    private String OFile;
    public Integer[] Claster = new Integer[fat + 1];

    public void setIFile(String IFile) {
        this.IFile = IFile;
    }

    public void setOFile(String OFile) {
        this.OFile = OFile;
    }

    public String getIFile() {
        return IFile;
    }

    public String getOFile() {
        return OFile;
    }

    @Override
    public void scanF() throws IOException {
        Scanner s = new Scanner(new File(IFile)); // создаём объект класса Scanner
        String[] Clasters = new String[fat + 1];
        for (int j = 0; s.hasNext(); j++) {
            Clasters[j] = s.next();
        }

        //Преобразование массива кластеров string to int
        for (int j = 0; j <= fat; j++) {
            Claster[j] = Integer.parseInt(Clasters[j].trim());
        }
    }

    @Override
    public void printF() throws Exception{
        /*File results = new File("C:/Results.txt");
        results.createNewFile();
        FileWriter writer = new FileWriter(results);
        for (int i=0; i<=7;i++){
            writer.write(Claster[i]);
            writer.flush();
            writer.close();
        } */
    }
}
