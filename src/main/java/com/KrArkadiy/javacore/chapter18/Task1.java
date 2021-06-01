package main.java.com.KrArkadiy.javacore.chapter18;

import java.util.ArrayList;
import java.util.Scanner;

/*Необходимо реализовать алгоритм, который принимает на вход две коллекции целых чисел и возвращает
      отсортированную коллекцию, содержащую общие элементы.
    */
public class Task1 {
    public static ArrayList<Integer> firstCollection = new ArrayList<>();
    public static ArrayList<Integer> secondCollection = new ArrayList<>();
    public static ArrayList<Integer> resultCollection = new ArrayList<>();
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String str;
            do {
                str = sc.next();
                if (str.equals("exit")) {
                    break;
                } else {
                    firstCollection.add(Integer.parseInt(str));
                    sc.nextLine();
                }
            } while (str !="exit");
            do {
                str = sc.next();
                if (str.equals("exit")) {
                    break;
                } else {
                    secondCollection.add(Integer.parseInt(str));
                    sc.nextLine();
                }
            } while (str !="exit");
            for (int i = 0; i < firstCollection.size(); i++) {
                for (int j = 0; j < secondCollection.size(); j++) {
                if(firstCollection.get(i) == secondCollection.get(j)){
                    resultCollection.add(firstCollection.get(i));
                }
                }
            }
            resultCollection.sort((i, b)->i.compareTo(b));
            System.out.println(firstCollection);
            System.out.println(secondCollection);
            System.out.println(resultCollection);
        }
}
