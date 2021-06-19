package main.java.com.KrArkadiy.javacore.chapter21;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedChannelRead1 {
    public static void main(String[] args) {
        FileInputStream fin = null;
        FileChannel fChan = null;
        long size;
        MappedByteBuffer mBuf;

        try{
            //сначала октрыть файл для ввода
            fin = new FileInputStream("test.txt");

            //получить канал к этому файлу
            fChan = fin.getChannel();

            //получить размер файла
            size = fChan.size();

            mBuf = fChan.map(FileChannel.MapMode.READ_ONLY, 0 , size);

            //читать байты из буфера и выводить их на экран
            for (int i = 0; i < size; i++) {
                System.out.print((char) mBuf.get());
            }
        }catch (IOException e){
            System.out.println("Ошибка ввода-вывода");
        } finally {
            try{
                if(fChan != null){
                    fChan.close();//закрыть канал
                }
            }catch (IOException e){
                System.out.println("Ошибка закрытия канала");
            }
            try{
                if(fin != null){
                    fin.close();//закрыть файл
                }
            }catch (IOException e){
                System.out.println("Ошибка закрытия файла");
            }
        }
    }
}
