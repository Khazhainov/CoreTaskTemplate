package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.util.List;

public interface UserDao {
    String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255) NOT NULL, " +
            "last_name VARCHAR(255) NOT NULL, age INT NOT NULL)";
    String DROP_TABLE = "DROP TABLE IF EXISTS users";
    String SELECT_USERS = "SELECT * FROM users";
    String DELETE_USERS = "DELETE FROM users";

    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastName, byte age);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();
}
