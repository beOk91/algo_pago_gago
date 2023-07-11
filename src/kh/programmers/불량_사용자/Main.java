package kh.programmers.불량_사용자;


import java.util.*;

class Solution {
    private Map<String, Boolean> banned;
    private Set<String> caseSet = new HashSet<>();

    public int solution(String[] userIdArr, String[] bannedIdArr) {
        int answer = 0;

        List<List<String>> candidateMap = getCandidateList(userIdArr, bannedIdArr);
        initUserStatus(userIdArr);

        dfs(0, new ArrayList<>(), candidateMap);


        return caseSet.size();
    }

    private void dfs(int idx, List<String> bannedList, List<List<String>> candidateMap) {
        if (candidateMap.size() == idx) {
            if (bannedList.size() == candidateMap.size()) {
                String bannedListConcat = getBannedListConcat(bannedList);
                if (!caseSet.contains(bannedListConcat)) {
                    caseSet.add(bannedListConcat);
                }
            }
            return;
        }

        List<String> candidateList = candidateMap.get(idx);

        for (String candidate : candidateList) {
            if (!banned.get(candidate)) {
                bannedList.add(candidate);
                banned.replace(candidate, true);

                dfs(idx + 1, bannedList, candidateMap);

                bannedList.remove(bannedList.size() - 1);
                banned.replace(candidate, false);
            }
        }

    }

    private String getBannedListConcat(List<String> bannedList) {
        List<String> tmpList = new ArrayList<>(bannedList);
        Collections.sort(tmpList);
        StringBuilder sb = new StringBuilder();
        sb.append(tmpList);
        return sb.toString();
    }

    private void initUserStatus(String[] userIdArr) {
        banned = new HashMap<>();
        for (String userId : userIdArr) {
            banned.put(userId, false);
        }
    }

    private List<List<String>> getCandidateList(String[] userIdArr, String[] bannedIdArr) {
        List<List<String>> answer = new ArrayList<>();

        boolean isCandidate;

        for (String bannedId : bannedIdArr) {
            List<String> candidateList = new ArrayList<>();
            answer.add(candidateList);

            for (String userId : userIdArr) {
                isCandidate = true;

                char[] bannedIdCharArr = bannedId.toCharArray();
                char[] userIdCharArr = userId.toCharArray();

                if (userIdCharArr.length != bannedIdCharArr.length) {
                    continue;
                }

                for (int i = 0; i < userIdCharArr.length; i++) {
                    if (bannedIdCharArr[i] == '*') {
                        continue;
                    }
                    if (bannedIdCharArr[i] != userIdCharArr[i]) {
                        isCandidate = false;
                        break;
                    }
                }

                if (isCandidate) {
                    candidateList.add(userId);
                }
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};

//        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
//        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};

        int solution = s.solution(user_id, banned_id);
        System.out.println("solution = " + solution);
    }
}
