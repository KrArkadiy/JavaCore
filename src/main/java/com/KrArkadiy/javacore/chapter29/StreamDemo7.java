package main.java.com.KrArkadiy.javacore.chapter29;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class StreamDemo7 {
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

        //получить итератор-разделитель
        Spliterator<String> splitItr = myStream.spliterator();

        //перебрать элементы в потоке данных
        while(splitItr.tryAdvance((n)-> System.out.println(n)));
    }
}
