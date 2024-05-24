package huaweiod.day6;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ZYF
 * @date: 2024/4/8 13:23
 * @description:
 */
public class C11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = Integer.parseInt(scanner.nextLine());
        String[] s = scanner.nextLine().split(" ");
        List<Integer> list = Arrays.stream(s).map(Integer::parseInt).collect(Collectors.toList());
        int length = Integer.MIN_VALUE;

        List<String> arrayList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                Integer sum = getSum(list, i, j);
                if (sum <= (j - i + 1) * min) {
                    if (length > j - i + 1) {
                        continue;
                    } else if (length == j - i + 1) {
                        arrayList.add(i + "-" + j);
                    } else {
                        arrayList.clear();
                        length = j - i + 1;
                        arrayList.add(i + "-" + j);
                    }
                }
            }
        }

        if (length == Integer.MIN_VALUE) {
            return;
        }

        System.out.println(String.join(" ", arrayList));
    }

    private static Integer getSum(List<Integer> list, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += list.get(k);
        }
        return sum;
    }
}
