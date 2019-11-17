package com.epam.elena_paveleva.java.database;

import java.time.LocalDate;

public class User {
    private int id;
    private String name;
    private String surname;
    private LocalDate birthday;

    public User(int id, String name, String surname, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public void printInfo () {
        System.out.println(name + " " + surname);
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
