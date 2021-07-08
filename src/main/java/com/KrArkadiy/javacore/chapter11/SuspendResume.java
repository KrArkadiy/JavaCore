package com.KrArkadiy.javacore.chapter11;

//приостановка и возобновление исполнения потока современным способом
class NewThread5 implements Runnable{
    String name;
    Thread t;
    boolean suspendFlag;

    NewThread5(String name){
        this.name = name;
        t = new Thread(this, name);
        System.out.println("Новый поток: " +name);
        suspendFlag = false;
        t.start(); //запустить поток исполнения
    }

    public void run(){
        try{
            for (int i = 15; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                synchronized (this){
                    while (suspendFlag){
                        wait();
                    }
                }
            }
        } catch (InterruptedException e){
            System.out.println(name + " прерван");
        }
        System.out.println(name + " завершен");
    }

    synchronized void mysuspend(){
        suspendFlag = true;
    }

    synchronized void myresume(){
        suspendFlag = false;
        notify();
    }
}

public class SuspendResume {
    public static void main(String[] args) {
        NewThread5 ob1 = new NewThread5("Один");
        NewThread5 ob2 = new NewThread5("Два");

        try{
            Thread.sleep(1000);
            ob1.mysuspend();
            System.out.println("Приостановка потока Один");
            Thread.sleep(1000);
            ob1.myresume();
            System.out.println("Возобновление потока Один");
            ob2.mysuspend();
            System.out.println("Приостановка потока Два");
            Thread.sleep(1000);
            ob2.myresume();
            System.out.println("Возобновление потока Два");
        } catch (InterruptedException e){
            System.out.println("Главный поток прерван");
        }

        //ожидать завершения потоков исполнения
        try{
            System.out.println("Ожидание завершения потоков.");
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException e){
            System.out.println("Главный поток прерван");
        }
        System.out.println("Главный поток завершен");
    }
}
