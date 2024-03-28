class Solution {
    public int solution(int x, int y, int n) {
        int answer;
        int[] dp = new int[y+1];
        dp[x] = 1;
        for(int i=x+1; i<=y; i++){
            int a = i-n;
            if(a<0){
                a = 0;
            }
            if(i%3==0 && dp[i/3] != 0){
                if(i%2==0 && dp[i/2] != 0){
                    if(dp[a] !=0){
                        dp[i] = Math.min(Math.min(dp[i/3],dp[a])+1, Math.min(dp[i/2],dp[a])+1);
                    }else{
                         dp[i] = Math.min(dp[i/3],dp[i/2])+1;
                    }
                }else if(dp[a] !=0){
                    dp[i] = Math.min(dp[i/3],dp[a])+1;
                }else{
                    dp[i] = dp[i/3]+1;
                }
            }else if(i%2==0 && dp[i/2] != 0){
                if(dp[a] !=0){
                    dp[i] = Math.min(dp[i/2],dp[a])+1;
                }else{
                    dp[i] = dp[i/2]+1;
                }
            }else if(dp[a] !=0){
                dp[i] = dp[a] +1;
            }
        }
        if(dp[y] == 0){
            answer = -1;
        }else{
            answer = dp[y]-1;
        }
        return answer;
    }
   
}