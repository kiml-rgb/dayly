package huaweiod.day3;

import java.util.*;

/**
 * @author ZYF
 * @date: 2024/4/2 21:56
 * @description: 描述
 * 数据表记录包含表索引index和数值value（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照index值升序进行输出。
 * <p>
 * <p>
 * 提示:
 * 0 <= index <= 11111111
 * 1 <= value <= 100000
 * <p>
 * 输入描述：
 * 先输入键值对的个数n（1 <= n <= 500）
 * 接下来n行每行输入成对的index和value值，以空格隔开
 * <p>
 * 输出描述：
 * 输出合并后的键值对（多行）
 */
public class HJ8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 0;
        if (scanner.hasNextLine()) {
            size = Integer.parseInt(scanner.nextLine());
        }

        Map<String, Integer> map = new TreeMap<>(Comparator.comparingInt(Integer::parseInt));
        int i = 0;
        while (i < size && scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] s1 = s.split(" ");
            Integer value = map.get(s1[0]);
            if (value != null) {
                value = value + Integer.parseInt(s1[1]);
                map.put(s1[0], value);
            } else {
                map.put(s1[0], Integer.parseInt(s1[1]));
            }
            i++;
        }

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
