package com.nt.accesser;

public class JsonAccesor extends AbstractAccessor{

    public JsonAccesor(){
        super("json");
    }

    @Override
    public Object getData() {
        //
        String json = """
{
  "name": "Kishan Kumar",
  "age": 30,
  "city": "Bangalore"
}
""";
        return null;
    }
}
