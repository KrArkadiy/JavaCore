package main.java.com.KrArkadiy.javacore.chapter22;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpConnectTimeoutException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpURLDemo {
    public static void main(String[] args) throws Exception{
        URL hp = new URL("http://google.com");
        HttpURLConnection hpCon = (HttpURLConnection) hp.openConnection();

        //вывести метод запроса
        System.out.println("Метод запроса: " + hpCon.getRequestMethod());

        //вывести код ответа
        System.out.println("Код ответа: " + hpCon.getResponseCode());

        //Вывести ответное сообщение
        System.out.println("Ответное сообщение: " + hpCon.getResponseMessage());

        //получить список полей и множество ключей из заголовка
        Map<String, List<String>> hdrMap = hpCon.getHeaderFields();
        Set<String> hdrFields = hdrMap.keySet();
        System.out.println("\nДалее следует заголовок: ");

        //вывести все ключи и значения из заголовка
        for(String s:hdrFields){
            System.out.println("Ключ: " + s + " Значение: " + hdrMap.get(s));
        }
    }
}
