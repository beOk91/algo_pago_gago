package kh.programmers.기능개발;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    private static class Job {
        int progress;
        int speed;

        Job(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }
    }

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        List<Integer> answerList = new ArrayList<>();
        Queue<Job> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            q.add(new Job(progresses[i], speeds[i]));
        }

        while(!q.isEmpty()) {
            develop(q);
            int deployCount = deploy(q);

            if (deployCount > 0) {
                answerList.add(deployCount);
            }
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }

    private void develop(Queue<Job> jobQueue) {
        for (Job job : jobQueue) {
            job.progress += job.speed;
        }
    }

    private int deploy(Queue<Job> jobQueue) {
        int answer = 0;

        while(true) {
            if (jobQueue.isEmpty() || jobQueue.peek().progress < 100) {
                break;
            }
            else {
                jobQueue.remove();
                answer++;
            }
        }

        return answer;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] progresses = {93, 20, 35, 75, 90, 5, 15};
        int[] speeds = {1, 3, 5, 7, 9, 2, 10};

        int[] solution = s.solution(progresses, speeds);

        for (int i : solution) {
            System.out.print(i + ",");
        }
    }
}
