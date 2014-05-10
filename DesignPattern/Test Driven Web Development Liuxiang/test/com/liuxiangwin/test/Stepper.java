package com.liuxiangwin.test;

import java.util.Arrays;
import java.util.Comparator;

public class Stepper {
    public static void main(String[] args) {
        String[] words = { "Good", "Bad", "Ugly" };
        Comparator<String> best = new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s2.charAt(1) - s1.charAt(1);
            }
        };
        Arrays.sort(words, best);
        System.out.println(words[0]);
    }
}


