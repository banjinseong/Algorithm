import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        long[] dp = new long[n+1];
        long max = 0l;
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        if(n<3){
            for(int i=1; i<=n; i++){
                dp[i] = arr[i]+dp[i-1];
            }
            max = dp[n];
        }else{
            dp[1] = arr[1];
            dp[2] = arr[1] + arr[2];
            dp[3] = Math.max(Math.max(arr[1] + arr[3], dp[2]), Math.max(arr[2]+arr[3],dp[2]));
            for(int i=4; i<=n; i++)
                dp[i] = Math.max(Math.max(dp[i-3] + arr[i] + arr[i-1], dp[i-1]), Math.max(dp[i-2] + arr[i],dp[i-1]));

            for(int i=n; i>n-3; i--){
                max = Math.max(dp[i],max);
            }
        }



        System.out.println(max);
    }
}
