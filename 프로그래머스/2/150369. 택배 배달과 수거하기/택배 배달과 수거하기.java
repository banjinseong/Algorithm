class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long total = 0l;
        int x=n-1,y=n-1;
        int temp;
        
        while(x >= 0 || y >= 0){

            if(x >=0 && pickups[x] == 0){
                x--;
                continue;
            };
            if(y >= 0 && deliveries[y] == 0){
                y--;
                continue;
            }
            total += x>y ? (x+1)*2 : (y+1)*2;
            temp=cap;
            for(; x>=0; x--){
                if(temp-pickups[x]<=0){
                    pickups[x] -=temp;
                    break;
                }else{
                    temp -= pickups[x];
                    pickups[x] = 0;
                }
            }
            temp = cap;
            for(; y>=0; y--){
                if(temp-deliveries[y]<=0){
                    deliveries[y] -=temp;
                    break;
                }else{
                    temp -= deliveries[y];
                    deliveries[y] = 0;
                }
            }
        }
        long answer = total;
        return answer;
    }
}