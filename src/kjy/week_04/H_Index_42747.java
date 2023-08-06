package kjy.week_04;

import java.util.Arrays;

public class H_Index_42747 {
    public int solution(int[] citations) {        
        Arrays.sort(citations);

        int papers = citations.length;
        for (int i = 0; i < papers; i++) {
            if (citations[i] >= papers - i) {
                return papers - i;
            }
        }

        return 0;
    }
}
