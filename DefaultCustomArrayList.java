package com.edu;

import java.util.ArrayList;
import java.util.Iterator;

public class DefaultCustomArrayList<E> implements CustomArrayList<E>, Iterable<E>  {
    Object[] numbers;
    int firstEmpty;


    public DefaultCustomArrayList() {
        numbers = new Object[10];
        firstEmpty = 0;
    }

    @Override
    public boolean add(E element) {
        numbers[firstEmpty] = element;
        firstEmpty++;
        return true;
    }

    @Override
    public boolean remove(E element) {

        for (int i = 0; i < firstEmpty; i++){
            if (numbers[i] == element) {
                for (int j = i; j < firstEmpty; j++){
                    numbers[j] = numbers[j+1];

                }
                firstEmpty--;
                return true;
            }
        }
        return false;
    }


    @Override
    public E get(int index) {
        if (index < 0 || index >= firstEmpty) {
            throw new IndexOutOfBoundsException("Index is " + index + ", but size is" + firstEmpty);
        }


        return (E) numbers[index];
    }

    @Override
    public int size() {
        for (int i = 0; i <= firstEmpty; i++) {
            if (i == firstEmpty) {
                return (i);
            }
        }
        return 0;
    }

    @Override
    public boolean isEmpty() {
        if (firstEmpty == 0) {
            return true;
        }

        return false;
    }

    @Override
    public void clear() {
            for (int i = firstEmpty; i > 0; i--){
                numbers[i-1] = numbers[firstEmpty];
                firstEmpty = i-1;

            }
        }

    @Override
    public boolean contains(E element) {
        for (int i = 0; i < firstEmpty; i++) {
            if (numbers[i] == element) {
                return true;

            }
        }
        return false;
    }





    @Override
    public Iterator<E> iterator() {
        return new CustomIterator();
        }

        private class CustomIterator implements Iterator<E> {

            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < firstEmpty;
            }

            @Override
            public E next() {
                return (E) numbers[cursor++];
            }
        }
    }

