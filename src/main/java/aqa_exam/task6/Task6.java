package aqa_exam.task6;

import org.hibernate.Session;

public class Task6 {
    public static void main(String[] args) {
//        Install MySQL server (or any SQL like db)
//        Make at least two tables (entities from the previous task)
//        Make models for those entities (from Task_5)
//        Setup Hibernate for those entities
//        Check basic CRUD (create, read, update, and delete the BD records using Hibernate)
//        Generate a few rows into all tables


        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
//        Create
//        Address address = new Address(2, "city2", "state2");
//        session.save(address);
//        User user = new User(2, "user2", 22, false, address);
//        session.save(user);

//        Read
        User dbUser = session.get(User.class, 2);
        Address dbAddress = session.get(Address.class, 2);
        System.out.println("User: " + dbUser.getName());
        System.out.println("Address: " + dbAddress.getCity() + " | " + dbAddress.getState());

//        Update
//        dbUser.setName("UpdatedUser1");
//        session.update(dbUser);
//
//        dbAddress.setCity("UpdatedCity2");
//        session.update(dbAddress);
//
//        System.out.println("User: " + dbUser.getName());
//        System.out.println("Address: " + dbAddress.getCity() + " | " + dbAddress.getState());

//        Delete
//        User userToDelete = session.get(User.class, 1);
//        session.delete(userToDelete);

        session.getTransaction().commit();
    }
}
