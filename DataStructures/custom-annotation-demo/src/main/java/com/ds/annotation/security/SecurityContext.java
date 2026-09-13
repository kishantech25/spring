package com.ds.annotation.security;

import com.ds.annotation.model.Employees;
import com.ds.annotation.model.User;

public final class SecurityContext {

    private static final ThreadLocal<Employees> CURRENT_USER = new ThreadLocal<Employees>();

    public static void  setCurrentEmployee(Employees employee) {
        CURRENT_USER.set(employee);
    }
    public static Employees getCurrentEmployee() {
        return CURRENT_USER.get();
    }
    public static void clear(){
        CURRENT_USER.remove();
    }
}
