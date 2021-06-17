package main.java.com.KrArkadiy.javacore.chapter15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MyClass{
    private int val;

    MyClass(int v){
        val = v;
    }

    int getVal(){
        return val;
    }
}

public class UseMethodRef {
    //Метод compare(), совместимый с аналогичным методом, определенным в интерфейсе Comparator<T>
    static int compareMC(MyClass a, MyClass b){
        return a.getVal() - b.getVal();
    }

    public static void main(String[] args) {
        List<MyClass> al = new ArrayList<MyClass>();

        al.add(new MyClass(1));
        al.add(new MyClass(4));
        al.add(new MyClass(2));
        al.add(new MyClass(9));
        al.add(new MyClass(3));
        al.add(new MyClass(7));

        //найти максимальное значение, используя метод compareMC()
        MyClass maxValueObj = Collections.max(al, UseMethodRef::compareMC);

        System.out.println("Максимальное значение равно: " + maxValueObj.getVal());
    }
}
