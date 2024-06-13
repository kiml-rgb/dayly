package camp.day27;

import java.util.Arrays;

/**
 * @author ZYF
 * @date: 2024/6/13 9:55
 * @description:
 */
public class LE376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        // 当前的差值
        int curDiff = 0;
        // 前一个坡的差值
        int preDiff = 0;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];

            if ((preDiff >= 0  && curDiff < 0) || (preDiff <= 0 && curDiff > 0)) {
                count++;
                // 只有坡度更新才记录坡值
                preDiff = curDiff;
            }
        }

        return count;
    }
}
