package com.L1;

public class Compulsory {

    public static int p4(int n) {
        n = n * 3;
        n = n + Integer.parseInt("10101", 2);
        n = n + Integer.parseInt("FF", 16);
        n = n * 6;
        return n;
    }

    public static int p5(int result) {
        int digitSum = 0;
        while (result > 0) {
            digitSum = digitSum + result % 10;
            result = result / 10;
        }

        digitSum = (digitSum <10) ? digitSum : p5(digitSum);
        return digitSum;
    }

    public static void main(String[] args) {
        //p1
        System.out.print("Hello World!\n");

        //p2
        String languages[] = {"C", "C++", "C#", "Go", "JavaScript", "Perl", "PHP", "Python", "Swift", "Java"};

        //p3
        int n = (int) (Math.random() * 1_000_000);

        //p4
        n = p4(n);

        //p5
        int result = p5(n);

        //p6
        System.out.print("Willy-nilly, this semester I will learn " + languages[result]);
    }
}
