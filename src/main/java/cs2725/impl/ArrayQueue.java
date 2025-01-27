/**
 * Copyright (c) 2025 Sami Menik, PhD. All rights reserved.
 * 
 * Unauthorized copying of this file, via any medium, is strictly prohibited.
 * This software is provided "as is," without warranty of any kind.
 */
package cs2725.impl;

import cs2725.api.Queue;

public class ArrayQueue<T> implements Queue<T> {
    
    protected ArrayList queue;

    public ArrayQueue() {
        queue = new ArrayList<T>();
    }

    @Override
    public void enqueue(T item) {
        queue.store[-1] = item;
    }

    @Override
    public T dequeue() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        Object item = queue.store[0];
        queue.deleteItemAt(0);
        return (T) item;
    }

    @Override
    public T peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) queue.getItem(0);
    }

    @Override
    public int size() {
        return queue.size;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < queue.size(); i++) {
            if (queue.getItem(i) != null) {
                return false;
            }
        }
        return true;    }

}