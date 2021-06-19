package main.java.com.KrArkadiy.javacore.chapter29;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

public class StreamDemo6 {
    public static void main(String[] args) {
        //Создать список символьных строк
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Alpha");
        myList.add("Beta");
        myList.add("Gamma");
        myList.add("Delta");
        myList.add("Ksi");
        myList.add("Omega");

        //получить поток данных для списочного массива
        Stream<String> myStream = myList.stream();

        //получить итератор для потока данных
        Iterator<String> itr = myList.iterator();

        //перебрать элементы в потоке данных
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
