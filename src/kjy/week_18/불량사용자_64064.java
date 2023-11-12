package kjy.week_18;

import java.util.HashSet;
import java.util.Set;

public class 불량사용자_64064 {
    private String[] userIds;
    private String[] bannedIds;
    private Set<Set<String>> resultSet = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        userIds = user_id;
        bannedIds = banned_id;

        dfs(new HashSet<>(), 0);

        return resultSet.size();
    }

    private void dfs(Set<String> set, int depth) {
        if (depth == bannedIds.length) {
            resultSet.add(set);
            return;
        }

        for (String userId : userIds) {
            if(set.contains(userId)) {
                continue;
            }

            // 백트래킹
            if (like(bannedIds[depth], userId)) {
                set.add(userId);
                dfs(new HashSet<>(set), depth + 1);
                set.remove(userId);
            }
        }
    }

    private boolean like(String bannedId, String userId) {
        if (bannedId.length() != userId.length()) {
            return false;
        }

        for (int i = 0; i < bannedId.length(); i++) {
            if (bannedId.charAt(i) != '*' &&
                bannedId.charAt(i) != userId.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
