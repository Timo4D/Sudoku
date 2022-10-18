package src;

import java.util.Random;

public class Sudoku {

    private int[][] grid = new int[9][9];
    private Random rand = new Random();

    public Sudoku() {
        // fill();
        generateFirstBoxes();
        print();
    }

    private boolean isSafe(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {

            if(grid[row][i] == num) {
                return false;
            }
            if(grid[i][col] == num) {
                return false;
            }
        }

        int startRow = row-row%3;
        int startCol = col-col%3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(grid[i+startRow][j+startCol] == num) {
                    return false;
                }
            }
        }


        return true;
    }

    // Generates the first 3 boxes that dont influence eachother
    private void generateFirstBoxes() {
        for (int i = 0; i < 3; i++) {
            int x = 0;
            int[] array = generateValidBoxNumbers();
            for (int j = 0; j < 3; j++) {
                for (int p = 0; p < 3; p++) {
                    grid[j + i * 3][p + i * 3] = array[x];
                    x++;
                }
            }
        }
    }

    // Returns an array of the numbers 1-9 in random positions
    private int[] generateValidBoxNumbers() {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        for (int i = 0; i < 9; i++) {
            int randindex = rand.nextInt(9);
            int tmp = array[i];
            array[i] = array[randindex];
            array[randindex] = tmp;
        }

        return array;
    }

    // Fills the geid with some numbers
    public void fill() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = 9;
            }
        }
    }

    // Prints the grid to the console
    public void print() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
