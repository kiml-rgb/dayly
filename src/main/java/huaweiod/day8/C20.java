package huaweiod.day8;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ZYF
 * @date: 2024/4/10 22:45
 * @description:
 */
public class C20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = Arrays.stream(scanner.nextLine().split(",")).sorted((o1, o2) -> {
            if (o1.substring(0, 2).equals(o2.substring(0, 2))) {
                return o1.substring(2).compareTo(o2.substring(2));
            }
            return o1.substring(0, 2).compareTo(o2.substring(0, 2));
        }).collect(Collectors.joining(","));
        System.out.println(s);
    }
}
