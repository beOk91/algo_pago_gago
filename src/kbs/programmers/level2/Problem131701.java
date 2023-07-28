package kbs.programmers.level2;

public class Problem131701 {

}

class Solution {
    public int solution(int[] elements) {
        boolean []arr =new boolean[1000001];
        int answer = 0;
        
        for(int i=0;i<elements.length;i++){
            int sum = 0;
            for(int j=0;j<elements.length;j++){
                sum+=elements[(i+j)%elements.length];
                if(!arr[sum]) arr[sum]=true;
            }
        }
        
        for(int i=1;i<1000001;i++){
            if(arr[i]) answer++;    
        }
        return answer;
    }
}