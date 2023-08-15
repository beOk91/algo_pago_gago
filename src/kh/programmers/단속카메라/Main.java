package kh.programmers.단속카메라;

import java.util.*;

class Solution {

    private static class Car implements Comparable<Car> {
        Integer in;
        Integer out;

        Car(int in, int out) {
            this.in = in;
            this.out = out;
        }

        @Override
        public int compareTo(Car o) {
            return this.out.compareTo(o.out);
        }

        boolean meet(int camera) {
            return in <= camera && camera <= out;
        }
    }

    public int solution(int[][] routes) {
        int answer = 0;
        int camera = -30001;

        List<Car> ls = new ArrayList<>();
        for (int[] route : routes) {
            ls.add(new Car(route[0], route[1]));
        }
        Collections.sort(ls);

        for (Car car : ls) {
            if (!car.meet(camera)) {
                camera = car.out;
                answer++;
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};

        int answer = s.solution(routes);
        System.out.println("answer = " + answer);
    }
}
