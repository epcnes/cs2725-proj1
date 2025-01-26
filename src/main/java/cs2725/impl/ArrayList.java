/**
 * Copyright (c) 2025 Sami Menik, PhD. All rights reserved.
 * 
 * Unauthorized copying of this file, via any medium, is strictly prohibited.
 * This software is provided "as is," without warranty of any kind.
 */
package cs2725.impl;

import java.util.Arrays;
import java.util.Objects;

import cs2725.api.List;
import cs2725.viz.Graph;

/**
 * Implementation of an unordered array backed list.
 */
public class ArrayList<T> implements List<T> {

    protected int size;
    protected T[] store;

    protected static final int INIT_SIZE = 4;
    
    public ArrayList() {
        init(INIT_SIZE);
    }

    @SuppressWarnings("unchecked")
    private void init(int initSize) {
        size = 0;
        store = (T[]) new Object[initSize];
    }

    @Override
    public void insertItem(T item) {
        if (size == store.length) {
            resize(store.length * 2);
        }

        store[size++] = item;
    }

    @Override
    public void deleteItemAt(int index) {
        checkIndex(index);
        for (int i = index + 1; i < size; ++i) {
            Graph.i().setRef("i", store, i); // For visualization.
            store[i - 1] = store[i];
        }
        Graph.i().clearRef("i"); // For visualization.
        store[--size] = null;
        if (store.length >= INIT_SIZE * 2 && size == store.length / 4) {
            resize(store.length / 2);
        }
    }

    @Override
    public void deleteItem(T item) {
        int index = searchItem(item);
        if (index != -1) {
            deleteItemAt(index);
        }
    }

    @Override
    public T getItem(int index) {
        checkIndex(index);
        return store[index];
    }

    @Override
    public void setItem(int index, T item) {
        checkIndex(index);
        store[index] = item;
    }

    @Override
    public void clear() {
        init(INIT_SIZE);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int searchItem(T item) {
        for (int i = 0; i < size; i++) {
            Graph.i().setRef("i", store, i); // For visualization.
            if (Objects.equals(store[i], item)) {
                Graph.i().clearRef("i"); // For visualization.
                return i;
            }
        }
        Graph.i().clearRef("i"); // For visualization.
        return -1; // Item not found.
    }

    protected void resize(int capacity) {
        store = Arrays.<T>copyOf(store, capacity);
    }

    protected void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

}
