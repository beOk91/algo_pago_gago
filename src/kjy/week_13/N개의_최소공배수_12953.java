package kjy.week_13;

public class N개의_최소공배수_12953 {
    public int solution(int[] arr) {
        int lcm = arr[0];

        for (int i = 1; i < arr.length; i++) {
            lcm = lcm(lcm, arr[i]);
        }

        return lcm;
    }

    // a * b = lcm(a, b) * gcd(a, b)
    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    // gcd(a, 0) = a
    // 유클리드 호제법 : a와 b의 최대공약수는 b와 r(a % b)의 최대공약수와 같다.
    // gcd(a, b) = gcd(b, a % b)
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
