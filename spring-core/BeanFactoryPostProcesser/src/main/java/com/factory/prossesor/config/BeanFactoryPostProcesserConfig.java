package com.factory.prossesor.config;

import com.factory.prossesor.conn.ConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class BeanFactoryPostProcesserConfig {


    @Bean
    public ConnectionManager getConnectionManager(){
      ConnectionManager manager =new ConnectionManager();
       Properties props =getProperties();
        manager.setDriverClassName(props.get("db.driverClassName"));
        manager.setUrl(props.get("db.url"));
        manager.setUsername(props.get(props.get("db.username"));
        manager.setPassword(props.get("db.password"));
    }

    @Bean
    public Properties getProperties(){
        Properties props =new Properties();
        try {
            props.load(getClass().getClassLoader().getResourceAsStream("db.properties"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return props;
      }
}
