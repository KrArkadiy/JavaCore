package main.java.com.KrArkadiy.javacore.chapter29;

import main.java.com.KrArkadiy.javacore.chapter18.PhoneBook;

import java.util.ArrayList;
import java.util.stream.Stream;

public class NamePhoneEmail {
    String name;
    String phone;
    String email;

    NamePhoneEmail(String n, String p, String e) {
        name = n;
        phone = p;
        email = e;
    }
}
 class NamePhone {
     String name;
     String phone;

     NamePhone(String n, String p) {
         name = n;
         phone = p;
     }
 }
    class StreamDemo4 {
        public static void main(String[] args) {
            //Список имен, номеров телефонов и адресов электронной почты
            ArrayList<NamePhoneEmail> myList = new ArrayList<>();
            myList.add(new NamePhoneEmail("Ларри", "555-5555", "Larry@HebrSchildt.com"));
            myList.add(new NamePhoneEmail("James", "555-4444", "James@HerbSchildt.com"));
            myList.add(new NamePhoneEmail("Mary", "555-3333", "Mary@HerbSchildt.com"));

            System.out.println("Исходные элементы из списка myList: ");
            myList.stream().forEach((a) -> {
                System.out.println(a.name + " " + a.email + " " + a.phone);
            });
            System.out.println();

            //отобразить на новый поток данных только имена и номера телефонов
            Stream<NamePhone> nameAndPhone = myList.stream().map((a) -> new NamePhone(a.name, a.phone));

            System.out.println("Список имен и номеров телефонов: ");
            nameAndPhone.forEach((a) -> {
                System.out.println(a.name + " " + a.phone);
            });
        }
    }



