package main.java.com.KrArkadiy.javacore.chapter11;

//создать несколько потоков исполнения
class NewThread2 implements Runnable{
    String name; // имя потока исполнения

    Thread t;

    NewThread2(String threadName){
        name = threadName;
        t = new Thread(this, name);
        System.out.println("Новый поток: " + t);
        t.start();
    }

    public void run(){
        try{
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ";" + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println(name + " прерван");
        }
        System.out.println(name + " завершен");
    }
}

public class MultiThreadDemo {
    public static void main(String[] args) {
        new NewThread2("Один"); // запустить потоки на исполнение
        new NewThread2("Два");
        new NewThread2("Три");

        try{
            //ожидать завершения других потоков исполнения
            Thread.sleep(10000);
        } catch (InterruptedException e){
            System.out.println("Главный поток прерван");
        }
        System.out.println("Главный поток завершен.");
    }
}
