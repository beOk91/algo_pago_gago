package kh.programmers.다리를_지나는_트럭;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private static class Truck {
        int weight;
        int startTime;

        Truck(int weight, int startTime) {
            this.weight = weight;
            this.startTime = startTime;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 1;
        Queue<Truck> bridge = new LinkedList<>();
        Queue<Truck> wait = new LinkedList<>();

        int bridgeTotalWeight = 0;

        for (int w : truck_weights) {
            wait.add(new Truck(w, 0));
        }

        while(!bridge.isEmpty() || !wait.isEmpty()) {
            if (!bridge.isEmpty()) {
                if (time - bridge.peek().startTime >= bridge_length) {
                    Truck completeTruck = bridge.remove();
                    bridgeTotalWeight -= completeTruck.weight;
                }
            }
            if (!wait.isEmpty()) {
                if (bridge.size() < bridge_length && bridgeTotalWeight + wait.peek().weight <= weight) {
                    Truck nextTruck = wait.remove();
                    nextTruck.startTime = time;
                    bridgeTotalWeight += nextTruck.weight;
                    bridge.add(nextTruck);
                }
            }

            if (bridge.isEmpty() && wait.isEmpty()) {
                break;
            }

            time++;
        }

        return time;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};

        int solution = s.solution(bridge_length, weight, truck_weights);

        System.out.println("solution = " + solution);
    }
}
