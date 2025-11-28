package aqa_exam.db;

import aqa_exam.ConfigReader;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // 1. Створюємо Configuration і завантажуємо hibernate.cfg.xml
            Configuration configuration = new Configuration().configure();

            // 2. Перезаписуємо чутливі властивості з conf.prop
            configuration.setProperty("hibernate.connection.url", ConfigReader.getProp("supabase.url"));
            configuration.setProperty("hibernate.connection.username", ConfigReader.getProp("supabase.user"));
            configuration.setProperty("hibernate.connection.password", ConfigReader.getProp("supabase.password"));

            // (Опціонально) Якщо в cfg.xml немає <mapping>, можна додати тут:
            // configuration.addAnnotatedClass(User.class);

            // 3. Будуємо SessionFactory
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            Metadata metadata = new MetadataSources(serviceRegistry)
                    .getMetadataBuilder()
                    .build();

            return metadata.getSessionFactoryBuilder().build();

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}


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
//
