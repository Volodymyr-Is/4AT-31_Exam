package aqa_exam.db;

import aqa_exam.task6.Address;
import org.hibernate.Session;

public class UserProvider {
    public static User generateUser() {
        User user = new User();
        user.setName("testUser");
        user.setEmail("test@mail.com");
        user.setPassword("123");

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
//        Create
        session.save(user);


        session.getTransaction().commit();

        return user;
    }
}
