package com.nkv.util;

public class Printer {

    public static void print(int[] arr) {
        System.out.print("[");
        for(int i: arr) {
            System.out.print(i + ", ");
        }
    }
}
