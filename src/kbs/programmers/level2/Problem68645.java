package kbs.programmers.level2;

public class Problem68645 {
	public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int value=1;
        int x=0,y=0;
        while(true) {
	        while(true){
	            triangle[y][x]=value++;
	            if(y+1==n || triangle[y+1][x]!=0) break;
	            y++;
	        }
	        if(x+1==n || triangle[y][x+1]!=0) break;
	        x++;
	        while(true) {
	        	triangle[y][x]=value++;
	        	if(x+1==n || triangle[y][x+1]!=0) break;
	        	x++;
	        }
	        if(triangle[y-1][x-1]!=0) break;
	        x--; y--;
	        while(true) {
	        	triangle[y][x]=value++;
	        	if(triangle[y-1][x-1]!=0) break;
	        	x--; y--;
	        }
	        if(y+1==n || triangle[y+1][x]!=0) break;
            y++;
	        
        }
        int answer[]=new int[value-1];
        int idx=0;
        for(int i=0;i<n;i++) {
        	for(int j=0;j<=i;j++) {
        		answer[idx++]=triangle[i][j];
        	}
        }
        return answer;
    }
}
