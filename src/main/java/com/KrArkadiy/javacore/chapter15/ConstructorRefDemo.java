package main.java.com.KrArkadiy.javacore.chapter15;

interface MyFunc4{
    MyClass2 func(int n);
}

class MyClass2{
    private int val;

    //Этот конструктор принимает один аргумент
    MyClass2(int v){
        val = v;
    }

    //А это конструктор по умолчанию
    MyClass2(){
        val = 0;
    }

    //...

    int getVal(){
        return val;
    }
}

public class ConstructorRefDemo {
    //Создать ссылку на конструктор класса MyClass2
    //Метод func() из интерфейса MyFunc принимает аргумент, поэтому оператор new обращается к параметризированному
    //конструктору класса MyClass2, а не к его конструктору по умолчанию
    public static void main(String[] args) {
        MyFunc4 myClassCons = MyClass2::new;

        //создать экземпляр класса MyClass2 по сслыке на его конструктор
        MyClass2 mc = myClassCons.func(100);

        //использовать только что созданный экземпляр класса MyClass
        System.out.println("Значение val в объекте mc равно " + mc.getVal());
    }
}