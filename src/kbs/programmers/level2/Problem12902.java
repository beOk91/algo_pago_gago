package kbs.programmers.level2;

public class Problem12902 {
	public static void main(String[] args) {
		System.out.println(solution(10));
	}

	public static int solution(int n) {
		long dp[]=new long[5001];
		dp[2]=3; dp[4]=11;
		for(int i=6;i<=n;i+=2) {
            dp[i]=dp[i-2]*3+2;
            for(int j=i-4;j>=2;j-=2){
                dp[i]+=dp[j]*2;
            }
			dp[i]%=1000000007;
		}
        return (int)dp[n];
    }
}
