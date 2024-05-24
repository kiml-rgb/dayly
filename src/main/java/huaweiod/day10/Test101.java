package huaweiod.day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ZYF
 * @date: 2024/4/14 13:38
 * @description:
 */
public class Test101 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if ("0".equals(s)) {
                break;
            }
            numList.add(Integer.parseInt(s));
        }

        for (Integer integer : numList) {
            Integer num = getChangeNum(integer);
            System.out.println(num);
        }
    }

    /**
     * 获取可以换取的数量
     * @param integer 输入
     * @return 输出
     */
    private static Integer getChangeNum(Integer integer) {
        int count = integer / 3;
        int remain = integer % 3;

        if (count == 0) {
            if (remain == 2) {
                return count + 1;
            } else {
                return count;
            }
        }
        count += getChangeNum(count + remain);
        return count;
    }
}
