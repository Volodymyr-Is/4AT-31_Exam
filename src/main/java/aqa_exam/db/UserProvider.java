package aqa_exam.db;

import aqa_exam.task6.Address;
import org.hibernate.Session;

import java.util.UUID;

public class UserProvider {
    public static User generateUser() {
        User user = new User();
        user.setName("admin1");
        user.setEmail("john.test1.mail@gmail.com");
        user.setPassword("1qaz!QAZ");


//        User user = new User();
//        user.setName("john" + UUID.randomUUID());
//        user.setEmail(UUID.randomUUID() + "@gmail.com");
//        user.setPassword("1qaz!QAZ");

//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
////        Create
//        session.save(user);
//
//
//        session.getTransaction().commit();

        return user;
    }
}
