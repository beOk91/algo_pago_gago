package kjy.week_05;

public class 카펫_42842 {
    public int[] solution(int brown, int yellow) {
        int size = brown + yellow;

        for (int height = 1 ; height <= Math.sqrt(size); height++) {
            if (size % height != 0) {
                continue;
            }

            int width = size / height;
            if (yellow == (width - 2) * (height - 2)) {
                return new int[]{width, height};
            }
        }

        return null;
    }
}
