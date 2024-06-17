package camp.day31;

/**
 * @author ZYF
 * @date: 2024/6/17 9:51
 * @description:
 */
public class LE738 {
    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(1023));
    }

    public static int monotoneIncreasingDigits(int n) {
        String num = n + "";
        if (num.length() <= 1) {
            return n;
        }

        int start = -1;
        char[] chars = num.toCharArray();
        for (int i = chars.length - 1; i >= 1; i--) {
            if (chars[i - 1] > chars[i]) {
                chars[i - 1]--;
                start = i;
//                // 从i开始都变成9
//                for (int j = i; j < chars.length; j++) {
//                    chars[j] = '9';
//                }
            }
        }
        if (start != -1) {
            // 从i开始都变成9
            for (int j = start; j < chars.length; j++) {
                chars[j] = '9';
            }
        }

        return Integer.parseInt(String.valueOf(chars));
    }
}
