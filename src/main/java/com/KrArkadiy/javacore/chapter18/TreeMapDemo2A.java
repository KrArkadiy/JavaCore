package main.java.com.KrArkadiy.javacore.chapter18;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*class CompLastNames implements Comparator<String>{
    public int compare(String aStr, String bStr){
        int i, j;

        //найти индекс символа с которого начинается фамилия
        i = aStr.lastIndexOf(' ');
        j = bStr.lastIndexOf(' ');
        return aStr.substring(i).compareToIgnoreCase(bStr.substring(j));
    }
}

//отсоритровать счета вкладчиков по Ф.И.О., если фамилии одинаковы
class CompThenByFirstName implements Comparator<String>{
    public int compare(String aStr, String bStr) {
        int i, j;

        return aStr.compareToIgnoreCase(bStr);
    }
}*/

public class TreeMapDemo2A {
    public static void main(String[] args) {
        //использовать метод thenComparing() для создания компаратора, сравнивающего сначала фамилии, а затем Ф.И.О
        //вкладчиков, если они одинаковы
        Comparator<String> CompLastNames = ((aStr,bStr)-> aStr.substring(aStr.lastIndexOf(' '))
                .compareToIgnoreCase(bStr.substring(bStr.lastIndexOf(' '))));
        Comparator<String> CompThenByFirstName = ((aStr, bStr)->aStr.compareToIgnoreCase(bStr));

        //создать древовидное отображение
        TreeMap<String, Double> tm = new TreeMap<String, Double>(CompLastNames.thenComparing(CompThenByFirstName));

        //ввести элементы в древовидное-отображение
        tm.put("Джон Доу", 3434.34);
        tm.put("Том Смит", 123.22);
        tm.put("Джейн Бейкер", 1378.00);
        tm.put("Тодд Холл", 99.22);
        tm.put("Ральф Смит", -19.08);

        //получить множество записей
        Set<Map.Entry<String, Double>> set = tm.entrySet();

        //вывести множество записей
        for (Map.Entry<String, Double> me : set) {
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        System.out.println();

        //внести сумму 1000 на счет Джона Доу
        double balance = tm.get("Джон Доу");
        tm.put("Джон Доу", balance + 1000);
        System.out.println("Новый остаток на счете Джона Доу: " + tm.get("Джон Доу"));
    }
}
