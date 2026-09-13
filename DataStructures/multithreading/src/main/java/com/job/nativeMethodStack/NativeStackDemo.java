package com.job.nativeMethodStack;

/*
A Java developer cannot directly create or inspect a
"native method stack frame" using ordinary Java code.
 Native frames are created when JVM execution enters native
  code, typically through JNI or JVM-internal native methods.
*/
public class NativeStackDemo {

    static {
        System.loadLibrary("nativecalc");
    }

    public static void main(String[] args) {

        System.out.println("Java main() started");

        int result = calculate(10, 20);

        System.out.println("Result = " + result);

        System.out.println("Java main() finished");
    }

    // Native method
    private static native int calculate(int a, int b);
}