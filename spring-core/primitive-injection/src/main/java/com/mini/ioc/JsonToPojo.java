package com.mini.ioc;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToPojo {

    public List<Users> getUsers(String response){
        List<Users> users=null;
        String json =response;
      try {
          //create the Object Mapper
          ObjectMapper objectMapper = new ObjectMapper();

          //conver json String into List<User>
          users = objectMapper.readValue(
                  json, new TypeReference<List<Users>>() {
                  }
          );
      }
      catch (Exception e){
          e.printStackTrace();
      }
        return users;

    }


}
