package main.java.com.KrArkadiy.javacore.chapter15;

interface MyFunc5<T>{
    MyClass3<T> func(T n);
}

class MyClass3<T>{
    private T val;

    //Этот конструктор принимает один аргумент
    MyClass3(T v){
        val = v;
    }

    //А это конструктор по умолчанию

    MyClass3(){
        val = null;
    }

    T getVal(){
        return val;
    }
}

public class ConstructorRefDemo2 {
    public static void main(String[] args) {
        //Создать ссылку на конструктор обобщенного класса MyClass<T>
        MyFunc5<Integer> myClassCons = MyClass3<Integer>::new;

        //Создать экземпляр класса MyClass3<T>
        MyClass3<Integer> mc = myClassCons.func(100);

        //Воспользоваться только что созданным экземпляром класса MyClass<T>
        System.out.println("Значение val в объекте mc равно " + mc.getVal());
    }
}
