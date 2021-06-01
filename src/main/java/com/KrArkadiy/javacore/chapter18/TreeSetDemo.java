package main.java.com.KrArkadiy.javacore.chapter18;

import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        //Создать древовидное множество типа TreeSet
        TreeSet<String> ts = new TreeSet<String>();

        //ввести элементы в древовоидное множество типа TreeSet
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");

        System.out.println(ts);
    }
}
