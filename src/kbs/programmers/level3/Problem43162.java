package kbs.programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class Problem43162 {

}
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        Queue<Integer>q=new LinkedList<Integer>(); q.add(0);
        boolean [] visited=new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!visited[i]) {
                q.add(i); 
                visited[i]=true; 
                answer++;
            }
            
            while(!q.isEmpty()){
                int temp = q.poll();
                for(int j=0;j<n;j++){
                    if(computers[temp][j]==1 && !visited[j]) {
                        q.add(j); visited[j]=true;
                    }
                }
            }
                        
        }
        return answer;
    }
}
