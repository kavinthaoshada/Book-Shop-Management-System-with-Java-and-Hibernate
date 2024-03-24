package com.calm.webdb;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class Main {
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        Context context = tomcat.addWebapp("/bookshop",new File("./src/main/Webapp").getAbsolutePath());
        context.setAllowCasualMultipartParsing(true); // To enable multipart request

//        tomcat.addServlet(context, "a", new ServletContainer(new AppConfig()));
//        context.addServletMappingDecoded("/*", "a");

        tomcat.start();
    }
}
