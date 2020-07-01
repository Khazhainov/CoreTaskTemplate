package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDaoHibernateImpl UserDaoHibernateImpl = new UserDaoHibernateImpl();
        UserDaoHibernateImpl.createUsersTable();
        UserDaoHibernateImpl.saveUser("Petr", "Petrov", (byte) 28);
        UserDaoHibernateImpl.saveUser("Ivan", "Ivanov", (byte) 35);
        UserDaoHibernateImpl.saveUser("Mike", "Smith", (byte) 23);
        UserDaoHibernateImpl.saveUser("Alex", "Black", (byte) 21);
        List<User> users = UserDaoHibernateImpl.getAllUsers();
        for (User user : users) {
            System.out.println(user.toString());
        }
        UserDaoHibernateImpl.cleanUsersTable();
        UserDaoHibernateImpl.dropUsersTable();
    }
}
