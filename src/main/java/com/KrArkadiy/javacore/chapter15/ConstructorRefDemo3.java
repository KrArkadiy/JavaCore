package main.java.com.KrArkadiy.javacore.chapter15;

interface MyFunc6<R,T>{
    R func(T n);
}

class MyClass4<T> {
    private T val;

    MyClass4(T v) {
        val = v;
    }

    T getVal() {
        return val;
    }
}
    class MyClass5 {
        String str;

        MyClass5(String s) {
            str = s;
        }

        String getVal() {
            return str;
        }
    }

public class ConstructorRefDemo3 {
        //Фабричный метод для объекто разных классов. У каждого класса должен быть свой констурктор,
        //принимающий один параметр типа T. А параметр R обозначает типа создаваемого объекта
        static<R,T> R myClassFactory(MyFunc6<R,T> cons, T v){
            return cons.func(v);
    }

    public static void main(String[] args) {
        //Создать ссылку на конструктор класса MyClass.
        //В данном случае оператор new обращается к конструктору принимающему аргумент
        MyFunc6<MyClass4<Double>, Double> myClassCons = MyClass4<Double>::new;

        //создать экземпляр типа MyClass, используя фабричный метод
        MyClass4<Double> mc = myClassFactory(myClassCons, 100.1);

        //использовать только что созданный экземпляр класс MyClass4
        System.out.println("Значение val в объекте mc равно " + mc.getVal());

        //А теперь создать экземпляр другого класса, используя метод myClassFactory()
        MyFunc6<MyClass5, String> myClassCons2 = MyClass5::new;

        //использовать только что созданный экземпляр класс MyClass5
        MyClass5 mc2 = myClassFactory(myClassCons2, "Лямбда");

        //А теперь создать экземпляр другого класса, используя метод myClassFactory()
        System.out.println("Значение val в объекте mc2 равно " + mc.getVal());
    }
}
