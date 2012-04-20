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
public class Rdir extends AbstractIO {
    private String IFile;
    private String OFile;
    public String[] Name_ = new String[fat];
    public Integer[] FC_ = new Integer[rdir + 1];

    public String getIFile() {
        return IFile;
    }

    public void setIFile(String IFile) {
        this.IFile = IFile;
    }

    public String getOFile() {
        return OFile;
    }

    public void setOFile(String OFile) {
        this.OFile = OFile;
    }


    @Override
    public void scanF() throws IOException {
        Scanner s = new Scanner(new File(IFile)); // создаём объект класса Scanner

        String[] FCs = new String[fat];
        s.useDelimiter("[\t\n]");
        for (int j = 0; s.hasNext(); j++) {
            Name_[j] = s.next();
            if (s.hasNext())
                FCs[j] = s.next();
        }

        //Преобразование массива начальных кластеров string to int

        for (int j = 0; j <= rdir; j++) {
            FC_[j] = Integer.parseInt(FCs[j].trim());
        }


    }
    @Override
    public void printF() throws Exception{
        /*File results = new File("C:/Results1.txt");
        results.createNewFile();
        FileWriter writer = new FileWriter(results);
        for (int i=0; i<=7;i++){
            writer.write(Name[i]);
            writer.flush();
            writer.close();
        } */
    }

}

