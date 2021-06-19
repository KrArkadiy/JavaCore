package main.java.com.KrArkadiy.javacore.chapter20;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
    public static void main(String[] args) {
        String source = "Now is the time for all good men to come to the aid of their country and pay their due taxes.";
        byte buf[] = source.getBytes();

        //применить оператор try с ресурсами для закрытия файлов
        try(FileOutputStream f0 = new FileOutputStream("file1.txt");
            FileOutputStream f1 = new FileOutputStream("file2.txt");
            FileOutputStream f2 = new FileOutputStream("file3.txt")){

            //записать данные в первый файл
            for (int i = 0; i < buf.length; i += 2){
                f0.write(buf);
            }

            //записать данные во второй файл
            f1.write(buf);

            //записать данные в третий файл
            f2.write(buf, buf.length - buf.length/4, buf.length/4);
        }catch (IOException e){
            System.out.println("Произошла ошибка ввода-вывода");
        }
    }
}
