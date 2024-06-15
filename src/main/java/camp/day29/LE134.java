package camp.day29;

/**
 * @author ZYF
 * @date: 2024/6/14 14:30
 * @description:
 */
public class LE134 {
    public static void main(String[] args) {
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};

        System.out.println(canCompleteCircuit(gas, cost));
    }

//    /**
//     * 思路：有两个 式子 相-，可以得到一个数组。
//     * 然后求这个数组，sum > 0 的情况。
//     * 环形循环不好处理，直接将路线延长一倍
//     * @param gas 汽油
//     * @param cost 消耗
//     * @return 结果
//     */
//    public static int canCompleteCircuit(int[] gas, int[] cost) {
//        int startIndex = -1;
//        int sum = 0;
//
//        for (int i = 0, j = i; i < gas.length * 2; i++, j++) {
//            if (startIndex != -1 && i - startIndex == gas.length) {
//                break;
//            }
//
//            if (sum == 0) {
//                startIndex = i;
//                if (startIndex >= gas.length) {
//                    startIndex = -1;
//                    break;
//                }
//            }
//
//            if (j >= gas.length) {
//                j = i - gas.length;
//            }
//
//            // 获取本段路的剩余情况
//            int diff = gas[j] - cost[j];
//
//            sum += diff;
//
//            if (sum < 0) {
//                startIndex = -1;
//                sum = 0;
//            }
//        }
//
//        return startIndex;
//    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                index = (i + 1) % gas.length;
                curSum = 0;
            }
        }
        if (totalSum < 0) {
            return -1;
        }
        return index;
    }
}
