package kjy;

import java.util.ArrayDeque;
import java.util.Deque;

public class 다리를지나는트럭_42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Truck> waiting = new ArrayDeque<>();
        Deque<Truck> moving = new ArrayDeque<>();

        for (var w: truck_weights) {
            waiting.offerLast(new Truck(w));
        }

        int time = 0;
        int current_weight = 0;

        while(!(waiting.isEmpty() && moving.isEmpty())) {
            time++;

            // 다리를 지나는 트럭이 없으면
            if (moving.isEmpty()) {
                Truck t = waiting.pollFirst();
                t.move();
                moving.offerLast(t);
                current_weight += t.getWeight();
                continue;
            }

            // 트럭 이동
            for (var t: moving) {
                t.move();
            }

            // 맨 앞 차가 다리를 건넜으면
            if (moving.peekFirst().getMove() > bridge_length) {
                current_weight -= moving.pollFirst().getWeight();
            }

            // 트럭이 추가로 올라갈 수 있으면
            if (!waiting.isEmpty() && weight - current_weight >= waiting.peekFirst().getWeight()) {
                Truck t = waiting.pollFirst();
                t.move();
                moving.offerLast(t);
                current_weight += t.getWeight();
            }
        }

        return time;
    }

    static class Truck {
        private int weight;
        private int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 0;
        }

        public int getWeight() {
            return this.weight;
        }

        public int getMove() {
            return this.move;
        }

        public void move() {
            this.move++;
        }
    }
}
