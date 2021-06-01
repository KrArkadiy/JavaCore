package main.java.com.KrArkadiy.javacore.chapter18;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackDemo {
    static void showPush(Stack<Integer> st, int a){
        st.push(a);
        System.out.println("push(" + a + ")");
        System.out.println("стек: " + st);
    }
    static void showPop(Stack<Integer> st){
        System.out.print("pop->");
        Integer a = st.pop();
        System.out.println(a);
        System.out.println("стек: " + st);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<Integer>();

        System.out.println("стек: " + st);

        showPush(st, 42);
        showPush(st, 66);
        showPush(st, 99);
        showPop(st);
        showPop(st);
        showPop(st);

        try{
            showPop(st);
        }catch (EmptyStackException e){
            System.out.println("стек пуст");
        }
    }
}
