package kbs.programmers.level2;

public class Problem60057 {
	public static void main(String[] args) {
		System.out.println(solution("abcabcabcabcdededededede"));
	}
	public static int solution(String s) {
        int answer = Integer.MAX_VALUE;
        for(int i=1;i<=s.length();i++){
        	StringBuilder compress =new StringBuilder("");
        	String comp_element="";
            int count=1;
            
            for(int j=0;j<s.length();j+=i){
            	String element = s.substring(j,j+i>s.length()? s.length() :j+i);
            	if(comp_element.isEmpty()) {
            		comp_element=element;
            		count=1;
            	}else if(!comp_element.equals(element)) {
            		compress.append((count!=1 ? count+"" : "")+comp_element);
            		comp_element=element;
            		count=1;
            	}else {
            		count+=1;
            	}
            }
            compress.append((count!=1 ? count+"" : "")+comp_element);
            answer=Math.min(answer, compress.length());
        }
        return answer;
    }
}
