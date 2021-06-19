package main.java.com.KrArkadiy.javacore.chapter21;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class ExplicitChannelWrite1 {
    public static void main(String[] args) {
        FileOutputStream fout = null;
        FileChannel fChan = null;
        ByteBuffer mBuf;

        try{
            fout = new FileOutputStream("test.txt");
            fChan = fout.getChannel();
            mBuf = ByteBuffer.allocate(26);
            for (int i = 0; i < 26; i++) {
                mBuf.put((byte) ('A' + i));
            }
            mBuf.rewind();
            fChan.write(mBuf);
        } catch (IOException e){
            System.out.println("Ошибка ввода-вывода: " + e);
        } finally {
            try{
                if(fChan != null){
                    fChan.close();
                }
            }catch (IOException e){
                System.out.println("Ошибка закрытия канала");
            }
            try{
                if(fout != null){
                    fout.close();
                }
            } catch (IOException e){
                System.out.println("Ошибка закрытия файла");
            }
        }
    }
}
