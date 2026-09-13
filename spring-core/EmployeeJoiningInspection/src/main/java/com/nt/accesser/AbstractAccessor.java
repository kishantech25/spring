package com.nt.accesser;

public abstract class AbstractAccessor implements IAccessor{
    private String key;
    public AbstractAccessor(){
        //no-code
    }
    public AbstractAccessor(String key){
        this.key=key;
    }
    @Override
    public String getKey() {
        return key;
    }

    @Override
    public abstract Object getData();
}
