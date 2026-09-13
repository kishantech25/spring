package com.job.operators;

import java.util.Objects;

public final class Person {
    private final int age;
    private final String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;

        if(obj instanceof Person) {
            Person other = (Person) obj;
            return this.age == other.age && this.name.equals(other.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result =1;
        result =31 * result +Integer.valueOf(age).hashCode();
        result =31 * result + name.hashCode();
        return result;
    }
}
