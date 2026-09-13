package com.ds.annotation.framework;

import com.ds.annotation.annotation.Authorized;
import com.ds.annotation.exception.AccessDeniedException;
import com.ds.annotation.model.Employee;
import com.ds.annotation.model.Employees;
import com.ds.annotation.model.User;
import com.ds.annotation.security.SecurityContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AuthorizationProxy implements InvocationHandler {

    private final Object target;
    public AuthorizationProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("Proxy Intercepted: "+method.getName());

        Method targetMethod = target.getClass().getMethod(method.getName(), method.getParameterTypes());

        Authorized authorizedAnnotation = targetMethod.getAnnotation(Authorized.class);
        if (authorizedAnnotation != null) {

            authorize(args);
        }
        return targetMethod.invoke(target, args);
    }

    private void authorize(Object[] args) {
        // Implement your authorization logic here
       Employees currentEmployee = SecurityContext.getCurrentEmployee();

       if(currentEmployee == null){
           throw new AccessDeniedException("No Authorized Employee");
       }

        Employees employee = (Employees) args[0];

       if(!currentEmployee.id().equals(employee.id())){
           throw new AccessDeniedException("User:: "+currentEmployee.id()+" is not available in database");
        }
    }
}
