package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    private Session session;

    public UserDaoHibernateImpl() {

    }

    public UserDaoHibernateImpl(Session session) {
        this.session = session;
    }

    @Override
    public void createUsersTable() {
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery(CREATE_TABLE).executeUpdate();
        transaction.commit();
    }

    @Override
    public void dropUsersTable() {
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery(DROP_TABLE).executeUpdate();
        transaction.commit();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = session.beginTransaction();
        session.save(new User(name, lastName, age));
        transaction.commit();
        System.out.printf("User с именем – %s добавлен в базу данных%n", name);
    }

    @Override
    public void removeUserById(long id) {
        User user = (User)session.load(User.class, id);
        session.delete(user);
    }

    @Override
    public List<User> getAllUsers() {
        Transaction transaction = session.beginTransaction();
        List<User> users = session.createQuery("FROM User").list();
        transaction.commit();
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery(DELETE_USERS).executeUpdate();
        transaction.commit();
    }
}
