package ru.major.crud;

import java.io.File;

public class PathFile {

     public static  File findFile(String fileName) {

        ClassLoader classLoader = PathFile.class.getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());

    }
}
