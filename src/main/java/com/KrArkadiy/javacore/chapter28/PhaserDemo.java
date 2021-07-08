package com.KrArkadiy.javacore.chapter28;

import java.util.concurrent.Phaser;

public class PhaserDemo {
    public static void main(String[] args) {
        Phaser phsr = new Phaser(1);
        int curPhase;

        System.out.println("Запуск потоков");

        new MyThread2(phsr, "A");
        new MyThread2(phsr, "B");
        new MyThread2(phsr, "C");

        //ожидать завершения всеми потоками исполнения первой фазы

        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Фаза " + curPhase + " завершена");

        //ожидать завершения всеми потоками исполнения второй фазы

        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Фаза " + curPhase + " завершена");

        //ожидать завершения всеми потоками исполнения третьей фазы

        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Фаза " + curPhase + " завершена");

        //снять основной поток исполнения с регистрации
        phsr.arriveAndDeregister();

        if(phsr.isTerminated()){
            System.out.println("Синхронизатор фаз завершен");
        }
    }
}

class MyThread2 implements Runnable{
    String name;
    Phaser phaser;

    MyThread2(Phaser phaser, String name){
        this.phaser = phaser;
        this.name = name;
        phaser.register();
        new Thread(this).start();
    }

    public void run(){
        System.out.println("Поток " + name + " начинает первую фазу");
        phaser.arriveAndAwaitAdvance();//известить о достижении фазы

        //Небольшая пауза, чтобы не нарушить порядок вывода.
        //Только для иллюстрации, но необязательно для правильного функционирования синхронизатора фаз
        try{
            Thread.sleep(10);
        } catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println("Поток " + name + " начинает вторую фазу");
        phaser.arriveAndAwaitAdvance();//известить о достижении фазы

        //Небольшая пауза, чтобы не нарушить порядок вывода.
        //Только для иллюстрации, но необязательно для правильного функционирования синхронизатора фаз
        try{
            Thread.sleep(10);
        } catch (InterruptedException e){
            System.out.println(e);
        }

        System.out.println("Поток " + name + " начинает третью фазу");
        phaser.arriveAndDeregister();//известить о достижении фазы и снять потоки с регистрации
    }
}
