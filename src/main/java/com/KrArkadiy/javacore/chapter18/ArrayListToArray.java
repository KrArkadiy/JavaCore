package main.java.com.KrArkadiy.javacore.chapter18;

import java.util.ArrayList;

public class ArrayListToArray {
    public static void main(String[] args) {
        ArrayList<Integer> a1 = new ArrayList<Integer>();

        //ввести элемент в списочный массив
        a1.add(1);
        a1.add(2);
        a1.add(3);
        a1.add(4);

        System.out.println("Содержимое списочного массива а1: " + a1);

        //получить обычный массив
        Integer ia[] = new Integer[a1.size()];
        ia = a1.toArray(ia);

        int sum = 0;

        //суммировать элементы массива
        for(int i : ia) sum+=i;

        System.out.println("Сумма: " + sum);
    }
}
