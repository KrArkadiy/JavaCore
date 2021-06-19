package main.java.com.KrArkadiy.javacore.chapter20;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class BufferedInputStreamDemo {
    public static void main(String[] args) {
        String s = "Это знак авторского права &copy;, а &copy - нет.\n";
        byte buf[] = s.getBytes();

        ByteArrayInputStream in = new ByteArrayInputStream(buf);
        int c;
        boolean marked = false;

        //использовать оператор try с ресурсами для управления файлами
        try(BufferedInputStream f = new BufferedInputStream(in)){
            while((c = f.read()) != -1){
                switch (c){
                    case '&' :
                        if(!marked){
                            f.mark(32);
                            marked = true;
                        } else{
                            marked = false;
                        }
                        break;
                    case ';':
                        if(marked){
                            marked = false;
                            System.out.print("(c)");
                        } else{
                            System.out.print((char) c);
                        }
                    case' ':
                        if(marked){
                            marked = false;
                            System.out.print("&");
                        } else{
                            System.out.print((char) c);
                        }
                        break;
                    default:
                        if(!marked){
                            System.out.print((char) c);
                        }
                        break;
                }
            }
        }catch (IOException e){
            System.out.println("Ошибка ввода-вывода: " + e);
        }
    }
}
