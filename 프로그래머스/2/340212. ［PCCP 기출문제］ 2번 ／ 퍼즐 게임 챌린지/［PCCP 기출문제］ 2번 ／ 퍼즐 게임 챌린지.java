class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int min = 1;
        int max = 0;
        for(int i=0; i<diffs.length; i++){
            max = max < diffs[i] ? diffs[i] : max;
        }
        int temp = (max+min) / 2;
        answer = max;
        while(min <= max){
            long total = 0l;
            if(temp>=diffs[0]){
                total += times[0];
            }else{
                total += (diffs[0] - temp + 1) * times[0];
            }
        
            for(int i=1; i<diffs.length; i++){
                if(temp>=diffs[i]){
                    total += times[i];
                }else{
                    total += (diffs[i] - temp) * (times[i-1] + times[i]) + times[i];    
                }
                if(total>limit){
                    min = temp+1;
                    temp = (max+min)/2;
                    break;
                }
            }
            if(total<=limit){
                answer = Math.min(answer,temp);
                max = temp-1;
                temp = (max+min)/2;
            }
  
        }
        return answer;
    }
}