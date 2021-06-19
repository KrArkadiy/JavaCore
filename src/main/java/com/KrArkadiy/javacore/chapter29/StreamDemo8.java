package main.java.com.KrArkadiy.javacore.chapter29;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class StreamDemo8 {
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

        //а теперь разделить первый интератор
        Spliterator<String> splitItr1 = splitItr.trySplit();

        //использовать сначала итератор splitItr1, если нельзя разделить итераторов splitItr
        if(splitItr1 != null){
            System.out.println("Результат, выводимый итератором splitItr1: ");
            splitItr1.forEachRemaining((n)-> System.out.println(n));
        }

        //а теперь воспользоваться итератором splitItr
        System.out.println("\nРезультат, выводимый итератором splitItr: ");
        splitItr.forEachRemaining((n)-> System.out.println(n));
    }
}
