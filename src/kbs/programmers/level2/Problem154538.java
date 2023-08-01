package kbs.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Problem154538 {
	public int solution(int x, int y, int n) {
        int answer = -1;
        Queue<Integer []>q=new LinkedList<Integer[]>();
        boolean visited[]=new boolean[1000001];
        q.offer(new Integer[]{x,0});
        while(!q.isEmpty()){
            Integer[] temp = q.poll();
            if(temp[0] == y) {answer=temp[1]; break; }
            if(temp[0]*3 <=y && !visited[temp[0]*3]) {
                q.offer(new Integer[]{temp[0]*3,temp[1]+1});
                visited[temp[0]*3]=true;}
            if(temp[0]*2 <=y && !visited[temp[0]*2]){
                q.offer(new Integer[]{temp[0]*2,temp[1]+1});
                visited[temp[0]*2]=true;}
            if(temp[0]+n <=y && !visited[temp[0]+n]) {
                q.offer(new Integer[]{temp[0]+n,temp[1]+1});
                visited[temp[0]+n]=true;}
               
        }
        return answer;
    }
}
