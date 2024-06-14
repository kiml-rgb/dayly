package camp.day28;

/**
 * @author ZYF
 * @date: 2024/6/14 9:47
 * @description:
 */
public class LE45 {
    public static void main(String[] args) {
        int jump = jump(new int[]{0});
        System.out.println(jump);
    }

    /**
     * 假设每次都跳跃区间内最远的距离
     * @param nums 数组
     * @return 结果
     */
    public static int jump(int[] nums) {
        int maxIndex = 0;
        int maxJ = 0;
        int count = 0;

        if (nums.length == 1) {
            return count;
        }

        for (int i = 0; i < nums.length;) {
            if (i + nums[i] >= nums.length - 1) {
                count++;
                return count;
            }

            for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {

                if (j + nums[j] >= maxIndex) {
                    maxIndex = j + nums[j];
                    maxJ = j;
                }
            }
            count++;
            i = maxJ;
        }

        return count;
    }
}
