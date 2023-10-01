package kjy.week_13;

public class 점프와순간이동_12980 {
    public int solution(int n) {
        int energy = 0;
        while (n > 0) {
            if (n % 2 != 0) {
                n--;
                energy++;
            }
            n /= 2;
        }
        return energy;
    }
}
