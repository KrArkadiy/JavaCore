package main.java.com.KrArkadiy.javacore.chapter21;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class NIOStreamWrite {
    public static void main(String[] args) {
        //открыть файл и получить связанный с ним поток вывода
        try(OutputStream fout = new BufferedOutputStream(Files.newOutputStream(Paths.get("test.txt")))){
            //вывести в поток заданное количество байт
            for (int i = 0; i < 26; i++) {
                fout.write((byte)('A' + i));
            }
        }catch (InvalidPathException e){
            System.out.println("Ошибка указания пути " + e);
        } catch (IOException e){
            System.out.println("Ошибка ввода-вывода " + e);
        }
    }
}
