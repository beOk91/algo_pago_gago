package kh.programmers.주차_요금_계산;

import java.util.*;

class Solution {

    private final String IN = "IN";
    private final String OUT = "OUT";
    private final String LAST_TIME = "23:59";

    private static class Record implements Comparable<Record> {
        String time;
        String carNo;
        String remk;

        Record(String time, String carNo, String remk) {
            this.time = time;
            this.carNo = carNo;
            this.remk = remk;
        }

        @Override
        public int compareTo(Record o) {
            return this.time.compareTo(o.time);
        }
    }


    private Map<String, Integer> table = new HashMap<>();
    private Map<String, Record> parkingArea = new HashMap<>();

    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        List<Record> recordList = new ArrayList<>();
        Set<String> cars = new HashSet<>();

        for (String record : records) {
            String[] split = record.split(" ");
            recordList.add(new Record(split[0], split[1], split[2]));
        }

        for (Record record : recordList) {
            cars.add(record.carNo);

            if (record.remk.equals(IN)) {
                table.putIfAbsent(record.carNo, 0);
                parkingArea.put(record.carNo, record);
            }
            else if(record.remk.equals(OUT)) {
                Record inRecord = parkingArea.get(record.carNo);
                table.replace(record.carNo, table.get(record.carNo) + calculateMinute(inRecord.time, record.time));
                parkingArea.remove(record.carNo);
            }
        }

        // 출차하지 않은 차 계산
        for (Record record : parkingArea.values()) {
            table.replace(record.carNo, table.get(record.carNo) + calculateMinute(record.time, LAST_TIME));
        }

        List<String> carList = new ArrayList<>(cars);
        Collections.sort(carList);

        answer = new int[carList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = calculate(carList.get(i), fees);
        }

        return answer;
    }

    private int calculate(String carNo, int[] fees) {
        Integer totalTime = table.get(carNo);

        if (totalTime <= fees[0]) {
            return fees[1];
        }

        return fees[1] +
                ((((totalTime - fees[0]) % fees[2]) == 0
                        ? ((totalTime - fees[0]) / fees[2])
                        : ((totalTime - fees[0]) / fees[2]) + 1)
                        * fees[3]);
    }

    private int calculateMinute(String in, String out) {
        int inHour = Integer.parseInt(in.substring(0, 2));
        int inMinute = Integer.parseInt(in.substring(3, 5));
        int outHour = Integer.parseInt(out.substring(0, 2));
        int outMinute = Integer.parseInt(out.substring(3, 5));

        return 60 * (outHour - inHour) + outMinute - inMinute;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        int[] answer = s.solution(fees, records);
        for (int a : answer) {
            System.out.println("a = " + a);
        }
    }
}
