package huaweiod.day9;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ZYF
 * @date: 2024/4/11 14:31
 * @description:
 */
public class C23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();


        int length = 0;
        String res = null;
        for (int i = 0; i <= chars.length; i++) {
            for (int j = i + 1; j <= chars.length; j++) {
                String substring = s.substring(i, j);
                Matcher matcher = Pattern.compile("([+-]?(\\d+[-+*])*\\d+)").matcher(substring);
                while (matcher.find()) {
                    String exp = matcher.group(0);
                    if (exp.length() > length) {
                        res = exp;
                        length = exp.length();
                    }
                }
            }
        }

        if (res == null) {
            System.out.println(0);
        }

        Character c1 = res.charAt(0);
        if (c1 == '-' || c1 == '+') {
            res = res.substring(1);
        } else {
            c1 = null;
        }
    }
}
