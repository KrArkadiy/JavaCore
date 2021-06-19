package main.java.com.KrArkadiy.javacore.chapter20;

public class PrintfDemo {
    public static void main(String[] args) {
        System.out.println("Ниже приведены некоторые числовые значения в разных форматах.\n");

        System.out.printf("Разные целочисленный форматы: ");
        System.out.printf("%d %(d %+d %05d\n",3,-3,3,3);

        System.out.println();
        System.out.printf("Формат чисел с плавающей точкой по умолчанию: %f\n", 123456.123);
        System.out.printf("Формат чисел с плавающий точкой, разделяемых запятыми: %,f\n", 123456.132);
        System.out.printf("Формат отрицательных чисел с плавающей точкой по умолчанию: %,f\n", -1234567.123);
        System.out.printf("Другой формат отрицательных чисел с плавающей точкой: %,(f\n",-1234567.123);

        System.out.println();

        System.out.printf("Выравнивание положительных и отрицательных числовых значений:\n");
        System.out.printf("% ,.2f\n% ,.2f\n",-1234567.123,1234567.123);
    }
}
