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
    }

    public static void test(int[][] matrix, int number) {
        int row = 0;
        int column = (matrix[0].length - 1);
        while (row < matrix.length - 1 && column >= 0) {
            if (matrix[row][column] == number) {
                System.out.println("row = " + row + ", column = " + column + ", number = " + matrix[row][column]);
                break;
            } else if (matrix[row][column] > number) {
                --column;
            } else {
                ++row;
            }
        }
    }
}
