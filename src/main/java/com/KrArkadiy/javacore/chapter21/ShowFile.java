package main.java.com.KrArkadiy.javacore.chapter21;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class ShowFile {
    public static void main(String[] args) {
        int i;

        //сначала удостовериться, что указано имя файла
        if(args.length != 1){
            System.out.println("Применение: ShowFile имя_файла");
            return;
        }

        //открыть файл и получить связанный с ним поток ввода-вывода
        try(InputStream fin = Files.newInputStream(Paths.get(args[0]))){
            do {
                i = fin.read();
                if(i != -1){
                    System.out.print((char) i);
                }
            }while(i != -1);
        } catch (InvalidPathException e){
            System.out.println("Ошибка в указании пути " + e);
        } catch (IOException e){
            System.out.println("Ошибка ввода и вывода " + e);
        }
    }
}
