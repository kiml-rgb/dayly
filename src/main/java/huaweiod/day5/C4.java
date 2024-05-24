package huaweiod.day5;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ZYF
 * @date: 2024/4/6 13:25
 * @description:
 */
public class C4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 项目数
        int num = 0;
        // 分数
        List<Integer> scoreList = new ArrayList<>();

        if (scanner.hasNextLine()) {
            num = Integer.parseInt(scanner.nextLine());
        }

        if (scanner.hasNextLine()) {
            String[] s = scanner.nextLine().split(" ");
            scoreList = Arrays.stream(s).map(Integer::parseInt).collect(Collectors.toList());
        }

        List<Project> projects = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String s = scanner.nextLine();
            String[] split = s.split(" ");
            Project project = new Project();
            project.setName(split[0]);
            project.setScore(Integer.parseInt(split[1]) * scoreList.get(0) + Integer.parseInt(split[2]) * scoreList.get(1) + Integer.parseInt(split[3]) * scoreList.get(2) + Integer.parseInt(split[4]) * scoreList.get(3) + Integer.parseInt(split[5]) * scoreList.get(4));
            projects.add(project);
        }
        projects = projects.stream().sorted((o1, o2) -> o1.getScore().equals(o2.getScore()) ? o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase()) : o2.getScore() - o1.getScore()).collect(Collectors.toList());

        projects.forEach(p -> System.out.println(p.getName()));
    }

    public static class Project {
        private String name;
        private Integer score;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }
    }
}
