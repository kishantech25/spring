package com.lookup.method;

public class RequestHandler {
    private String data;

    public void setData(String data) {
        this.data = data;
    }

    public String request(String data){
        retrun data+" == "+this.hashCode();
    }
}
