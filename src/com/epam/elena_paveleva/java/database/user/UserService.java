package com.epam.elena_paveleva.java.database.user;

import com.epam.elena_paveleva.java.database.DataGenerationConstants;

import java.time.LocalDate;
import java.util.Random;

public class UserService {
    private Random generator = new Random();

    public User generateUser () {
        User user = new User ();
        user.setName(generateName());
        user.setSurname(generateSurname());

        return user;
    }

    private String generateName () {
        return DataGenerationConstants.names[generator.nextInt(DataGenerationConstants.names.length)];
    }

    private String generateSurname () {
        return DataGenerationConstants.surnames[generator.nextInt(DataGenerationConstants.surnames.length)];
    }

}
