package kjy.week_17;

import java.util.Arrays;

public class 파일명_정렬_17686 {
    public String[] solution(String[] files) {
        Arrays.sort(files, ((x, y) -> {
            String[] file1 = split(x);
            String[] file2 = split(y);

            int head = file1[0].compareTo(file2[0]);
            if (head != 0) {
                return head;
            }

            return Integer.parseInt(file1[1]) - Integer.parseInt(file2[1]);
        }));
        
        return files;
    }
    
    private String[] split(String str) {
        String head = "";
        String number = "";

        int i = 0;
        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if ('0' <= c && c <= '9') {
                break;
            }
            head += c;
        }

        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!('0' <= c && c <= '9')) {
                break;
            }
            number += c;
        }

        return new String[]{head.toLowerCase(), number};
    }
}
