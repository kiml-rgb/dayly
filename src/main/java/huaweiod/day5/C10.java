package huaweiod.day5;

import java.util.*;

/**
 * @author ZYF
 * @date: 2024/4/6 20:07
 * @description:
 */
public class C10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        String[] moneys = scanner.nextLine().split(" ");
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 1; i <= moneys.length; i++) {
            hashMap.put(i + "", Integer.parseInt(moneys[i - 1]));
        }

        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < num - 1; i++) {
            String[] line = scanner.nextLine().split(" ");
            List<String> list = new ArrayList<>();
            if (map.get(line[0]) != null) {
                list = map.get(line[0]);
                list.add(line[1]);
            } else {
                list.add(line[1]);
            }
            map.put(line[0], list);
        }

        int max = Integer.MIN_VALUE;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            int sum = hashMap.get(entry.getKey());
            for (String s : entry.getValue()) {
                sum += hashMap.get(s);
            }
            max = Math.max(sum, max);
        }
        System.out.println(max);
    }
}
