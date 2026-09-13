package com.i18n;

import org.springframework.cglib.core.Local;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class BoilerPlateLogic {

    public static void main(String[] args) {

        Locale locale=Locale.getDefault();
        Properties props =new Properties();
        String message ="";
        String baseLocation="message_";

        ResourceBundle resourceBundle =ResourceBundle.getBundle("message",Locale.getDefault());

        String value =resourceBundle.getString("welcomeMessage");



    }
}
