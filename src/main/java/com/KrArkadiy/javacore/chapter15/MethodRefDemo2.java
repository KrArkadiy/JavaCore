package main.java.com.KrArkadiy.javacore.chapter15;

interface StringFunc4{
    String func(String n);
}

//Теперь в этом классе определяется метод экземпляра strReverse()
class MyStringOps2{
    String strReverse1(String str){
        String result = "";
        int i;
        for (i = str.length()-1; i>=0;i--){
            result+=str.charAt(i);
        }
        return result;
    }
}
public class MethodRefDemo2 {
    //В этом методе функциональный интерфейс указывается в качестве типа первого его параметра. Следовательно, ему может
    //быть передан любой экземпляр этого интерфейса, включая и ссылку на метод
    static String stringOp2(StringFunc4 sf, String s){
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Лябмда-выражения повышают эффективность Java";
        String outStr;

        //создать объект типа MyStringOps
        MyStringOps2 strOps = new MyStringOps2();

        //А теперь ссылка на метод экземпляра strReverse1() передается методу stringOp2()
        outStr = stringOp2(strOps::strReverse1, inStr);

        System.out.println("Исходная строка: " + inStr);
        System.out.println("Обращенная строка: " + outStr);
    }
}
