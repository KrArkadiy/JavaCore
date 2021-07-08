package com.KrArkadiy.javacore.chapter11;

class CallMe2 {
    void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Прервано");
        }
        System.out.println("]");
    }
}

class Caller1 implements Runnable {
    String msg;
    CallMe2 target;
    Thread t;

    public Caller1(CallMe2 targ, String s) {
        target = targ;
        msg = s;
        t = new Thread(this);
        t.start();
    }

    //синхронизированный вывода метода call()
    public void run() {
        synchronized (target) {//синхронизированный блок
            target.call(msg);
        }
    }

}

public class Synch1 {
    public static void main(String[] args) {
        CallMe2 target = new CallMe2();
        Caller1 ob1 = new Caller1(target, "Добро пожаловать");
        Caller1 ob2 = new Caller1(target, "в синхронизированный");
        Caller1 ob3 = new Caller1(target, "мир!");

        //ожидать завершения потока исполнения
        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Прервано");
        }
    }
}
