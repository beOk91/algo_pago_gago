package kh.baekjoon.set4.그리디_알고리즘_1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class 회의실_배정_1931 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N;

    private static List<Meeting> meetings = new ArrayList<>();

    private static class Meeting {
        Long start;
        Long end;

        Meeting(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            meetings.add(new Meeting(Long.parseLong(line[0]), Long.parseLong(line[1])));
        }
    }

    private static void solution() throws IOException {
        // 1. sort
        meetings.sort((o1, o2) -> {
            if (o1.end.equals(o2.end)) {
                return o1.start.compareTo(o2.start);
            }

            return o1.end.compareTo(o2.end);
        });

        List<Meeting> selectedMeetings = new ArrayList<>();

        for (Meeting meeting : meetings) {
            if (selectedMeetings.isEmpty()
                    || !hit(selectedMeetings.get(selectedMeetings.size() - 1), meeting)) {
                selectedMeetings.add(meeting);
            }
        }

        bw.write(selectedMeetings.size() + "\n");
    }

    public static boolean hit(Meeting a, Meeting b) {
        return a.end > b.start;
    }

    public static void main(String[] args) throws IOException {
        input();

        solution();

        br.close();
        bw.flush();
        bw.close();
    }
}
