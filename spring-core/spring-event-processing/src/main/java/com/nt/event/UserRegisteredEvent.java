package com.nt.event;

public class UserRegisteredEvent {


    //user details will stored Into database

    private final String userName;

    public UserRegisteredEvent(String username){
        this.userName =username;
    }
    public String getUserName(){
        return userName;
    }
}
