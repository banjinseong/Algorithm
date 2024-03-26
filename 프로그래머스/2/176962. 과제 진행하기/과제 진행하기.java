import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int ck = 0;
        Stack<Integer> stk = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<plans.length; i++){
            String[] srr = plans[i][1].split(":");
            int j = Integer.parseInt(srr[0]) * 60 + Integer.parseInt(srr[1]);
            map.put(j,i);
        }
        for(int i=0; i<1440; i++){
            if(!stk.isEmpty()){
                int j = stk.pop();
                int temp = Integer.parseInt(plans[j][2]) -1;
                if(temp != 0){
                    plans[j][2] = String.valueOf(temp);
                    stk.push(j);
                }else{
                    answer[ck] = plans[j][0];
                    ck++;
                }
            }
            if(map.containsKey(i)){
                int j = map.get(i);
                stk.push(j);
            }
        }
        while(!stk.isEmpty()){
            int j = stk.pop();
            answer[ck] = plans[j][0];
            ck++;
        }
        return answer;
    }
}