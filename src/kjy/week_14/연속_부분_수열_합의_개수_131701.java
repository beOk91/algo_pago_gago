package kjy.week_14;

import java.util.HashSet;
import java.util.Set;

public class 연속_부분_수열_합의_개수_131701 {
    public int solution(int[] elements) {
        int[] doubleElements = new int[elements.length * 2];

        for(int i = 0; i < elements.length; i++) {
            doubleElements[i] = elements[i];
            doubleElements[i + elements.length] = elements[i];
        }

        Set<Integer> set = new HashSet<>();
        
        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int sum = 0;
                for (int k = j; k < j + i; k++) {
                    sum += doubleElements[k];
                }
                set.add(sum);
            }
        }

        return set.size();
    }
}
