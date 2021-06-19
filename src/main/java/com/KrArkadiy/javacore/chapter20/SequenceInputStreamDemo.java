package main.java.com.KrArkadiy.javacore.chapter20;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

class InputStreamEnumeration implements Enumeration<FileInputStream>{
    private Enumeration<String> files;

    public InputStreamEnumeration(Vector<String> files){
        this.files = files.elements();
    }

    public boolean hasMoreElements(){
        return files.hasMoreElements();
    }

    public FileInputStream nextElement(){
        try{
            return new FileInputStream(files.nextElement().toString());
        } catch (IOException e){
            return null;
        }
    }
}

public class SequenceInputStreamDemo {
    public static void main(String[] args) {
        int c;
        Vector<String> files = new Vector<String>();

        files.addElement("file1.txt");
        files.addElement("file2.txt");
        files.addElement("file3.txt");
        InputStreamEnumeration ise = new InputStreamEnumeration(files);

        try(InputStream input = new SequenceInputStream(ise)){
            while((c = input.read())!= -1){
                System.out.print((char) c);
            }
        } catch (IOException e) {
            System.out.println("Ошибка закрытия потока ввода SequenceInputStream");
        } catch (NullPointerException e){
            System.out.println("Ошибка открытия файла.");
        }
    }
}
