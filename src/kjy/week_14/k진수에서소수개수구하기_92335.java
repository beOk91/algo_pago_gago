package kjy.week_14;

public class k진수에서소수개수구하기_92335 {
    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        String numStr = sb.reverse().toString();
        String[] numArr = numStr.split("0");

        int answer = 0;
        for (String num : numArr) {
            if ("".equals(num)) {
                continue;
            }

            if (isPrime(Long.parseLong(num))) {
                answer++;
            }
        }

        return answer;
    }
    
    public boolean isPrime(long num) {
        if (num == 1) {
            return false;
        }

        if (num == 2) {
            return true;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
