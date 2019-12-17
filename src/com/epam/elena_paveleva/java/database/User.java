package com.epam.elena_paveleva.java.database;

import java.time.LocalDate;
import java.util.List;

public class User {
    private int id;

    private String name;

    private String surname;
    private LocalDate birthday;
    private List<Friendship> friendships = null;

    public void printInfo () {
        System.out.println(name + " " + surname);
    }

    public void createFriendship (User user) {
        if (!friendshipExists(user)) {

        }
    }

    private boolean friendshipExists (User user) {
        return true;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
