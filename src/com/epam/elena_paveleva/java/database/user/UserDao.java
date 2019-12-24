package com.epam.elena_paveleva.java.database.user;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    boolean insertUser(User user) throws SQLException;

    List<User> selectUsersFromTask(int friends, int fromLikes, int toLikes) throws SQLException;
}

