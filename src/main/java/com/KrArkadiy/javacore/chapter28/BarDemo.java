package com.KrArkadiy.javacore.chapter28;
//Продемонстрировать применение класса CyclicBarrier

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarDemo {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, new BarAction());

        System.out.println("Запуск потоков");

        new MyThread1(cb, "A");
        new MyThread1(cb, "B");
        new MyThread1(cb, "C");
    }
}

//Поток исполнения, использующий барьер CyclicBarrier

class MyThread1 implements Runnable{
    String name;
    CyclicBarrier cyclicBarrier;

    MyThread1(CyclicBarrier cb, String name){
        this.cyclicBarrier = cb;
        this.name = name;
        new Thread(this).start();
    }

    public void run(){
        System.out.println(name);

        try{
            cyclicBarrier.await();
        }catch (BrokenBarrierException e){
            System.out.println(e);
        } catch (InterruptedException exc){
            System.out.println(exc);
        }
    }
}

//Объект этого класса вызывается по достижении барьера типа CyclicBarrier

class BarAction implements Runnable{
    public void run(){
        System.out.println("Барьер достигнут");
    }
}
