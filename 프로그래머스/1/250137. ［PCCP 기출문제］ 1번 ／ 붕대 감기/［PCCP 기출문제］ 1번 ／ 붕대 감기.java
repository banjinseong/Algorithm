class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        int max = health;
        int time = 0;
        int j = 0;
        int maxTime = attacks[attacks.length-1][0];
    
        for(int i=1; i<=maxTime; i++){
            if(i==attacks[j][0]){
                health -= attacks[j][1];
                time = 0;
                j++;
                if(health<=0){
                    health =-1;
                    break;
                }
            }else{
                health += x;
                time++;
                if(t == time){
                    health += y;
                    time = 0;
                }
                if(health>max){
                    health = max;
                }
            }
        }

        int answer = health;
        return answer;
    }
}