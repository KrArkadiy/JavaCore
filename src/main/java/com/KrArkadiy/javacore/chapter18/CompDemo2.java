package main.java.com.KrArkadiy.javacore.chapter18;

import java.util.TreeSet;

public class CompDemo2 {
    public static void main(String[] args) {

        //передать компаратор с обратным упорядочением древовидному множеству типа TreeSet
        TreeSet<String> ts = new TreeSet<String>((aStr, bStr)-> bStr.compareTo(aStr));

        //ввести элементы в древовидное множество
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");
        //вывести элементы ищ древовидного множества
        for (String element: ts) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
