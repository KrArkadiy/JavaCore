package com.KrArkadiy.javacore.chapter28;

//Расширить класс Phaser и переопределить метод onAdvance()
//таким образом, чтобы было вополненно только определенное количество фаз

import java.util.concurrent.Phaser;

class MyPhaser extends Phaser {
    int numPhases;

    MyPhaser(int parties, int numCount) {
        super(parties);
        numPhases = numCount - 1;
    }

    //переопределить метод onAdvance(), чтобы выполнить определенное количество фаз
    protected boolean onAdvance(int p, int regParties) {
        //следующий оператор println() требуется только для целей иллюстрации. Как правило, метод onAdvance()
        //не отображает выводимые данные
        System.out.println("Фаза " + p + " завершена.\n");

        //возвратить логическое значение true, если все фазы завершены
        if (p == numPhases || regParties == 0) {
            return true;
        }

        //В противном случае возвратить логическое значение false
        return false;
    }
}

public class PhaserDemo2 {
    public static void main(String[] args) {
        MyPhaser myPhaser = new MyPhaser(1, 4);

        System.out.println("Запуск потоков\n");

        new MyThread3(myPhaser, "A");
        new MyThread3(myPhaser, "B");
        new MyThread3(myPhaser, "C");

        //ожидать завершения опеределенного количества фаз
        while (!myPhaser.isTerminated()) {
            myPhaser.arriveAndAwaitAdvance();
        }
        System.out.println("Синхронизатор фаз завершен");
    }
}

//Поток исполнения, использующий синхронизатор фаз типа Phaser
class MyThread3 implements Runnable {
    String name;
    Phaser phaser;

    MyThread3(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        phaser.register();
        new Thread(this).start();
    }

    public void run() {
        while (!phaser.isTerminated()) {
            System.out.println("Поток " + name + " начинает фазу " + phaser.getPhase());
            phaser.arriveAndAwaitAdvance();

            //Небольшая пауза, чтобы не нарушить порядок вывода.
            //Только для иллюстрации, но необязательно для правильного функционирования синхронизатора фаз
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
