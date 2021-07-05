package main.java.com.KrArkadiy.javacore.chapter11;

class NewThread1 extends Thread{

    NewThread1(){
        //создать новый поток исполнения
        super("Новый поток исполнения");
        System.out.println("Дочерний поток: " + this);
        start();
    }

    public  void run(){
        try{
            for (int i = 5; i > 0; i--) {
                System.out.println("Дочерний поток: " + i);
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            System.out.println("Дочерний поток прерван.");
        }
        System.out.println("Дочерний поток завершен.");
    }
}

class ExtendThread {
    public static void main(String[] args) {
        new NewThread1();

        try{
            for (int i = 5; i > 0; i--) {
                System.out.println("Главный поток: " + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("Главный поток прерван.");
        }
        System.out.println("Главный поток завершен.");
    }
}
