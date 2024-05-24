package huaweiod.day4;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ZYF
 * @date: 2024/4/4 21:24
 * @description:
 *
 * 描述
 * 给定 n 个字符串，请对 n 个字符串按照字典序排列。
 *
 * 1≤len≤100
 * 输入描述：
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 输出描述：
 * 数据输出n行，输出结果为按照字典序排列的字符串。
 */
public class HJ14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 数量
        int i = scanner.nextInt();

        List<String> stringList = new ArrayList<>();
        for (int i1 = 0; i1 < i + 1; i1++) {
            stringList.add(scanner.nextLine());
        }

        System.out.println(stringList.stream()
                .filter(s -> !"".equals(s))
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.joining("\n")));
    }
}
