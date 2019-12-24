package com.epam.elena_paveleva.java.database.user;

import com.epam.elena_paveleva.java.database.client.MainDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private ResultSet rs = null;

    @Override
    public boolean insertUser(User user) throws SQLException {
        if (user.getName() == null || user.getSurname() == null || user.getBirthday() == null) {
            return false;
        }
        PreparedStatement st = MainDB.conn.prepareStatement("INSERT INTO users " +
                "(name, surname, birthdate) " +
                "VALUES (?, ?, ?)");
        st.setString(1, user.getName());
        st.setString(2, user.getSurname());
        st.setString(3, user.getBirthday().toString());
        return st.execute();
    }

    @Override
    public List<User> selectUsersFromTask(int friends, int fromLikes, int toLikes) throws SQLException {
        List<User> users = new ArrayList<>();
        PreparedStatement st = MainDB.conn.prepareStatement("select r.userid, u.name, u.surname, avg(LCounter) as average from\n" +
                "(select p.id, p.userid, count(l.id) as LCounter from posts as p " +
                "left join likes as l " +
                "on p.id = l.postid " +
                "group by p.id) as r " +
                "            left join users as u " +
                "            on r.userid = u.id " +
                "where u.id in (select u.id from users u " +
                "left join friendships f on u.id = f.userid1 " +
                "group by u.id " +
                "having (COUNT(f.userid1) > ?) " +
                ") " +
                "group by r.userid " +
                "         having((avg(LCounter) >= ?) and (avg(LCounter) < ?))");
        st.setInt(1, friends);
        st.setInt(2, fromLikes);
        st.setInt(3, toLikes);
        rs = st.executeQuery();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("userid"));
            user.setName(rs.getString("name"));
            user.setSurname(rs.getString("surname"));
            users.add(user);
        }
        return users;
    }
}
