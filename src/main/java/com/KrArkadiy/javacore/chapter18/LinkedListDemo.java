package main.java.com.KrArkadiy.javacore.chapter18;


import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        //создать связный список
        LinkedList<String> l1 = new LinkedList<>();

        //ввести элементы в связный список
        l1.add("F");
        l1.add("B");
        l1.add("D");
        l1.add("E");
        l1.add("C");
        l1.addLast("Z");
        l1.addFirst("A");
        l1.add(1, "A2");
        System.out.println("Исходное содержимое связного списка l1: " + l1);

        //удалить элементы из связного списка
        l1.remove("F");
        l1.remove(2);
        System.out.println("Содержимое связного списка l1 после удаления элементов: " + l1);
        //удалить первый и последний элементы из связного списка
        l1.removeFirst();
        l1.removeLast();

        System.out.println("Содержимое связного списка l1 после удаления первого и последнего элементов: " + l1);

        //получить и присвоить значение
        String val = l1.get(2);
        l1.set(2, val + "изменено");

        System.out.println("Содержимое связного списка l1 после изменения: " + l1);
    }
}
