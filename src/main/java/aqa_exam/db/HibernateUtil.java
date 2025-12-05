package aqa_exam.db;

import aqa_exam.ConfigReader;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            String dbHost = ConfigReader.getSecretProp("db.host");

            String dbUser = ConfigReader.getSecretProp("db.user");

            String dbPass = ConfigReader.getSecretProp("db.password");

            if (dbHost == null || dbUser == null || dbPass == null) {
                throw new RuntimeException("Не вдалося отримати дані БД з secret_conf.prop");
            }

            String dbUrl = "jdbc:postgresql://" + dbHost + ":5432/postgres";

            configuration.setProperty("hibernate.connection.url", dbUrl);
            configuration.setProperty("hibernate.connection.username", dbUser);
            configuration.setProperty("hibernate.connection.password", dbPass);
            configuration.setProperty("hibernate.connection.ssl", "true");

            configuration.setProperty("hibernate.connection.sslfactory", "org.postgresql.ssl.NonValidatingFactory");

            configuration.setProperty("hibernate.current_session_context_class", "thread");
            configuration.setProperty("hibernate.globally_quoted_identifiers", "true");

            sessionFactory = configuration.buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}



//package aqa_exam.db;
//
//import aqa_exam.ConfigReader;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.Metadata;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//
//public class HibernateUtil {
//    private static final SessionFactory sessionFactory = buildSessionFactory();
//
//    private static SessionFactory buildSessionFactory() {
//        try {
//            Configuration configuration = new Configuration().configure();
//
//            configuration.setProperty("hibernate.connection.url", ConfigReader.getProp("supabase.url"));
//            configuration.setProperty("hibernate.connection.username", ConfigReader.getProp("supabase.user"));
//            configuration.setProperty("hibernate.connection.password", ConfigReader.getProp("supabase.password"));
//
//            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                    .applySettings(configuration.getProperties())
//                    .build();
//
//            Metadata metadata = new MetadataSources(serviceRegistry)
//                    .getMetadataBuilder()
//                    .build();
//
//            return metadata.getSessionFactoryBuilder().build();
//
//        } catch (Throwable ex) {
//            System.err.println("Initial SessionFactory creation failed: " + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//
//    public static void shutdown() {
//        if (sessionFactory != null) {
//            sessionFactory.close();
//        }
//    }
//}


//package aqa_exam.db;
//
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//public class HibernateUtil {
//    private static SessionFactory sessionFactory;
//    static {
//        try {
//            sessionFactory = new Configuration().configure().buildSessionFactory();
//        } catch (Throwable ex) {
//            System.err.println("Initial SessionFactory creation failed." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//    public static void shutdown() {
//        getSessionFactory().close();
//    }
//}