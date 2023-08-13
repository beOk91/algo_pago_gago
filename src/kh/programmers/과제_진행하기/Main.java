package kh.programmers.과제_진행하기;


import java.util.*;

class Plan implements Comparable<Plan>{
    String name;
    Integer start;
    Integer playtime;

    Plan(String name, int start, String playtime) {
        this.name = name;
        this.start = start;
        this.playtime = Integer.parseInt(playtime);
    }

    @Override
    public int compareTo(Plan o) {
        return this.start.compareTo(o.start);
    }
}

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];

        Stack<Plan> pause = new Stack<>();
        List<Plan> complete = new ArrayList<>();
        List<Plan> planList = new ArrayList<>();
        Queue<Plan> queue = new LinkedList<>();
        boolean change = false;

        // 0 ~ 1439
        int time = 0;
        Plan now = null;

        for (String[] plan : plans) {
            planList.add(new Plan(plan[0], getMinute(plan[1]), plan[2]));
        }

        Collections.sort(planList);

        for (Plan plan : planList) {
            queue.add(plan);
        }


        while(true) {
            if (now == null && queue.isEmpty() && pause.isEmpty()) break;

            if (now == null) {
                // queue에서 꺼내올지 pause에서 꺼내올지 time과 비교해서 null로 둘지
                if (!queue.isEmpty()) {
                    if (queue.peek().start == time) {
                        now = queue.remove();
                        continue;
                    }
                    else if (!pause.isEmpty()) {
                        now = pause.pop();
                        continue;
                    }
                }
                else {
                    if (!pause.isEmpty()) {
                        now = pause.pop();
                        continue;
                    }
                }
            }
            else {
                now.playtime--;
                change = false;

                // 종료, 새 job 체크
                if (now.playtime == 0) {
                    complete.add(now);
                    now = null;
                }

                if (!queue.isEmpty()) {
                    if (queue.peek().start == time) {
                        if (now != null) {
                            pause.push(now);
                        }
                        now = queue.remove();
                    }
                }

                if (now == null) {
                    if (!pause.isEmpty()) {
                        now = pause.pop();
                    }
                }
            }

            if (change) {
                now.playtime--;
            }

            time++;
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = complete.get(i).name;
        }


        return answer;
    }

    public int getMinute(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3, 5));

        return hour * 60 + minute;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
        s.solution(plans);
    }
}
