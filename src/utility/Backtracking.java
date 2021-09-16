package utility;

public class Backtracking {

    private boolean isSafe(int[][] board, int row, int col, int num) {

        for (int i = 0; i < board.length; i++)
            if (board[row][i] == num)
                return false;

        for (int[] ints : board)
            if (ints[col] == num)
                return false;

        int sqrt = (int)Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int i = boxRowStart; i < boxRowStart + sqrt; i++)
            for (int n = boxColStart; n < boxColStart + sqrt; n++)
                if (board[i][n] == num)
                    return false;

        return true;
    }

    public boolean solveSudoku(int[][] board, int n) {

        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;

                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty)
                break;
        }

        if (isEmpty)
            return true;

        for (int i = 1; i <= n; i++) {
            if (isSafe(board, row, col, i)) {
                board[row][col] = i;
                if (solveSudoku(board, n))
                    return true;
                else
                    board[row][col] = 0;
            }
        }

        return false;
    }

    public int[][] getSolvedBoard(int[][] board) {
        return board;
    }
}
