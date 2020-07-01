package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static SessionFactory sessionFactory;

    private static final String DIALECT = "org.hibernate.dialect.MySQLDialect";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&serverTimezone=UTC";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = createSessionFactory();
        }
        return sessionFactory;
    }

    @SuppressWarnings("UnusedDeclaration")
    private static Configuration getHibernateMySqlConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);

        configuration.setProperty(Environment.DIALECT, DIALECT);
        configuration.setProperty(Environment.DRIVER, DRIVER);
        configuration.setProperty(Environment.URL, URL);
        configuration.setProperty(Environment.USER, USER_NAME);
        configuration.setProperty(Environment.PASS, PASSWORD);
        configuration.setProperty(Environment.SHOW_SQL, "true");
        configuration.setProperty(Environment.HBM2DDL_AUTO, "create");
        return configuration;
    }

    private static SessionFactory createSessionFactory() {
        Configuration configuration = getHibernateMySqlConfiguration();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    public static Connection getJDBCMySQLConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
