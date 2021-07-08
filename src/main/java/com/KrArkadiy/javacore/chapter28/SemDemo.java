package com.KrArkadiy.javacore.chapter28;

import java.util.concurrent.Semaphore;

//Простой пример применения семафора
public class SemDemo {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);

        new IncThread(sem, "A");
        new DecThread(sem, "B");
    }
}

class Shared {
    static int count = 0;
}

//Поток исполнения, увеличивающий значение счетчика на единицу
class IncThread implements Runnable {
    String name;
    Semaphore sem;

    IncThread(Semaphore s, String n) {
        sem = s;
        name = n;
        new Thread(this).start();
    }

    public void run(){
        System.out.println("Запуск потока " + name);
        try{

            //сначала получить разрешение
            System.out.println("Поток " + name + " ожидает разрешения");
            sem.acquire();
            System.out.println("Поток " + name + " получает разрешение");
            //а теперь получить доступ к общему ресурсу

            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);

                //разрешить, если возможно, переключение контекста
                Thread.sleep(10);
            }
        }catch (InterruptedException e){
            System.out.println(e);
        }

        //освободить разрешение
        System.out.println("Поток " + name + " освобождает разрешение");
        sem.release();
    }
}

//Поток исполнения, уменьшающий значение счетчика на единицу
class DecThread implements Runnable{
    String name;
    Semaphore semaphore;

    DecThread(Semaphore semaphore, String n){
        this.semaphore = semaphore;
        this.name = n;
        new Thread(this).start();
    }

    public void run(){
        System.out.println("Запуск потока " + name);

        try{
            //сначала получить разрешение
            System.out.println("Поток " + name + " ожидает разрешения");
            semaphore.acquire();
            System.out.println("Поток " + name + " получает разрешение");

            //а теперь получить доступ к общему ресурсу
            for (int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);

                //разрешить, если возможно, переключение контекста
                Thread.sleep(10);
            }
        }catch (InterruptedException e){
            System.out.println(e);
        }

        //освободить разрешение
        System.out.println("Поток " + name + " освобождает разрешение");
        semaphore.release();
    }
}
