package com.example;


public class CustomeArrayList<E> {

    private Object[] elements;
    private int size;

    private static final int DEFAULT_CAPACITY=10;

    public CustomeArrayList(){
        elements =new Object[DEFAULT_CAPACITY];
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size ==0;
    }

    public void add(E element){
        ensureCapacity();

        elements[size] =element;
        size++;
    }

    public void add(int index,E element){
        checkPositionIndex(index);
        ensureCapacity();

        //shift elememnts to the right

        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] =element;
        size++;
    }

    @SuppressWarnings("unchecked")
    public E get(int index){
        checkElementIndex(index);
        return (E) elements[index];
    }

    @SuppressWarnings("unchecked")
    public E set(int index,E element){
        checkElementIndex(index);

        E oldElement = (E) elements[index];

        elements[index] =element;

        return oldElement;
    }
    @SuppressWarnings("unchecked")
    public E remove(int index){
        checkElementIndex(index);

        E removedElement = (E) elements[index];

        //shift element to the left
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        //Remove the duplicate reference
        elements[size - 1] =null;

        size--;
        shrinkIfNeeded();
        return removedElement;
    }

    public int capacity(){
        return elements.length;
    }

    public void trimToSize(){
        int newCapacity = Math.max(size, DEFAULT_CAPACITY);
        if(newCapacity < elements.length){
            elements = java.util.Arrays.copyOf(elements, newCapacity);
        }
    }

    // Shrink only when 1/4 full to avoid add/remove thrashing; never below default
    private void shrinkIfNeeded(){
        int capacity = elements.length;
        if(capacity > DEFAULT_CAPACITY && size <= capacity / 4){
            int newCapacity = Math.max(DEFAULT_CAPACITY, capacity / 2);
            elements = java.util.Arrays.copyOf(elements, newCapacity);
        }
    }

    public void print(Object elemenet){
        System.out.println(elemenet);
    }

    private void ensureCapacity() {
        if (size < elements.length) {
            return;
        }
        int oldCapacity = elements.length;
        //Grow by 50%, at least by 1
        int newCapacity = Math.max(oldCapacity + (oldCapacity / 2), oldCapacity + 1);

        elements = java.util.Arrays.copyOf(elements, newCapacity);
    }

  private void checkElementIndex(int index){
        if(index < 0 || index >=size){
            throw new IndexOutOfBoundsException(
                    "Index: "+index+" ,size: "+size
            );
        }
  }
  private void checkPositionIndex(int index){
      if(index < 0 || index > size){
          throw new IndexOutOfBoundsException(
                  "Index: "+index+ " , Size: "+size

        );
      }
  }

}