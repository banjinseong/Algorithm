import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        long hab1 = 0;
        long hab2 = 0;
        long half = 0;
        int answer = 0;
        int j = 0;
        for(int i=0; i<queue1.length; i++){
            que1.add(queue1[i]);
            que2.add(queue2[i]);
            hab1 += queue1[i];
            hab2 += queue2[i];
        }
        if((hab1+hab2)%2 == 0){
            half = (hab1+hab2)/2;
        }else{
            answer = -1;
        }
        while(true){
            if(j>1000000){
                answer = -1;
            }
            if(answer == -1 || hab1==hab2){
                break;
            }
            if(hab1>hab2){
                int poll = que1.poll();
                if(poll>half){
                    answer = -1;
                    break;
                }
                que2.add(poll);
                hab1 -= poll;
                hab2 += poll;
                answer++;
            }else{
                int poll = que2.poll();
                if(poll>half){
                    answer = -1;
                    break;
                }
                que1.add(poll);
                hab1 += poll;
                hab2 -= poll;
                answer++;
            }
            j++;
        }
        
        return answer;
    }
}