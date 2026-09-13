package com.backend.revise;

public class CustomeHashMap {

    private int[] array;

    private int size;

    public CustomeHashMap(){
        array = new int[10];
        size = 0;

    }
    public void put(int key,int value){
        array[size++] = key;
        array[size++] = value;

    }

//    Basic Hashmap Operations:
//    Question: Explain how you would implement a basic hashmap from scratch using an array and handle collisions using chaining. Discuss the average and worst-case time and space complexities.
//    Input: Key-value pairs to be inserted, searched, or deleted.
//    Output: Values corresponding to keys, or status of operations.
//    Time Complexity: Average case O(1), worst-case O(n) if all keys hash to the same bucket and a collision occurs.
//    Space Complexity: O(n), where n is the number of key-value pairs stored.

}
