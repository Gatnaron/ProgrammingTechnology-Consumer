package org.example.infrastructure;

import org.example.model.Visitor;

public interface IDataQueue {
    public void add(Visitor model) throws InterruptedException;
    public Visitor get() throws InterruptedException;
}
