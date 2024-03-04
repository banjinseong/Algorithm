class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int win = 0;
        int zero = 0;
        int max, min;
        for(int i=0; i<6; i++){
            for(int j=0; j<6; j++){
                if(lottos[i] == 0){
                    zero++;
                    break;
                }
                if(lottos[i] == win_nums[j]){
                    win++;
                    break;
                }
            }    
        }
        max = (win + zero > 5) ? 1 : (win + zero > 4) ? 2 : (win + zero > 3) ? 3 : (win + zero > 2) ? 4 : (win + zero > 1) ? 5 : 6;
        min = (win > 5) ? 1 : (win > 4) ? 2 : (win > 3) ? 3 : (win > 2) ? 4 : (win > 1) ? 5 : 6;
        int[] answer = {max, min};
        return answer;
    }
}