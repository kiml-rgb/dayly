package camp.day6;

import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/5/24 15:41
 * @description:
 */
public class LE383 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ransomNote = scanner.nextLine();
        String magazine = scanner.nextLine();
        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] ints = new int[26];
        // 遍历存储数量
        for (int i = 0; i < magazine.length(); i++) {
            ints[magazine.charAt(i) - 97]++;
        }
        // 遍历扣除数量
        for (int i = 0; i < ransomNote.length(); i++) {
            ints[ransomNote.charAt(i) - 97]--;
        }
        for (int i : ints) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }
}
