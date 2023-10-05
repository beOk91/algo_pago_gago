package kjy.week_14;

import java.util.ArrayList;
import java.util.List;

public class 뉴스_클러스터링_17677 {
    public int solution(String str1, String str2) {
        List<String> str1Set = makeSet(str1);
        List<String> str2Set = makeSet(str2);

        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();

        for (String str: str1Set) {
            // str1Set에 원소가 str2Set에서 제거될 경우 해당 원소를 교집합에 추가
            if (str2Set.remove(str)) {
                intersection.add(str);
            }
            union.add(str);
        }

        // str2Set에서 교집합 부분이 전부 제거되었으니 str1Set + str2Set 은 합집합
        for (String str: str2Set) {
            union.add(str);
        }

        return union.size() == 0 ? 65536 : (int) (((float) intersection.size() / union.size()) * 65536);
    }

    private List<String> makeSet(String str) {
        List<String> set = new ArrayList<>();
        char[] strArr = str.toUpperCase().toCharArray();

        for (int i = 0; i < strArr.length - 1; i++) {
            if (('A' <= strArr[i] && strArr[i] <= 'Z') && ('A' <= strArr[i + 1] && strArr[i + 1] <= 'Z')) {
                String element = new StringBuilder().append(strArr[i]).append(strArr[i + 1]).toString();
                set.add(element);
            }
        }

        return set;
    }
}
