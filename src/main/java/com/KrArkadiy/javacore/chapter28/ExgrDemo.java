package com.KrArkadiy.javacore.chapter28;

import java.util.concurrent.Exchanger;

public class ExgrDemo {
    public static void main(String[] args) {
        Exchanger<String> exgr = new Exchanger<>();
        new UseString(exgr);
        new MakeString(exgr);
    }
}

class MakeString implements Runnable {
    Exchanger<String> exgr;
    String str;

    MakeString(Exchanger<String> exgr) {
        this.exgr = exgr;
        str = new String();
        new Thread(this).start();
    }

    public void run() {
        char ch = 'A';
        for (int i = 0; i < 3; i++) {
            //заполнить буфер
            for (int j = 0; j < 5; j++) {
                str += (char) ch++;
            }
            try {
                //обменять заполненный буфер на пустой
                str = exgr.exchange(str);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}


//Поток типа Thread, использующий символьную строку
class UseString implements Runnable {
    Exchanger<String> exgr;
    String str;

    UseString(Exchanger<String> exgr) {
        this.exgr = exgr;
        str = new String();
        new Thread(this).start();
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                //обменять пустой буфер на заполненный
                str = exgr.exchange(new String());
                System.out.println("Получено:" + str);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
