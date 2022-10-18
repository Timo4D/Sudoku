package src;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        // for (int i = 0; i < 100; i++) {
        //     new Sudoku();
        // }
        new Sudoku();
        long stopTime = System.currentTimeMillis();
        System.out.println(stopTime - startTime + "ms");
    }
}
