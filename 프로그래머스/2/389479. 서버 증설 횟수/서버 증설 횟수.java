class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] up = new int[24];
        for(int i=0; i<players.length; i++){
            int now = up[i];
            int need = players[i] / m;
            if(need <= now){
                continue;
            }
            int count = i + k > 24 ? 24 : i + k;
            int plus = need - now;
            answer += plus;
            
            for(int j=i; j<count; j++){
                up[j] += plus;
            }
        }
        return answer;
    }
}