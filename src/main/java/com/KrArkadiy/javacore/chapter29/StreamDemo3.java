package main.java.com.KrArkadiy.javacore.chapter29;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Stream;

public class StreamDemo3 {
    public static void main(String[] args) {
        //Создать списочный массив значений типа Integer
        ArrayList<Double> myList = new ArrayList<>();
        myList.add(7.0);
        myList.add(18.0);
        myList.add(10.0);
        myList.add(24.0);
        myList.add(17.0);
        myList.add(5.0);

        //Отобразить квадратные корни элементов из списка myList на новый поток данных
        Stream<Double> sqrtRootStrm = myList.stream().map((a)-> Math.sqrt(a));

        //получить произведение квадратных корней
        double productOfSqrRoots = sqrtRootStrm.reduce(1.0, (a,b)->a*b);

        System.out.println("Произведение квадратный корней равно " + productOfSqrRoots);
    }
}
