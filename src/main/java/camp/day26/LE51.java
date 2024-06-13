package camp.day26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZYF
 * @date: 2024/6/12 17:49
 * @description:
 */
public class LE51 {
    public static void main(String[] args) {
        solveNQueens(4);
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] chars = new char[n][n];

        for (char[] c : chars) {
            Arrays.fill(c, '.');
        }

        solveNQueensDFS(0, n, chars, result);
        return result;
    }

    /**
     * @param row    行数
     * @param n      棋盘大小
     * @param chars  棋盘摆法
     * @param result 结果
     */
    private static void solveNQueensDFS(int row, int n, char[][] chars, List<List<String>> result) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (char[] aChar : chars) {
                list.add(String.copyValueOf(aChar));
            }
            result.add(list);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(row, i, n, chars)) {
                chars[row][i] = 'Q';
                solveNQueensDFS(row + 1, n, chars, result);
                chars[row][i] = '.';
            }
        }
    }

    private static boolean isValid(int row, int col, int n, char[][] chars) {
        // 检查列
        for (int i = 0; i < row; ++i) {
            if (chars[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chars[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chars[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
