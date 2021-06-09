package main.java.com.KrArkadiy.javacore.chapter10;

import java.security.spec.ECField;

public class SuperSubCatch {
    public static void main(String[] args) {
        try{
            int a = 0;
            int b = 42/a;
        } catch (Exception e){
            System.out.println("Перехватт исключений общего класса Exception.");
       /* } catch (ArithmeticException e){
            System.out.println("Этот код вообще не достижим");*/
        }
    }
}
