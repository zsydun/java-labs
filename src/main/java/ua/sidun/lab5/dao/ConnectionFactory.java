package ua.sidun.lab5.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/** Створює підключення до бази даних за параметрами з файлу db.properties. */
public class ConnectionFactory {

    private static final String PROPERTIES_FILE = "db.properties";

    private final String url;
    private final String user;
    private final String password;

    public ConnectionFactory() {
        Properties properties = loadProperties();
        this.url = properties.getProperty("db.url");
        this.user = properties.getProperty("db.user");
        this.password = properties.getProperty("db.password");
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    private Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (input == null) {
                throw new IllegalStateException("Не знайдено файл " + PROPERTIES_FILE);
            }
            properties.load(input);
        } catch (IOException e) {
            throw new IllegalStateException("Не вдалося прочитати " + PROPERTIES_FILE, e);
        }
        return properties;
    }
}
