package main.java.com.KrArkadiy.javacore.chapter13;
/*  В этой версии программы ShowFile оператор try c ресурсами применяется для автоматического закрытия файла

    Примечание: для выполнения этого кода требуется версия JDK 7
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ShowFileAuto {
    public static void main(String[] args) {
        int i;

        //Сначала убедиться, что имя файла указано
        if (args.length != 1) {
            System.out.println("Использование: ShowFile имя_файла");
            return;
        }

        //Ниже оператор try с ресурсами применяется сначала для открытия, а затем для автоматического закрытия,
        //а затем для автоматического закрытия файла по завершении блока этого оператор
        try (FileInputStream fin = new FileInputStream(args[0])) {
            do {
                i = fin.read();
                if (i != -1) {
                    System.out.println((char) i);
                }
            } while (i != -1);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        } catch (IOException e) {
            System.out.println("Произошла ошибка ввода-вывода");
        }
    }
}
