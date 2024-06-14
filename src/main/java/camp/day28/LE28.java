package camp.day28;

/**
 * @author ZYF
 * @date: 2024/6/14 9:04
 * @description:
 */
public class LE28 {

    /**
     * 就是算所有增区间的值
     * @param prices 列表
     * @return 股票金额
     */
    public int maxProfit(int[] prices) {
        int sum = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i - 1]) {
                sum +=prices[i] - prices[i - 1];
            }
        }

        return sum;
    }
}
