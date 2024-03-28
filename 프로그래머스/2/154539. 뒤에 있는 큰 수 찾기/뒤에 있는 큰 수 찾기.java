import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stk = new Stack<>();
        Stack<Integer> index = new Stack<>();
        for(int i=0; i<numbers.length; i++){
            while(!stk.isEmpty()){
                int a = stk.pop();
                if(a<numbers[i]){
                    answer[index.pop()] = numbers[i];
                }else{
                    stk.push(a);
                    break;
                }
            }
            stk.push(numbers[i]);
            index.push(i);
        }
        while(!index.isEmpty()){
            answer[index.pop()] = -1;
        }
        return answer;
    }
}