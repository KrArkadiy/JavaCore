package main.java.com.KrArkadiy.javacore.chapter21;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MappedChannelWrite {
    public static void main(String[] args) {
        //получить канал к файлу в блоке try с ресурсами
        try(FileChannel fChan = (FileChannel) Files.newByteChannel(Paths.get("test.txt"), StandardOpenOption.WRITE,
                StandardOpenOption.READ, StandardOpenOption.CREATE)) {
            //сопоставить файл с буфером
            MappedByteBuffer mBuf = fChan.map(FileChannel.MapMode.READ_WRITE, 0, 26);

            //записать заданнойе количество байтов  буфер
            for (int i = 0; i < 26; i++) {
                mBuf.put((byte) ('A' + i));
            }
        }catch (InvalidPathException e){
            System.out.println("Ошибка указания пути " + e);
        } catch (IOException e){
            System.out.println("Ошибка ввода-вывода " + e);
        }
    }
}
