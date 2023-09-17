package kjy.week_11;

public class JadenCase문자열만들기_12951 {
    public String solution(String s) {
        char[] charArr = s.toLowerCase().toCharArray();
        boolean toUpper = true;

        StringBuilder sb = new StringBuilder();
        for (char c: charArr) {
            sb.append(toUpper && 'a' <= c && c <= 'z' ? (char)(c - 32) : c);
            toUpper = c == ' ' ? true : false;
        }
        return sb.toString();
    }
}
