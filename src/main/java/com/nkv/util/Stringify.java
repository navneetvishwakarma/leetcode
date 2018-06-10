package com.nkv.util;

import java.util.List;

public class Stringify {

    /**
     * String representation of an Array
     * @param arr
     * @return String
     */
    public static String toString(int[] arr) {
        StringBuilder builder = new StringBuilder();
        if (arr.length > 0) {
            builder.append("[");
            for (int i = 0; i < arr.length; i++) {
                builder.append(arr[i]);
                builder.append((i == arr.length-1) ? "]" : ", ");
            }
        }
        return builder.toString();
    }

    /**
     * String representation of a List
     * @param list
     * @return String
     */
    public static String toString(List<Integer> list) {
        StringBuilder builder = new StringBuilder();
        if (list.size() > 0) {
            builder.append("[");
            for (int i = 0; i < list.size(); i++) {
                builder.append(list.get(i));
                builder.append((i == list.size()-1) ? "]" : ", ");
            }
        }
        return builder.toString();
    }
}
