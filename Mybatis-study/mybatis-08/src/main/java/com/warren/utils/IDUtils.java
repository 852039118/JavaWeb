package com.warren.utils;

import java.util.UUID;

public class IDUtils {
    public static String getId(){
        String id = UUID.randomUUID().toString().replace("-","");
        return id;
    }

    public static void main(String[] args) {
        getId();
        getId();
        getId();
    }
}
