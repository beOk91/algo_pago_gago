package kbs.programmers.level2;

public class Problem12951 {
	public static void main(String[] args) {
		System.out.println(solution("3people unFollowed me "));
	}

	public static String solution(String s) {
		String answer = "";
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==' ') {
				answer+=" ";
			}else {
				if((i>0 && s.charAt(i-1)==' ') || i==0) answer+=(s.charAt(i)+"").toUpperCase();
				else answer+=(s.charAt(i)+"").toLowerCase();
			}
		}
		return answer;
	}
}
