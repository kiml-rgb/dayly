package huaweiod.day9;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ZYF
 * @date: 2024/4/11 10:51
 * @description:
 */
public class C22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<String> s = Arrays.asList(scanner.nextLine().split(" "));

        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < list.get(0); i++) {
            String[] s1 = scanner.nextLine().split(" ");
            List<Integer> scoreList = new ArrayList<>();
            for (int j = 0; j < list.get(1); j++) {
                scoreList.add(Integer.parseInt(s1[j + 1]));
            }
            Student student = new Student();
            student.setName(s1[0]);
            student.setScoreList(scoreList);
            studentList.add(student);
        }

        String sort = scanner.nextLine();

        String collect = studentList.stream().sorted(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int index = s.indexOf(sort);
                if (s.contains(sort)) {
                    if (o2.getScoreList().get(index).equals(o1.getScoreList().get(index))) {
                        return o1.getName().compareTo(o2.getName());
                    } else {
                        return o2.getScoreList().get(index).compareTo(o1.getScoreList().get(index));
                    }
                } else {
                    long sumA = o1.getScoreList().stream().collect(Collectors.summarizingInt(i -> i)).getSum();
                    long sumB = o2.getScoreList().stream().collect(Collectors.summarizingInt(i -> i)).getSum();
                    if (sumA == sumB) {
                        return o1.getName().compareTo(o2.getName());
                    } else {
                        return (int) sumB - (int) sumA;
                    }
                }
            }
        }).map(Student::getName).collect(Collectors.joining(" "));

        System.out.println(collect);
    }

    public static class Student{
        private String name;

        private List<Integer> scoreList;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Integer> getScoreList() {
            return scoreList;
        }

        public void setScoreList(List<Integer> scoreList) {
            this.scoreList = scoreList;
        }
    }
}
