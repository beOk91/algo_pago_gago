package kjy.week_09;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 여행경로_43164 {
    public String[] solution(String[][] tickets) {
        // 티켓 맵 생성 및 알파벳 순 정렬
        Map<String, List<String>> routers = new HashMap<>();
        for (String[] ticket: tickets) {
            List<String> router = routers.getOrDefault(ticket[0], new ArrayList<String>());
            if (router.isEmpty()) {
                router.add(ticket[1]);
                routers.put(ticket[0], router);
            } else {
                router.add(ticket[1]);
            }
        }
        for (String key: routers.keySet()) {
            Collections.sort(routers.get(key));
        }

        // DFS
        List<String> path = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();
        stack.addFirst("ICN");

        while (!stack.isEmpty()) {
            String top = stack.getFirst();
            
            if (routers.keySet().contains(top) && !routers.get(top).isEmpty()) {
                String pop = routers.get(top).remove(0);
                stack.addFirst(pop);
            } else {
                path.add(stack.removeFirst());
            }
        }

        // 결과 역순으로 반환
        String[] answer = new String[path.size()];
        for (int i = 0; i < path.size(); i++) {
            answer[i] = path.get(path.size() - 1 - i);
        }
        return answer;
    }
}