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
        // TODO: To be implemented.
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public T dequeue() {
        // TODO: To be implemented.
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public T peek() {
        // TODO: To be implemented.
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int size() {
        // TODO: To be implemented.
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isEmpty() {
        // TODO: To be implemented.
        throw new UnsupportedOperationException("Not supported yet.");
    }

}