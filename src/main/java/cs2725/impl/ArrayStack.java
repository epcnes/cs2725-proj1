/**
 * Copyright (c) 2025 Sami Menik, PhD. All rights reserved.
 * 
 * Unauthorized copying of this file, via any medium, is strictly prohibited.
 * This software is provided "as is," without warranty of any kind.
 */
package cs2725.impl;

import cs2725.api.Stack;

/**
 * An implementation of the Stack interface using an ArrayList.
 */
public class ArrayStack<T> implements Stack<T> {

    protected ArrayList stack;

    public ArrayStack() {
        stack = new ArrayList<T>();
    }

    @Override
    public void push(T item) {
        stack.insertItem(item);
        stack.size++;
    }

    @Override
    public T pop() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        Object temp = stack.getItem(0);
        stack.deleteItemAt(0);
        return (T) temp;
    }

    @Override
    public T peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) stack.getItem(0);
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < stack.size(); i++) {
            if (stack.getItem(i) != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return stack.size;    
    }

}