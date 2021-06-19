package main.java.com.KrArkadiy.javacore.chapter29;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class NamePhoneEmail1 {
    String name;
    String phone;
    String email;

    NamePhoneEmail1(String n, String p, String e) {
        name = n;
        phone = p;
        email = e;
    }
}
class NamePhone1 {
    String name;
    String phone;

    NamePhone1(String n, String p) {
        name = n;
        phone = p;
    }
}
public class StreamDemo5 {
    public static void main(String[] args) {
        //Список имен, номеров телефонов и адресов электронной почты
        ArrayList<NamePhoneEmail1> myList = new ArrayList<>();
        myList.add(new NamePhoneEmail1("Ларри", "555-5555", "Larry@HebrSchildt.com"));
        myList.add(new NamePhoneEmail1("James", "555-4444", "James@HerbSchildt.com"));
        myList.add(new NamePhoneEmail1("Mary", "555-3333", "Mary@HerbSchildt.com"));
        //отобразить только имена и номера телефонов на новый поток данных
        Stream<NamePhone1> nameAndPhone = myList.stream().map((a) -> new NamePhone1(a.name, a.phone));

        //вызвать метод collect(), чтобы составить список типа List из имен и номеров телефонов
        List<NamePhone1> npList = nameAndPhone.collect(Collectors.toList());

        System.out.println("Имена и номера телефонов в списке типа List:");
        for (NamePhone1 e : npList) {
            System.out.println(e.name + " " + e.phone);

            //получить другое отображение имен и номеров телефонов
            Stream<NamePhone1> nameAndPhoneSet = myList.stream().map((a) -> new NamePhone1(a.name, a.phone));
            Set<NamePhone1> npSet = nameAndPhoneSet.collect(Collectors.toSet());
            System.out.println("Имена и номера телефонов в списке типа Set:");
            for (NamePhone1 np : npSet) {
                System.out.println(np.name + " " + np.phone);
            }
        }
    }
}
