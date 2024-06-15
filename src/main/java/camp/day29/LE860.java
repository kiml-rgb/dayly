package camp.day29;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZYF
 * @date: 2024/6/14 16:23
 * @description:
 */
public class LE860 {


    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                ten++;
                five--;
                if (five < 0) {
                    return false;
                }
            } else if (bill == 20) {
                if (five >= 1 && ten >= 1) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
