package com.user.auth.model;

//immtable Object

import java.util.List;

public final class Employe {

 private final int id;
 private final String name;
 private final String email;
 private final List<String> skills;

    public Employe(int id, String name, String email, List<String> skills) {
      this.id=id;
      this.name=name;
      this.email=email;
      this.skills=List.of("Java","SpringBoot","Docker","Kubernaties");
   }

}
