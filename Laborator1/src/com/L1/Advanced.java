package com.L1;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.variables.IntVar;

import java.util.ArrayList;
import java.util.Scanner;

public class Advanced {

    private static boolean inputCheck(String input){
        String regexCheck = "[0-9][0-9]*";
        if(input.matches(regexCheck) == false){
            System.out.print("Input Is Not A Number\n");
            return false;
        }

        return  true;
    }

    private static void printChocoSolution(String chocoSolution, int n){
        int space = 0;
        chocoSolution = chocoSolution.replace("Solution: ", "");

        for(int index = 0; index < chocoSolution.length(); index ++){
            System.out.print(chocoSolution.charAt(index));
            if(chocoSolution.charAt(index) == ' '){
                space ++;
                if(space % n == 0){
                    System.out.print("\n");
                    space = 0;
                }
            }
        }
        System.out.print("\n\n");
    }

    public static void main(String[] args) {

        System.out.print("N = ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if(inputCheck(input) == false){
            return;
        }
        int n = Integer.parseInt(input), ConstMagic = n * (n * n + 1) / 2;

        Model model = new Model("Choco-Solver Magic-Square");
        IntVar[][] square = new IntVar[n][n];

        for(int line = 0; line < n; line ++){
            for(int column = 0; column < n; column ++){
                square[line][column] = model.intVar("Square[" + line + "][" + column + "]", 1, n * n);
            }
        }

        for(int line = 0; line < n; line ++) {
            model.sum(square[line], "=", ConstMagic).post();
        }

        ArrayList<IntVar> constrList = new ArrayList<IntVar>();
        for(int column = 0; column < n; column ++) {
            for(int line = 0; line < n; line ++){
                constrList.add(square[line][column]);
            }
            model.sum(constrList.toArray(new IntVar[n]), "=", ConstMagic).post();
            constrList.clear();
        }

        for(int diag = 0; diag < n; diag ++){
            constrList.add(square[diag][diag]);
        }
        model.sum(constrList.toArray(new IntVar[n]), "=", ConstMagic).post();
        constrList.clear();

        for(int diag = 0; diag < n; diag ++){
            constrList.add(square[diag][n - 1 - diag]);
        }
        model.sum(constrList.toArray(new IntVar[n]), "=", ConstMagic).post();
        constrList.clear();

        Solution solution;
        while (true){
            solution = model.getSolver().findSolution();
            if(solution == null){
                break;
            }
            printChocoSolution(solution.toString(), n);
        }
    }
}
