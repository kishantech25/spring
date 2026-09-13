package com.records.RecordsJava17DemoOther.loader;


public class CustomClassLoaderA extends ClassLoader {
//
//    private final Path baseDirectory;
//
//    public CustomClassLoaderA(Path baseDirectory) {
//        super(null);
//        this.baseDirectory = baseDirectory;
//    }
//
//    @Override
//    protected Class<?> findClass(String className)
//            throws ClassNotFoundException {
//
//        System.out.println(
//                "\nClassLoader A loading: " + className
//        );
//
//        // Convert:
//        //
//        // com.records.RecordsJava17DemoOther.util.User
//        //
//        // into:
//        //
//        // com/records/RecordsJava17DemoOther/util/User.class
//
//        String relativePath =
//                className.replace('.', '/') + ".class";
//
//        Path classPath =
//                baseDirectory.resolve(relativePath);
//
//        System.out.println(
//                "Looking for: " +
//                        classPath.toAbsolutePath()
//        );
//
//        try {
//
//            byte[] classBytes =
//                    Files.readAllBytes(classPath);
//
//            System.out.println(
//                    "Class bytes loaded: " +
//                            classBytes.length
//            );
//
//            return defineClass(
//                    className,
//                    classBytes,
//                    0,
//                    classBytes.length
//            );
//
//        } catch (IOException e) {
//
//            throw new ClassNotFoundException(
//                    "Could not load " + className,
//                    e
//            );
//        }
//    }
}