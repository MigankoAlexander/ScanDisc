package org.scandsk;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: пользователь1
 * Date: 21.03.12
 * Time: 19:14
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Fat fat=new Fat();
        Rdir rdir=new Rdir();
        ScanFunc func=new ScanFunc();
        fat.setIFile("K://fat.txt");
        fat.scanF();
        rdir.setIFile("K://rdir.txt");
        rdir.scanF();
        func.scanFunc(fat,rdir);
    }
}
