package kh.programmers.스킬_트리;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String user : skill_trees) {
            boolean pass = true;
            String tmpSkill = skill;
            for (char userSkill : user.toCharArray()) {
                if (!isValid(String.valueOf(userSkill), tmpSkill)) {
                    pass = false;
                    break;
                }

                if (hit(String.valueOf(userSkill), tmpSkill)) {
                    tmpSkill = tmpSkill.substring(1);
                }
            }

            if (pass) {
                answer++;
            }
        }

        return answer;
    }

    public boolean isValid(String userSkill, String skillTree) {
        boolean answer = true;

        if (skillTree.contains(userSkill) && !String.valueOf(skillTree.charAt(0)).equals(userSkill)) {
            answer = false;
        }

        return answer;
    }

    public boolean hit(String userSkill, String skillTree) {
        if (skillTree.isEmpty()) {
            return false;
        }
        return String.valueOf(skillTree.charAt(0)).equals(userSkill);
    }
}
public class Main {

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        Solution s = new Solution();

        int solution = s.solution(skill, skill_trees);
        System.out.println("solution = " + solution);
    }
}
