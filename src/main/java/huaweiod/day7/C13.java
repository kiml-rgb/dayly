package huaweiod.day7;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ZYF
 * @date: 2024/4/9 20:22
 * @description:
 */
public class C13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> line1 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> back = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> risk = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> max = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int sumMoney = line1.get(1);
        int sumRisk = line1.get(2);

        int maxBack = Integer.MIN_VALUE;
        int minRisk = Integer.MAX_VALUE;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < line1.get(0); i++) {
            if (risk.get(i) > sumRisk) {
                continue;
            } else {
                int money = Math.min(sumMoney, max.get(i));
                int backMoney = money * back.get(i);
                if ((risk.get(i) <= minRisk && backMoney == maxBack) || (backMoney > maxBack)) {
                    map.clear();
                    map.put(i, money);
                    minRisk = risk.get(i);
                    maxBack = backMoney;
                }
            }

            for (int j = i + 1; j < line1.get(0); j++) {
                if (risk.get(i) + risk.get(j) <= sumRisk) {
                    int backMoney = 0;
                    int backMoneyA = 0;
                    int backMoneyB = 0;
                    if (back.get(i) >= back.get(j)) {
                        backMoneyA = Math.min(sumMoney, max.get(i));
                        int remain = sumMoney - Math.min(sumMoney, max.get(i));
                        backMoneyB = Math.min(remain, max.get(j));
                        backMoney = backMoneyA * back.get(i) + backMoneyB * back.get(j);
                    } else if (back.get(i) < back.get(j)) {
                        backMoneyB = Math.min(sumMoney, max.get(j));
                        int remain = sumMoney - Math.min(sumMoney, max.get(j));
                        backMoneyA = Math.min(remain, max.get(i));
                        backMoney = backMoneyA * back.get(i) + backMoneyB * back.get(j);
                    }

                    if (backMoney > maxBack || (backMoney == maxBack && (risk.get(i) + risk.get(j)) < minRisk)) {
                        map.clear();
                        map.put(i, backMoneyA);
                        map.put(j, backMoneyB);
                        minRisk = risk.get(i) + risk.get(j);
                        maxBack = backMoney;
                    }
                }
            }
        }

        for (int i = 0; i < line1.get(0); i++) {
            if (!map.containsKey(i)) {
                map.put(i, 0);
            }
        }

        System.out.println(map.values().stream().map(Object::toString).collect(Collectors.joining(" ")));
    }
}
