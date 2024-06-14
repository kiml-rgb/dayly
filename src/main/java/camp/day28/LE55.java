package camp.day28;

/**
 * @author ZYF
 * @date: 2024/6/14 9:22
 * @description:
 */
public class LE55 {
    public static void main(String[] args) {
        boolean b = canJump(new int[]{2,3,1,1,4});
        System.out.println(b);
    }


    public static boolean canJump(int[] nums) {
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxIndex) {
                return false;
            }

            maxIndex = Math.max(nums[i] + i, maxIndex);
            if (maxIndex >= nums.length - 1){
                return true;
            }
        }
        return false;
    }
}
