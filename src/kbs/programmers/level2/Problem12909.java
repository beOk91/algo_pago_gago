package kbs.programmers.level2;

public class Problem12909 {
	boolean solution(String s) {
        int chk = 0; 
        for(int i=0;i<s.length();i++){ 
            if(s.charAt(i)=='(') chk++;
            else chk--;
            if(chk<0) return false;
        } 

        return ( chk!=0 || s.length()==0) ? false: true;
    }
}
