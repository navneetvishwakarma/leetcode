package com.nkv.gfg;


/**
 * Problem Statement
 * https://www.geeksforgeeks.org/reverse-an-array-without-affecting-special-characters/
 */
public class ReverseStringWithSpecialCharacters {

    public String reverse(String str) {

        if (str == null || str.length() == 0) return null;
        StringBuilder builder = new StringBuilder(str);
        int start = findNextIndex(str, 0, 0);
        int end = findNextIndex(str, str.length() - 1, 1);

        while (start < end) {
            builder.setCharAt(start, str.charAt(end));
            builder.setCharAt(end, str.charAt(start));
            start = findNextIndex(str, start+1, 0);
            end = findNextIndex(str, end-1, 1);
        }

        return builder.toString();

    }

    private boolean isSpecial(char c) {
        return !((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'));
    }

    private int findNextIndex(String s, int index, int direction) {
        while(isSpecial(s.charAt(index))) {
            index = (direction == 0) ? index + 1 : index - 1;
        }
        return index;
    }
}
