package main.java.com.KrArkadiy.javacore.chapter20;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) {
        //Произвести сериализацию объекта
        try(ObjectOutputStream objStream = new ObjectOutputStream(new FileOutputStream("serial"))){
            MyClass object1 = new MyClass("Hello", -7, 2.7e10);
            System.out.println("object1: " + object1);

            objStream.writeObject(object1);
        } catch (IOException e){
            System.out.println("Исключение при сериализации: " + e);
        }

        //Произвести десериализацию объекта
        try(ObjectInputStream objIStream = new ObjectInputStream(new FileInputStream("serial"))){
            MyClass object2 = (MyClass)objIStream.readObject();
            System.out.println("object2: " + object2);
        } catch (Exception e){
            System.out.println("Исключение при десереализации: " + e);
        }
    }
}
class MyClass implements Serializable{
    String s;
    int i;
    double d;

    public MyClass(String s,int i, double d){
        this.s = s;
        this.i = i;
        this.d = d;
    }

    public String toString(){
        return "s=" + s + "; =" + i + "; d=" + d;
    }
}
