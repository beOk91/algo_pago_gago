package kjy.week_15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class 주차요금계산_92341 {
    public int[] solution(int[] fees, String[] records) {
        // 차량번호, 입차시간
        Map<String, Integer> parkings = new HashMap<>();
        // 차량번호, 누적주차시간
        Map<String, Integer> costs = new TreeMap<>();

        for (String record: records) {
            // r[0]: 시간, r[1]: 차량번호, r[2]: IN/OUT
            String[] r = record.split(" ");
            String[] hhmm = r[0].split(":");
            int time = Integer.parseInt(hhmm[0]) * 60 + Integer.parseInt(hhmm[1]);

            if ("IN".equals(r[2])) {
                parkings.put(r[1], time);
            } else {
                int parkingTime = time - parkings.get(r[1]);
                costs.put(r[1], costs.getOrDefault(r[1], 0) + parkingTime);
                parkings.remove(r[1]);
            }
        }

        for (String parking : parkings.keySet()) {
            int parkingTime = 23 * 60 + 59 - parkings.get(parking);
            costs.put(parking, costs.getOrDefault(parking, 0) + parkingTime);
        }

        List<Integer> answer = new ArrayList<>();
        for (Integer time: costs.values()) {
            // 기본요금 + (누적시간 - 기본시간) / 단위시간 * 단위요금
            int additional = time > fees[0] ? (int) Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3] : 0;
            answer.add(fees[1] + additional);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
