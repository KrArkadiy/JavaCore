package com.KrArkadiy.javacore.chapter28;

//Простой пример применения класса RecursiveTask<V>

import java.util.concurrent.*;


//Класс RecursiveTask, используемый для вычисление суммы значений элементов в массиве типа double
class Sum1 extends RecursiveTask<Double> {

    //Пороговое значение последовательного выполнения
    final int seqThresHold = 500;

    //Обрабатываемый массив
    double[] data;

    //определить часть обрабатываемых данных
    int start, end;

    Sum1(double[] vals, int s, int e) {
        data = vals;
        start = s;
        end = e;
    }
    //определить сумму значений элементов в массиве типа double

    protected Double compute() {
        double sum = 0;

        //Если количество элементов ниже порогового значения, то выполнить далее обработку последовательно
        if ((end - start) < seqThresHold) {
            //суммировать значения элементов в массиве типа double
            for (int i = start; i < end; i++) {
                sum += data[i];
            }
        } else {
            //в противном случае продолжить разделение данных на меньшие части

            //найти середину
            int middle = (start + end) / 2;

            //запустить новые подзадачи на выполнение, используя разделенные на части данные
            Sum1 subTaskA = new Sum1(data, start, middle);
            Sum1 subTaskB = new Sum1(data, middle, end);

            //запустить каждую подзачу путем разветвления
            subTaskB.fork();
            subTaskA.fork();

            //ожидать завершения подзадач и накопить результаты
            sum = subTaskA.join() + subTaskB.join();
        }
        //возвратить конечную сумму
        return sum;
    }
}

public class RecursiveTaskDemo {
    public static void main(String[] args) {
        //создать пул задач
        ForkJoinPool fjp = new ForkJoinPool();

        double[] nums = new double[5000];

        //инициализировать массив nums чередующимися положительными и отрицательными значениями
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double) (((i % 2) == 0) ? i : -i);
        }
        Sum1 task = new Sum1(nums, 0, nums.length);

        //Запустить задачи типа ForkJoinTask. Обратите внимание на то, что в данном случае метод invoke()
        //возвращает результат
        double summation = fjp.invoke(task);

        System.out.println("Суммирование " + summation);
    }
}
