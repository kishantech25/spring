package com.nt.accessor;


public abstract class AbstractAssesor implements  IAccessor {

    private String key;
    public AbstractAssesor(String key) {
        this.key =key;
    }
    @Override
    public String getKey(){
         return key;
    }
    public abstract Object getData();
}
