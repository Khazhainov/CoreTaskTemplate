package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();
        userDaoJDBC.saveUser("Petr", "Petrov", (byte) 28);
        userDaoJDBC.saveUser("Ivan", "Ivanov", (byte) 35);
        userDaoJDBC.saveUser("Mike", "Smith", (byte) 23);
        userDaoJDBC.saveUser("Alex", "Black", (byte) 21);
        List<User> users = userDaoJDBC.getAllUsers();
        for (User user : users) {
            System.out.println(user.toString());
        }
        userDaoJDBC.cleanUsersTable();
        userDaoJDBC.dropUsersTable();
    }
}
