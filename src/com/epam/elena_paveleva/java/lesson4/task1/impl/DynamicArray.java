package com.epam.elena_paveleva.java.lesson4.task1.impl;

public class DynamicArray<T> {
    private Object[] arr;

    public DynamicArray(int size) {
        if (size > 0) {
            arr = new Object[size];
        } else {
            throw new IllegalArgumentException("array size must be a positive value");
        }
    }

    public void add(T element) {
        if (arr.length <= size()) {
            extendArray();
        }
        arr[size()] = element;
    }

    public T get(int index) {
        if (index < size()) {
            return (T) arr[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < arr.length && arr[i] != null) {
            sb.append(i + ":" + arr[i].toString() + '\n');
            i++;
        }

        return sb.toString();
    }

    public void remove(int index) {
        if (index < size()) {
            int i = 0;
            while (index < size() - 1 && arr[index] != null) {
                arr[index] = arr[index + 1];
                index++;
            }
            arr[size() - 1] = null;
            if (arr.length / size() == 2) {
                compressArray();
            }
        } else {
            throw new IndexOutOfBoundsException("no element with such index");
        }
    }

    public int size() {
        int size = 0;
        while (size <= arr.length - 1 && arr[size] != null) {
            size++;
        }
        return size;
    }

    private void extendArray() {
        Object[] newArr = new Object[size() * 2];
        int i = 0;
        while (i < arr.length && arr[i] != null) {
            newArr[i] = arr[i];
            i++;
        }
        arr = newArr;
    }

    private void compressArray() {
        Object[] newArr = new Object[arr.length / 2];
        int i = 0;
        while (i < newArr.length) {
            newArr[i] = arr[i];
            i++;
        }
        arr = newArr;
    }
}
