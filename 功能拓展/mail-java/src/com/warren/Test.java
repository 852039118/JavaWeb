package com.warren;

public class Test {
    public static void main(String[] args) {
        String s1 = "www";
        String s2 = "www";
        System.out.println(s1 == s2);
        String s3 = "www";
        String s4 = new String("www");
        System.out.println(s3 == s4);

    }
}
