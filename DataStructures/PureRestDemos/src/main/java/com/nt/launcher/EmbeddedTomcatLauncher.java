package com.nt.launcher;

import com.nt.config.MyApplication;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.glassfish.jersey.servlet.ServletContainer;

import java.io.File;

public class EmbeddedTomcatLauncher {

    public static void main(String[] args) throws Exception {
        int port = resolvePort(args);
        String contextPath = resolveContextPath();

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(port);
        tomcat.setBaseDir(createBaseDir());
        tomcat.getConnector();

        Context context = tomcat.addContext(contextPath, new File(".").getAbsolutePath());
        Tomcat.addServlet(context, "JerseyServlet", new ServletContainer(new MyApplication()))
                .setLoadOnStartup(1);
        context.addServletMappingDecoded("/api/*", "JerseyServlet");

        tomcat.start();
        System.out.println("Embedded Tomcat started at http://localhost:" + port + contextPath + "/api");
        tomcat.getServer().await();
    }

    private static int resolvePort(String[] args) {
        if (args != null && args.length > 0 && args[0] != null && !args[0].trim().isEmpty()) {
            return Integer.parseInt(args[0].trim());
        }
        return Integer.parseInt(System.getProperty("server.port", "8080"));
    }

    private static String resolveContextPath() {
        String configured = System.getProperty("server.contextPath", "");
        if (configured == null || configured.trim().isEmpty() || "/".equals(configured.trim())) {
            return "";
        }
        String value = configured.trim();
        return value.startsWith("/") ? value : "/" + value;
    }

    private static String createBaseDir() {
        File base = new File("target\\embedded-tomcat");
        if (!base.exists() && !base.mkdirs()) {
            throw new IllegalStateException("Cannot create Tomcat base directory: " + base.getAbsolutePath());
        }
        return base.getAbsolutePath();
    }
}
