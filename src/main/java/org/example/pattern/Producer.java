package org.example.pattern;

import org.example.model.Visitor;

import java.util.List;
import java.util.Random;

public class Producer implements Runnable {
    private final DataQueue dataQueue;
    private int counter = 0;
    private final Random random;

    public Producer(DataQueue dataQueue) {this.dataQueue = dataQueue; random = new Random();}
    @Override
    public void run() {
        produce();
    }
    // Реализация функционала добавление кораблей
    private void produce(){
        try{
            while(true){
                counter++;
                dataQueue.add(generateShip());
                System.out.println("Посетитель подошел к кассе: " + counter);
                Thread.sleep(20);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //Вспомогательный метод для генерации кораблей
    private Visitor generateShip() {
        return new Visitor(counter, random.nextInt(4000,10000));
    }
}
