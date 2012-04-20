package org.scandsk;


import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: пользователь1
 * Date: 21.03.12
 * Time: 19:21
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractIO implements IO {
    public int rdir = 5;
    public int fat = 31;

    public int getRdir() {
        return rdir;
    }

    public int getFat() {
        return fat;
    }

    public void setRdir(int rdir) {
        this.rdir = rdir;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    @Override
    public void scanF() throws  IOException {

    }

    @Override
    public void printF() throws Exception{

    }
}
