package com.blogspot.rkacode.students.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ResourceLoader {
    private final Class<?> cls;

    public ResourceLoader(Class<?> cls) {
        this.cls = cls;
    }

    public String readFile(String file) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(cls.getResourceAsStream(file)))) {
            StringBuilder builder = new StringBuilder();
            String line;
            while ( (line = reader.readLine()) != null) {
                builder.append(line);
            }
            return builder.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
