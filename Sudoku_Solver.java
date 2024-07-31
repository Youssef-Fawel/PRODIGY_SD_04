package PRODIGY_SD_04;

public class Sudoku_Solver {

    public static void main(String[] args) {
        int[][] puzzle = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (solveSudoku(puzzle)) {
            System.out.println("TASK 04 by [Youssef Fawel]");
            System.out.println("Sudoku puzzle solved successfully!!!");
            displayBoard(puzzle);
        } else {
            System.out.println("No solution exists for the given Sudoku puzzle.");
        }
    }

 static boolean solveSudoku(int[][] puzzle) {
        int[] emptyCell = findEmptyCell(puzzle);

        if (emptyCell == null) {
            return true; 
        }

        int row = emptyCell[0];
        int col = emptyCell[1];

        for (int num = 1; num <= 9; num++) {
            if (isValidPlacement(puzzle, row, col, num)) {
                puzzle[row][col] = num;

                if (solveSudoku(puzzle)) {
                    return true;
                }

                puzzle[row][col] = 0;
            }
        }

        return false; 
    }

   
    public static int[] findEmptyCell(int[][] puzzle) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (puzzle[r][c] == 0) {
                    return new int[]{r, c};
                }
            }
        }
        return null;
    }

   
    public static boolean isValidPlacement(int[][] puzzle, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (puzzle[row][i] == num || puzzle[i][col] == num) {
                return false;
            }
        }

        int boxStartRow = row - row % 3;
        int boxStartCol = col - col % 3;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (puzzle[boxStartRow + r][boxStartCol + c] == num) {
                    return false;
                }
            }
        }

        return true;
    }

   
    public static void displayBoard(int[][] puzzle) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                System.out.print(puzzle[r][c] + " ");
            }
            System.out.println();
        }
    }
}
