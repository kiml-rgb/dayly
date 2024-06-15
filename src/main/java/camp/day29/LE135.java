package camp.day29;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/6/14 15:45
 * @description:
 */
public class LE135 {
    public static void main(String[] args) {
        int candy = candy(new int[]{1, 0, 2});
        System.out.println(candy);
    }

    public static int candy(int[] ratings) {
        if (ratings.length <= 1) {
            return ratings.length;
        }

        int[] result = new int[ratings.length];
        result[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                result[i] = result[i - 1] + 1;
            } else {
                result[i] = 1;
            }
        }
        System.out.println(Arrays.toString(result));


        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && result[i] <= result[i + 1]) {
                result[i] = result[i + 1] + 1;
            }
        }
        System.out.println(Arrays.toString(result));

        return Arrays.stream(result).sum();
    }
}
