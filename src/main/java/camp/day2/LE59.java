package camp.day2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/4/21 23:20
 * @description:
 */
public class LE59 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(Arrays.deepToString(generateMatrix(n)));
    }

    public static int[][] generateMatrix(int n) {
        int[][] ints = new int[n][n];
        int startX = 0;
        int startY = 0;
        int k = 1;
        int loop = 1;
        int i, j;

        while (k <= n * n && loop <= n / 2) {
            for (j = startY; j < n - loop; j++) {
                ints[startX][j] = k++;
            }
            for (i = startX; i < n - loop; i++) {
                ints[i][j] = k++;
            }
            for (; j > startY ; j--) {
                ints[i][j] = k++;
            }
            for (; i > startX; i--) {
                ints[i][j] = k++;
            }
            startX++;
            startY++;
            loop++;
        }
        if (n % 2 == 1) {
            ints[startX][startY] = k;
        }
        return ints;
    }
}
