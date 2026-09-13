package com.nt.accessor;

import java.sql.Connection;


public  class DBAccessor extends AbstractAssesor {

    public DBAccessor(String key) {
        super(key);
    }

    @Override
    public Object getData() {
        Connection conn=null;
        return conn;
    }
}