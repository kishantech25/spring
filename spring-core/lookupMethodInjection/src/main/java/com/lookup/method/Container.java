package com.lookup.method;

public abstract class Container {

    private RequestHandler requestHandler;

    public abstract RequestHandler getHandler();

    public void getData(String data){
        requestHandler =getHandler();
        requestHandler.setData(data);
        System.out.println(requestHandler.request(data));
    }
}
