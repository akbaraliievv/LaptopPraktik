package configuration;

import exceptions.LaptopNotFoundException;
import jakarta.persistence.EntityManagerFactory;
import model.Laptops;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class DatabaseConnection {
    public static EntityManagerFactory createEntityManagerFactory() {
        try {
            Properties properties = new Properties();
            properties.put(Environment.DRIVER, "org.postgresql.Driver");
            properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
            properties.put(Environment.USER, "postgres");
            properties.put(Environment.PASS, "1234");

            properties.put(Environment.HBM2DDL_AUTO, "update");
            properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
            properties.put(Environment.SHOW_SQL, "true");
            properties.put(Environment.FORMAT_SQL,"true");

            Configuration configuration = new Configuration();
            configuration.addProperties(properties);
            configuration.addAnnotatedClass(Laptops.class);
            System.out.println("Successfully connected...");
            return configuration.buildSessionFactory();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }







}
