package main.java.com.KrArkadiy.javacore.chapter18;

public class Task2 {
    static boolean checkBrackets(String str){
        int counter = 0;
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(' || array[i] == '{' || array[i] == '[') {
                counter++;
            } else if (array[i] == ')' || array[i] == '}' || array[i] == ']') {
                counter--;
            }
        }
        if(counter == 0){
            return true;
        }else {
            return false;
        }
    }
}


