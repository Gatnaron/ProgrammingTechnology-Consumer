package org.example.pattern;

import org.example.model.Visitor;

import java.util.LinkedList;
import java.util.Queue;
//Реализация конкурентной коллекции
public class DataQueue {
    private final Queue<Visitor> list;
    private final int maxSize;

    public DataQueue(int maxSize)
    {
        list = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public void add(Visitor model) throws InterruptedException {
        synchronized (this){
            while (list.size() >= maxSize){
                System.out.println("Коллекция заполнена");
                wait();
            }
            list.add(model);
            notify();
        }
    }

    public Visitor get() throws InterruptedException{
        synchronized (this){
            while(list.isEmpty()){
                System.out.println("Коллекция пуста");
                wait();
            }
            var result = list.poll();
            notify();
            return result;
        }
    }

}
