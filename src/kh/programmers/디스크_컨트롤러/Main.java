package kh.programmers.디스크_컨트롤러;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    private static int now;

    private static Job currentJob;

    private static class Job implements Comparable<Job> {
        int reqTime;
        int length;
        int startTime;

        Job(int reqTime, int length) {
            this.reqTime = reqTime;
            this.length = length;
        }

        @Override
        public int compareTo(Job o) {
            return Integer.compare(length, o.length);
        }
    }

    public int solution(int[][] jobs) {
        int answer = 0;
        now = 0;
        PriorityQueue<Job> waitingJobs = new PriorityQueue<>();
        Queue<Job> nextJobs = new LinkedList<>();

        Arrays.sort(jobs, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return 0;
            } else {
                return o1[0] > o2[0] ? 1 : -1;
            }
        });

        for (int[] job : jobs) {
            nextJobs.add(new Job(job[0], job[1]));
        }

        // 실행중인 job -> cuurentJob
        // 대기중인 job -> pq
        // 다음 job -> jobs

        while (true) {
            if (nextJobs.isEmpty() && waitingJobs.isEmpty() && currentJob == null) {
                break;
            }

            if (!nextJobs.isEmpty()) {
                Job nextJob = nextJobs.peek();
                if (now == nextJob.reqTime) {
                    waitingJobs.add(nextJob);
                    nextJobs.remove();
                    continue;
                }
            }

            if (currentJob != null) {
                if (now == currentJob.startTime + currentJob.length) {
                    answer += (now - currentJob.reqTime);
                    currentJob = null;
                    continue;
                }
            }

            if (!waitingJobs.isEmpty()) {
                if (currentJob == null) {
                    Job nextJob = waitingJobs.remove();
                    start(nextJob, now);
                    continue;
                }
            }

            now++;
        }

        return answer / jobs.length;
    }

    private void start(Job job, int now) {
        currentJob = job;
        currentJob.startTime = now;
    }
}

public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[][] jobs = {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}};
        int solution = s.solution(jobs);
        System.out.println("solution = " + solution);
    }
}
