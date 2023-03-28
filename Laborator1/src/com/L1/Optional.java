package com.L1;

import java.math.BigInteger;


public class Optional {

    private static boolean inputCheck(String[] input){
        if(input.length != 1){
            System.out.print("Wrong Number Of Parameters\n");
            return false;
        }

        String regexCheck = "[0-9][0-9]*";
        if(input[0].matches(regexCheck) == false){
            System.out.print("Input Is Not A Number\n");
            return false;
        }

        if(Integer.parseInt(input[0]) % 2 == 0){
            System.out.print("Input Is Not An Odd Number\n");
            return false;
        }

        return  true;
    }

    private static void printMatrix(int[][] matrix, int n){
        if(n > 15){
            BigInteger constMagic = BigInteger.valueOf(n);
            constMagic = (constMagic.multiply((constMagic.multiply(constMagic)).add(BigInteger.ONE))).divide(BigInteger.ONE.add(BigInteger.ONE));

            System.out.printf("Magic Constant : %d\n", constMagic);
            System.out.printf("Running Time : %f\n", (System.nanoTime() - startTime) / 1_000_000_000.0);
            return;
        }

        int max = 0;
        for(int indexI = 0; indexI < n; indexI ++) {
            for (int indexJ = 0; indexJ < n; indexJ++) {
                int size = (int) (Math.log10(matrix[indexI][indexJ]) + 1);

                if(size > max){
                    max = size;
                }
            }
        }

        for (int indexJ = 0; indexJ < n * (max + 7); indexJ++) {
            System.out.print("-");
        }
        System.out.print("\n");
        for(int indexI = 0; indexI < n; indexI ++) {
            for (int indexJ = 0; indexJ < n; indexJ ++) {
                System.out.printf(" | %d", matrix[indexI][indexJ]);
                for(int space = 0, size = max - (int) (Math.log10(matrix[indexI][indexJ]) + 1); space <= size; space ++){
                    System.out.print(" ");
                }
                System.out.print(" | ");
            }
            System.out.printf("\n");
            for (int indexJ = 0; indexJ < n * (max + 7); indexJ++) {
                System.out.print("-");
            }
            System.out.print("\n");
        }
    }

    private static void matrixMagicSquare(int[][] square, int n){
        for(int indexI = 0; indexI < n; indexI ++){
            for(int indexJ = 0; indexJ < n; indexJ ++){
                square[indexI][indexJ] = n * ((indexI + indexJ + 1 + n / 2) % n) + (indexI + 2 * indexJ + 1) % n + 1;
            }
        }
    }

    private static void checkMagicSquare(int[][] square, int n){
        int constMagic = n * (n * n + 1) / 2, sum = 0;

        for(int line = 0; line < n; line ++){
            for(int column = 0; column < n; column ++){
                sum = sum + square[line][column];
            }
            if(sum != constMagic){
                System.out.print("Matrix Is Not Magic\n");
                return;
            }
            sum = 0;
        }

        for(int column = 0; column < n; column ++){
            for(int line = 0; line < n; line ++){
                sum = sum + square[line][column];
            }
            if(sum != constMagic){
                System.out.print("Matrix Is Not Magic\n");
                return;
            }
            sum = 0;
        }

        for(int diag = 0; diag < n; diag ++){
            sum = sum + square[diag][diag];
        }
        if(sum != constMagic){
            System.out.print("Matrix Is Not Magic\n");
            return;
        }
        sum = 0;

        for(int diag = 0; diag < n; diag ++){
            sum = sum + square[diag][n - 1 - diag];
        }
        if(sum != constMagic){
            System.out.print("Matrix Is Not Magic\n");
            return;
        }

        System.out.print("Matrix Is Magic\n");
    }

    public static void main(String[] args) {
        startTime = System.nanoTime();
        if(inputCheck(args) == false){
            return;
        }

        int n = Integer.parseInt(args[0]);
        int[][] m = new int[n][n];

        matrixMagicSquare(m, n);
        checkMagicSquare(m, n);
        printMatrix(m, n);

        System.out.print("All good\n");
    }

    private static long startTime;
}
