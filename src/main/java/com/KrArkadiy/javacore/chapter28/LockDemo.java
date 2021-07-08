package com.KrArkadiy.javacore.chapter28;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        new LockThread(lock, "A");
        new LockThread(lock, "B");
    }
}

//общий ресурс
class Shared1 {
    static int count = 0;
}

class LockThread implements Runnable {
    ReentrantLock lock;
    String name;

    LockThread(ReentrantLock l, String n) {
        lock = l;
        name = n;
        new Thread(this).start();
    }

    public void run() {
        System.out.println("Запуск потока " + name);

        try {
            //сначала заблокировать счетчик
            System.out.println("Поток " + name + " ожидает блокировки счетчика");
            lock.lock();
            System.out.println("Поток " + name + " блокрует счетчик.");
            Shared.count++;
            System.out.println("Поток " + name + ": " + Shared.count);
            //а теперь переключение контекста, если это возможно
            System.out.println("Поток " + name + " ожидает");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        } finally {
            //снять блокировку
            System.out.println("Поток " + name + " разблокирует счетчик");
            lock.unlock();
        }
    }
}

