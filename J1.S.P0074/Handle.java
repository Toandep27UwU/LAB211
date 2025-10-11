/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg74;

import java.util.*;

/**
 *
 * @author DELL
 */
public class Handle {
    
    private static int[][] matrix1;
    private static int[][] matrix2;

    public static void option() {
        while (true) {
            System.out.println("========== Calculator Program ==========");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Exit");
            int choice = Validation.checkIntLimit(4, 1);
            switch (choice) {
                case 1:
                    matrix1 = inputMatrix();
                    matrix2 = inputMatrix();
                    displayMatrix(additionMatrix(matrix1, matrix2));
                    break;
                case 2:
                    matrix1 = inputMatrix();
                    matrix2 = inputMatrix();
                    displayMatrix(subtractionMatrix(matrix1, matrix2));
                    break;
                case 3:
                    matrix1 = inputMatrix();
                    matrix2 = inputMatrix(); 
                    displayMatrix(multiplicationMatrix(matrix1, matrix2));
                    break;
                case 4:
                    System.out.println("Exit...");
                    return;
            }
        }
    }

    public static int[][] inputMatrix() {
        System.out.print("Enter rows: ");
        int row = Validation.checkIntLimit(Integer.MAX_VALUE, 1);
        System.out.print("Enter columns: ");
        int col = Validation.checkIntLimit(Integer.MAX_VALUE, 1);
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("Enter value [%d][%d]: ", i, j);
                matrix[i][j] = Validation.checkIntLimit(Integer.MAX_VALUE, Integer.MIN_VALUE);
            }
        }
        return matrix;
    }

    public static void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            System.out.println("Can not add !!!");
        }
        int[][] matrixResult = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrixResult.length; i++) {
            for (int j = 0; j < matrixResult[0].length; j++) {
                matrixResult[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return matrixResult;
    }

    public static int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            System.out.println("Can not subtract !!!");
        }
        int[][] matrixResult = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrixResult.length; i++) {
            for (int j = 0; j < matrixResult[0].length; j++) {
                matrixResult[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return matrixResult;
    }

    public static int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1[0].length != matrix2.length) {
            System.out.println("Can not multiply !!!");
        }
        int[][] matrixResult = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrixResult.length; i++) {
            for (int j = 0; j < matrixResult[0].length; j++) {
                matrixResult[i][j] = 0;
                for (int k = 0; k < matrix1[0].length; k++) {
                    matrixResult[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return matrixResult;
    }
}
