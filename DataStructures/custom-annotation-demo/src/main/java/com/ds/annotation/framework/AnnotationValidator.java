package com.ds.annotation.framework;

import com.ds.annotation.annotation.Authorized;
import com.ds.annotation.exception.UserNotAllowedException;
import com.ds.annotation.model.User;

import java.lang.reflect.Field;

public class AnnotationValidator {

    public static void validate(Class<?> clazz) {
        // Implementation for validating annotations on class fields
       System.out.println("Validating " + clazz.getName());

        Field[] fields = clazz.getDeclaredFields();

        for(Field field : fields){
            if(field.getType().equals(User.class)){
                Authorized annotation=field.getAnnotation(Authorized.class);

                if(annotation==null){
                    throw new UserNotAllowedException("Field"+field.getName()+" in class"+clazz.getName()+" must have @Authorized");


                }
                System.out.println(
                        "✓ @Authorized found on field: "
                                + field.getName()
                );
            }


        }
    }
}
