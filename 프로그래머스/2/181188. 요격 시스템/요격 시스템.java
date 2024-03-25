import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int min = 0, max = 0; 
        Arrays.sort(targets, (o1,o2)->{
            return o1[0] - o2[0];
        });
        min = targets[0][0];
        max = targets[0][1];
        for(int i=1; i<targets.length; i++){
            if(min == max){
                min = targets[i-1][0];
                max = targets[i-1][1];
            }
            if(max<=targets[i][0]){
                answer++;
                min=max;
                continue;
            }

            min = targets[i][0];
            max = Math.min(targets[i][1],max);
            
        }
        answer++;

        return answer;
    }
}