import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int len = Math.min((picks[0]+picks[1]+picks[2])*5,minerals.length);
        int[] arr = new int[len/5+2];
        for(int i=0; i<len; i++){
            int one;
            if(minerals[i].equals("diamond")){
                one = 100;
            }else if(minerals[i].equals("iron")){
                one = 10;
            }else{
                one = 1;
            }
            arr[i/5] +=one; 
        }
        Arrays.sort(arr);
        for(int i=arr.length-1; i>=0; i--){
            if(arr[i]==0){
                continue;
            }
            int c = 5;
            if(len<5){
                c=len;
            }
            if(picks[0]>0){
                answer += c;
                picks[0]--;
                len -=5;
            }else if(picks[1]>0){
                int a = arr[i]/100;
                answer += a*5 + (c-a);
                picks[1]--;
                len -=5;
            }else if(picks[2]>0){
                int a = arr[i]/100;
                int b = (arr[i]%100)/10;
                answer += a*25 + b*5 + (c-a-b);
                picks[2]--;
                len -=5;
            }
        }
        return answer;
    }
}