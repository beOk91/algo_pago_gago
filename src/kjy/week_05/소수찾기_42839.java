package kjy.week_05;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기_42839 {
    public int solution(String numbers) {
        Set<Integer> ns = new HashSet<>();
        makeNumberSet("", numbers, ns);

        int answer = 0;
        for (int number : ns) {
            if (isPrime(number)) {
                answer++;
            }
        }

        return answer;
    }
    
    public void makeNumberSet(String prefix, String others, Set<Integer> numberSet) {
        if (!"".equals(prefix)) {
            numberSet.add(Integer.parseInt(prefix));
        }

        int length = others.length();
        for (int i = 0; i < length; i++) {
            makeNumberSet(prefix + others.charAt(i), others.substring(0, i) + others.substring(i + 1, length), numberSet);
        }
    }
    
    public boolean isPrime(int number) {
        if (number == 2) {
            return true;
        }

        if (number == 0 || number == 1 || number % 2 == 0) {
            return false;
        }

        for (int i = 3; i < Math.sqrt(number) + 1; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}