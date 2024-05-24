package camp.day1;

import java.util.Arrays;
import java.util.PrimitiveIterator;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author ZYF
 * @date: 2024/4/17 22:53
 * @description:
 */
public class LE27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        int val = Integer.parseInt(scanner.nextLine());

        System.out.println(removeElement(nums, val));
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (val != nums[j]) {
                nums[i++]= nums[j];
            }
        }
        return i;
    }

//    public static int removeElement(int[] nums, int val) {
//        int i, j;
//        for (i = 0, j = nums.length - 1; i <= j ; ) {
//            // 第一次修改 -> if改为while
//            // 第三次修改 -> 加上j的边界值限制, 不然会数组越界
//            while (j >= 0 && nums[j] == val) {
//                j--;
//            }
//            while (i <= nums.length - 1 && nums[i] != val) {
//                i++;
//            }
//            // 第二次修改 -> 加上i < j的判断, 否则最后一次交换会把数组换乱
//            if (i < j) {
//                int temp = nums[j];
//                nums[j] = nums[i];
//                nums[i] = temp;
//            }
//        }
//        return i;
//    }
}
