package camp.day26;

/**
 * @author ZYF
 * @date: 2024/6/13 21:04
 * @description:
 */
public class LE37 {
    public void solveSudoku(char[][] board) {
        solveSudokuDFS(board);
    }

    private boolean solveSudokuDFS(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '0') {
                    continue;
                }
                for (char k = '1'; k <= '9'; k++) {
                    if (isvalid(i, j, k, board)) {
                        board[i][j] = k;

                        if (solveSudokuDFS(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                // 走到这一行，说明直到递归完毕，都没有返回true
                return false;
            }

        }

        return true;
    }

    /**
     * 判断棋盘放入这个数是否合法
     *
     * @param i     行
     * @param j     列
     * @param k     值
     * @param board 棋盘
     * @return 是否合法
     */
    private boolean isvalid(int i, int j, char k, char[][] board) {
        // 行中是否含有这个数
        // 列中是否含有这个数
        for (int index = 0; index < board.length; index++) {
            if (board[i][index] == k) {
                return false;
            }
            if (board[index][j] == k) {
                return false;
            }
        }

        // 9宫格中是否含有这个数
        int x = (i / 3) * 3;
        int y = (j / 3) * 3;

        for (int indexX = x; indexX < x + 3; indexX++) {
            for (int indexY = y; indexY < y + 3; indexY++) {
                if (board[indexX][indexY] == k) {
                    return false;
                }
            }
        }

        return true;
    }
}