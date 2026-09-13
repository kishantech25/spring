package com.job.classloaders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CustomClassLoaderB extends ClassLoader {

    private final Path classPath;

    public CustomClassLoaderB(Path classPath) {
        super(null); // no parent
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name)
            throws ClassNotFoundException {

        if (!name.equals("com.job.util.User")) {
            throw new ClassNotFoundException(name);
        }

        try {
            byte[] classBytes = Files.readAllBytes(classPath);

            return defineClass(
                    name,
                    classBytes,
                    0,
                    classBytes.length
            );

        } catch (IOException e) {
            throw new ClassNotFoundException(name, e);
        }
    }
}