package model;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import orm.Product;
import orm.User;

public class HibernateUtil {
    
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static ServiceRegistry serviceRegistry;
    private static Configuration configuration;
    
    /* All  SQL, DML entities must be registered */
    public static void registerBeans() {
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(User.class);
    }

        private static SessionFactory buildSessionFactory() {
            try {
                configuration = new Configuration();
                configuration.configure();
                registerBeans();

            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).build();

            return configuration.buildSessionFactory(serviceRegistry);
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
 
}