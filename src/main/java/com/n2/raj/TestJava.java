package com.n2.raj;

public class TestJava {
    public static String goldmanSachsFunction(String str) {
        int n = str.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (i < n - 1 &&
                    str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            stringBuilder.append(str.charAt(i));
            stringBuilder.append(count);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String str = "abcwwaaadexxywww";
        System.out.println(goldmanSachsFunction(str));
        System.out.println(goldmanSachsFunction("aaa"));
    }
}
