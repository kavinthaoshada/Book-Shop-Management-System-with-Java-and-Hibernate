package com.calm.webdb.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EmailConfig {
    private static final String CONFIG_FILE = "mail.properties";

    private static Properties properties = new Properties();

    static {
        try (InputStream input = EmailConfig.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                System.out.println("Sorry, unable to find " + CONFIG_FILE);
//                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getSmtpHost() {
        return properties.getProperty("mail.smtp.host");
    }

    public static int getSmtpPort() {
        return Integer.parseInt(properties.getProperty("mail.smtp.port"));
    }

    public static String getUsername() {
        return properties.getProperty("mail.smtp.username");
    }

    public static String getPassword() {
        return properties.getProperty("mail.smtp.password");
    }
}
