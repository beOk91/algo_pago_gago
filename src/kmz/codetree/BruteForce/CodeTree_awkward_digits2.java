package kmz.codetree.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeTree_awkward_digits2 {
    /*
     * https://www.codetree.ai/missions/5/problems/awkward-digits-2?&utm_source=clipboard&utm_medium=text
     */
    static int maxValue = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] inputs = br.readLine().toCharArray();
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i] == '0') {
                inputs[i] = '1';
                compare(inputs);
                inputs[i] = '0';
            } else {
                inputs[i] = '0';
                compare(inputs);
                inputs[i] = '1';
            }
        }
        System.out.println(maxValue);
    }

    public static void compare(char[] inputs) {
        int changedValue = Integer.parseInt(String.valueOf(inputs), 2);
        if (changedValue > maxValue) {
            maxValue = changedValue;
        }
    }
}
