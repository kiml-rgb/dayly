package huaweiod.day4;

import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/4/4 21:14
 * @description:
 *
 * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 *
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 *
 * 数据范围：输入的字符串长度满足
 * 1 ≤ n ≤ 1000
 *
 * 1≤n≤1000
 *
 * 注意本题有多组输入
 * 输入描述：
 * 输入一个英文语句，每个单词用空格隔开。保证输入只包含空格和字母。
 *
 * 输出描述：
 * 得到逆序的句子
 */
public class HJ13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] strings = s.split(" ");
            for (int i = 0; i < strings.length/2; i++) {
                String temp = strings[i];
                strings[i] = strings[strings.length - 1 - i];
                strings[strings.length - 1 - i] = temp;
            }
            System.out.println(String.join(" ", strings));
        }
    }
}
