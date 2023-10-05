package kjy.week_14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 튜플_64065 {
    public int[] solution(String s) {
        String[] tuples = s.substring(2, s.length()).substring(0, s.length() - 4).split("\\},\\{");
        Arrays.sort(tuples, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        
        List<Integer> nTuple = new ArrayList<>();
        for (String str: tuples) {
            String[] tuple = str.split(",");

            for (String t: tuple) {
                int n = Integer.parseInt(t);

                if (!nTuple.contains(n)) {
                    nTuple.add(n);
                }
            }
        }

        int[] answer = new int[nTuple.size()];
        for (int i = 0; i < nTuple.size(); i++) {
            answer[i] = nTuple.get(i);
        }

        return answer;
    }
}
