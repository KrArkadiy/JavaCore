package main.java.com.KrArkadiy.javacore.chapter29;

import java.util.ArrayList;
import java.util.Optional;

public class StreamDemo1 {
    public static void main(String[] args) {
        //Создать списочный массив значений типа Integer
        ArrayList<Integer> myList = new ArrayList<Integer>();
        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);

        //Два способа получения результата перемножения целочисленных элементов списка myList с помощью метода reduce()
        Optional<Integer> productObj = myList.stream().reduce((a,b)-> a*b);
        if(productObj.isPresent()){
            System.out.println("Произведение в виде объекта типа Optional: " + productObj.get());
        }

        int product = myList.stream().reduce(1, (a,b)->a*b);
        System.out.println("Произведение в виде значения int: " + product);
    }
}
