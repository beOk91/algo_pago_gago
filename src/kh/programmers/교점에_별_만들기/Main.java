package kh.programmers.교점에_별_만들기;

import java.util.*;

class Solution {

    private long maxX = Long.MIN_VALUE;
    private long maxY = Long.MIN_VALUE;
    private long minX = Long.MAX_VALUE;
    private long minY = Long.MAX_VALUE;
    private Set<String> meetSet;

    public String[] solution(int[][] line) {
        String[] answer = {};
        List<String> answerList = new ArrayList<>();

        meetSet = new HashSet<>();

        // 1. for loop
        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                int[] line1 = line[i];
                int[] line2 = line[j];

                String meet = getMeet(line1, line2);

                if (!meet.isBlank()) {
                    String[] split = meet.split(",");

                    long meetX = Long.parseLong(split[0]);
                    long meetY = Long.parseLong(split[1]);

                    maxX = Math.max(meetX, maxX);
                    minX = Math.min(meetX, minX);
                    maxY = Math.max(meetY, maxY);
                    minY = Math.min(meetY, minY);

                    meetSet.add(meet);
                }
            }
        }

        for (long y = maxY; y >= minY; y--) {
            StringBuilder lineBuilder = new StringBuilder();
            for (long x = minX; x <= maxX; x++) {
                String point = x + "," + y;

                if (meetSet.contains(point)) {
                    lineBuilder.append("*");
                }
                else {
                    lineBuilder.append(".");
                }
            }
            answerList.add(lineBuilder.toString());
        }


        return answerList.toArray(new String[0]);
    }

    public String getMeet(int[] line1, int[] line2) {
        long A = (long) line1[0];
        long B = (long) line1[1];
        long E = (long) line1[2];
        long C = (long) line2[0];
        long D = (long) line2[1];
        long F = (long) line2[2];

        // 평행하거나 동일한 직선인 경우
        if ((A * D - B * C) == 0) {
            return "";
        }

        // 정수로 표현되지 않는 경우
        if ((B*F - E*D) % (A*D - B*C) != 0 || (E*C - A*F) % (A*D - B*C) != 0) {
            return "";
        }

        return (B*F - E*D) / (A*D - B*C) + "," + (E*C - A*F) / (A*D - B*C);
    }
}

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};

        String[] solution = s.solution(line);

        System.out.println("solution = " + solution);
    }
}
