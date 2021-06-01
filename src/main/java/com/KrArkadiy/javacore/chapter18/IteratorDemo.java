package main.java.com.KrArkadiy.javacore.chapter18;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

class IteratorDemo{
    public static void main(String[] args) {
        //создать списочный массив
        ArrayList<String> al = new ArrayList<String>();

        //ввести элементы в списочный массив
        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");

        //использовать итераторы для вывода содержимого списочного массива а1
        System.out.print("Исходное содержимое списочного массива а1: ");
        Iterator<String> itr = al.iterator();
        while(itr.hasNext()){
            String element = itr.next();
            System.out.print(element + " ");
        }
        System.out.println();

        //видоизменить перебираемые объекты
        ListIterator<String> litr = al.listIterator();
        while (litr.hasNext()){
            String element = litr.next();
            litr.set(element + "+");
        }
        System.out.print("Измененное содержимое списочного массива а1: ");
        itr = al.iterator();
        while(itr.hasNext()){
            String element = itr.next();
            System.out.print(element + " ");
        }
        System.out.println();

        //а теперь отобразить список в обратном порядке
        System.out.print("Измененный в обратном порядке список: ");
        while (litr.hasPrevious()){
            String element = litr.previous();
            System.out.print(element +" ");
        }
        System.out.println();
    }
}

