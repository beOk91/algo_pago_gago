package kbs.programmers.level2;

public class Problem12953 {
	public int solution(int[] arr) {
        int answer=arr[0];
        for(int i=1;i<arr.length;i++) {
        	answer=LCM(answer, arr[i]);
        }
        
        return answer;
    }
    
	public int GCD(int num1,int num2) {
        if(num1<num2){
            int temp=num2;
            num2=num1;
            num1=temp;
        }
    	if(num2==0) return num1;
    	return GCD(num2,num1%num2);
    }
	
	public int LCM(int num1,int num2) {
		int gcd=GCD(num1,num2);
		return gcd*num1/gcd*num2/gcd;
	}
}
