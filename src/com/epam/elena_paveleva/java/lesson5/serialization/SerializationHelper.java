package com.epam.elena_paveleva.java.lesson5.serialization;


import com.epam.elena_paveleva.java.lesson1.task2.exceptions.SerializationException;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializationHelper {

    public static Path serialize(Serializable obj, String filename) throws FileAlreadyExistsException, SerializationException {
        Path path = Paths.get(filename);
        if (Files.exists(path)) {
            throw new FileAlreadyExistsException("target file already exists");
        }
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))) {
            objectOutputStream.writeObject(obj);
            System.out.println("Object " + obj.getClass().getName() + " saved to " + filename);
            return (new File(filename)).toPath();
        } catch (IOException e) {
            throw new SerializationException("Exception occurred during serialization", e);
        }
    }

    public static <T extends Serializable> T  deserialize(Path path) throws SerializationException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(path.toFile())))) {
            return  (T) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new SerializationException("Exception occurred during deserialization", e);
        }
    }
}
