package com.hcp.algorithm;

/**
 * Created by hcp on 2018/9/17.
 */
public class FindInMatrix {


    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}};
        test(matrix, 7);
        searchMatrix(matrix, 7);
    }

    public static void test(int[][] matrix, int number) {
        int row = 0;
        int column = matrix[0].length - 1;
        int i = 0;
        while (row < matrix.length - 1 && column >= 0) {
            if (matrix[row][column] == number) {
                System.out.println("row = " + row + ", column = " + column + ", number = " + matrix[row][column]);
                System.out.println("i = " + i);
                break;
            } else if (matrix[row][column] > number) {
                --column;
            } else {
                ++row;
            }
            i = i + 1;
        }
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int xLength = matrix[0].length;
        int min = 0;
        int max = matrix[0].length * matrix.length - 1;

        int x, y, current, i = 0;
        while (min <= max) {
            current = (min + max) / 2;
            y = current / xLength;
            x = current % xLength;
            if (matrix[y][x] == target) {
                System.out.println("y = " + y + ", x = " + x);
                System.out.println("i = " + i);
                return  true;
            } else if (target < matrix[y][x]) {
                max = current - 1;
            } else {
                min = current + 1;
            }
            i = i + 1;
        }

        return false;
    }
}
