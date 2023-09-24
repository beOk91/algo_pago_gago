package kbs.programmers.level2;

import java.util.Arrays;
import java.util.stream.Stream;

public class Problem12939 {

	public String solution(String s) {
        String answer = "";
        int []arr =Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        return arr[0]+" "+arr[arr.length-1];
    }
}
