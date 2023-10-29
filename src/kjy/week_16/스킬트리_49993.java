package kjy.week_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 스킬트리_49993 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        List<String> skillList = Arrays.asList(skill.split(""));

        for (String skillTree : skill_trees) {
            List<String> order = new ArrayList<>();
            
            for (String s : skillTree.split("")) {
                if (skillList.contains(s)) {
                    order.add(s);
                }
            }

            boolean flag = true;
            for (int i = 0; i < order.size(); i++) {
                if (!order.get(i).equals(skillList.get(i))) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                answer++;
            }
        }

        return answer;
    }
}
