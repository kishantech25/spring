package com.example;

public class CustomeVector<E> {

    private Object[] elements;
    private int size;

    private static  final int DEFAULT_CAPACITY = 10;

    public CustomeVector(){
        elements=new Object[DEFAULT_CAPACITY];
    }

    public int size(){
        return size;
    }

    public Boolean isEmpty(){
        return size == 0;
    }

    public void add(E element){
        ensureCapacity();
        elements[size] = element;
        size++;
    }

    public E get(int index){
        checkIndex(index);
        return (E) elements[index];
    }

    public E set(int index,E element){
        checkIndex(index);

        E oldElement =(E) elements[index];
        elements[index] =element;
        return oldElement;
    }

    public E remove(int index){
        checkIndex(index);
        E removedElement =(E) elements[index];

        //shift elements to left
        for(int i=index;i<size -1; i++){
            elements[i] =elements[i+1];
        }
        elements[size -1] =null;
        size--;
        return removedElement;
    }

    private void ensureCapacity(){
        if(size == elements.length){
            int newCapacity =elements.length * 2;

            Object[] newElements = new Object[newCapacity];

            for(int i=0;i<size;i++){
                newElements[i] =elements[i];
            }
            elements=newElements;
        }
    }

    private void checkIndex(int index){
       if(index < 0 || index >=size){
           throw new IndexOutOfBoundsException(
                   "Index:"+index+", Size: "+size
           );
       }
    }
}
