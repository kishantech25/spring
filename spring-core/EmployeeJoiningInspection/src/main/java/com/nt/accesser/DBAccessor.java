package com.nt.accesser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBAccessor extends AbstractAccessor{
    public DBAccessor(){
       super("states");
    }
    @Override
    public Object getData() {
        Map<String,Object> db =new HashMap<>();

        //retrive the database
          List<String> states= Arrays.asList("Bihar","Karnataka","Panjab","Maharastra","Goa","AandraPradesh");
          db.put("states",states);
        return db;
    }
}
