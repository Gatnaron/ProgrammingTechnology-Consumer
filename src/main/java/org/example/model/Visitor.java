package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
// Генерация get'еров и set'еров
@Data
// Генерация конструктора со всеми параметрами
@AllArgsConstructor
public class Visitor {
    private int id;
    private double queue;

    @Override
    public String toString(){
        return "Покупатель: " + id +  " Очередь: " + queue;
    }
}
