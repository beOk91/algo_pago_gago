package kbs.programmers.level2;

public class Problem12945 {
	int []dp=new int[100001];
	public int solution(int n) {
		if(dp[n]!=0) return dp[n]%1234567;
		else {
			if(n==1) return dp[1]=1;
			if(n==2) return dp[2]=1;
			else {
				return dp[n]=(solution(n-1)+solution(n-2))%1234567;
			}
		}
    }
}
