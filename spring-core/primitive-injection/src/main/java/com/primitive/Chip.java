package com.primitive;
public class Chip
{
    private int id;
    private String type;

    //setters
    //toString()
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Chip{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }

    public void setType(String type) {
        this.type = type;
    }
}