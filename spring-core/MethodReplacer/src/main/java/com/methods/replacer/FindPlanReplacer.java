package com.methods.replacer;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class FindPlanReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("findPlan")){
            int ageGroup=0;
            int copay=0;
            String maritalStatus=null;
            ageGroup=(Integer)args[0];
            copay=(Integer)args[1];
            maritalStatus=(String)args[2];
            return new String[]{"Abhaya Bima Gold","Abhya Surakhya Parivar","Abhaya Jivan"};
        }
        if(method.getName().equals("getMaritalStatus")){
            System.out.println("Married");
        }
        return null;
    }
}
