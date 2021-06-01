package main.java.com.KrArkadiy.javacore.chapter18;

import java.io.*;
import java.util.Properties;

public class PhoneBook {
    public static void main(String[] args) {
        Properties ht = new Properties();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String number, name;
        FileInputStream fin = null;
        boolean changed = false;

        //попытка открыть файл phonebook.dat
        try {
            fin = new FileInputStream("phonebook.dat");
        } catch (FileNotFoundException e) {
            //игнорировать отсутствие файла
        }

        //Если телефонная книга уже существует, загрузить существующие телефонные номера.
        try {
            if (fin != null) {
                ht.load(fin);
                fin.close();
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла");
        }
        //разрешить пользователю вводить новые имена и номера телефонов абонентов
        try {
            do {
                System.out.println("Введите Имя" + " ('выход' для завершения): ");
                name = br.readLine();
                if (name.equals("выход")) {
                    continue;
                }
                System.out.println("Введите номер: ");
                number = br.readLine();
                ht.put(name, number);
                changed = true;
            } while (!name.equals("выход"));
        } catch (IOException e) {
            System.out.println("Ошибка " + e);
        }
        //сохранить телефонную книгу, если она изменилась
        try {
            if (changed) {
                FileOutputStream fout = new FileOutputStream("phonebook.dat");
                ht.store(fout, "Телефонная книга");
                fout.close();
            }
        } catch (IOException e) {
            System.out.println("Ошибка " + e);
        }
        //искать номер по имени абонента
        try {
            do {
                System.out.println("Введите Имя" + "('выход' для завершения): ");
                name = br.readLine();
                if (name.equals("выход")) {
                    continue;
                }
                number = (String) ht.getProperty(name);
                System.out.println(number);
            } while (!name.equals("выход"));
        } catch (IOException e) {
            System.out.println("Ошибка " + e);
        }
    }
}
