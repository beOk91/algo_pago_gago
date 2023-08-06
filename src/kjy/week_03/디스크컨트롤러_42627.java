package kjy.week_03;

import java.util.PriorityQueue;

public class 디스크컨트롤러_42627 {
    public int solution(int[][] jobs) {
        int answer = 0;
        int start = -1;
        int elapsedTime = 0;
        int completed = 0;

        // 소요시간 오름차순 정렬
        PriorityQueue<Job> pq = new PriorityQueue<>();
        while (completed < jobs.length) {
            for (var job: jobs) {
                if (start < job[0] && job[0] <= elapsedTime) {
                    pq.add(new Job(job[0], job[1]));
                }
            }

            if (!pq.isEmpty()) {
                Job finished = pq.poll();
                start = elapsedTime;
                elapsedTime += finished.getTime();
                answer += elapsedTime - finished.getStart();
                completed++;
            } else {
                elapsedTime++;
            }
        }

        return answer / jobs.length;
    }

    static class Job implements Comparable<Job> {
        private final int start;
        private final int time;

        public Job(int start, int time) {
            this.start = start;
            this.time = time;
        }

        public int getStart() {
            return this.start;
        }

        public int getTime() {
            return this.time;
        }

        @Override
        public int compareTo(Job other) {
            // 오름차순
            return this.getTime() - other.getTime();
        }
    }
}
