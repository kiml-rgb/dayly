package huaweiod.day5;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/4/6 9:48
 * @description:
 */
public class C2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 黑棋
        HashSet<String> chessBlack = new HashSet<>();
        // 白棋
        HashSet<String> chessWhite = new HashSet<>();

        getChess(scanner, chessBlack);
        getChess(scanner, chessWhite);

        HashSet<String> chessBlackQi = getChessBlackQi(chessBlack, chessWhite);
        HashSet<String> chessWhiteQi = getChessBlackQi(chessWhite, chessBlack);

        System.out.println(chessBlackQi.size());
        System.out.println(chessWhiteQi.size());
    }

    private static HashSet<String> getChessBlackQi(HashSet<String> chess1, HashSet<String> chess2) {
        HashSet<String> chessQi = new HashSet<>();
        for (String s : chess1) {
            String[] split = s.split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);

            // 上
            if (y - 1 >= 0) {
                if (!chess1.contains(x + " " + (y - 1)) && !chess2.contains(x + " " + (y - 1))) {
                    chessQi.add(x + " " + (y - 1));
                }
            }

            // 下
            if (y + 1 <= 18) {
                if (!chess1.contains(x + " " + (y + 1)) && !chess2.contains(x + " " + (y + 1))) {
                    chessQi.add(x + " " + (y + 1));
                }
            }

            // 左
            if (x - 1 >= 0) {
                if (!chess1.contains((x - 1) + " " + y) && !chess2.contains((x - 1) + " " + y)) {
                    chessQi.add((x - 1) + " " + y);
                }
            }

            // 右
            if (x + 1 <= 18) {
                if (!chess1.contains((x + 1) + " " + y) && !chess2.contains((x + 1) + " " + y)) {
                    chessQi.add((x + 1) + " " + y);
                }
            }
        }
        return chessQi;
    }

    private static void getChess(Scanner scanner, HashSet<String> chess) {
        if (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] s1 = s.split(" ");
            for (int i = 0; i < s1.length; i = i + 2) {
                chess.add(s1[i]+ " " +s1[i + 1]);
            }
        }
    }
}
