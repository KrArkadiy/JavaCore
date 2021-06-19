package main.java.com.KrArkadiy.javacore.chapter21;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ExplicitChannelRead1 {
    public static void main(String[] args) {
        FileInputStream fin = null;
        FileChannel fChan = null;
        ByteBuffer mBuf;
        int count;

        try {
            //сначала открыть файл для ввода
            fin = new FileInputStream("test.txt");

            //затем получить канал к этому файлу
            fChan = fin.getChannel();

            //выделить оперативную память под буфер
            mBuf = ByteBuffer.allocate(128);

            do {
                //читать данные в буфер
                count = fChan.read(mBuf);

                //прекратить чтение по достижении конца файла
                if (count != -1) {
                    //подготовить буфер к чтению из него данных
                    mBuf.rewind();

                    //читать байты данных из буфера и выводить их на экран как символы
                    for (int i = 0; i < count; i++) {
                        System.out.print((char) mBuf.get());
                    }
                }
            } while (count != -1);
            System.out.println();
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        } finally {
            try {
                if (fChan != null) {
                    fChan.close();//закрыть канал
                }
            } catch (IOException e) {
                System.out.println("Ошибка закрытия канала.");
            }
            try {
                if (fin != null) {
                    fin.close();//закрыть файл
                }
            } catch (IOException e) {
                System.out.println("Ошибка закрытия файла");
            }
        }
    }
}
