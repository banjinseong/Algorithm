import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long max;
        int[] arr = new int[n+1];
        long[] dp = new long[n+1];
        String[] srr = br.readLine().split(" ");
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(srr[i-1]);
        }
        dp[1] = arr[1];
        max = dp[1];
        for(int i=2; i<=n; i++){
            dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
        }
        for(int i=1; i<=n; i++){
            max = Math.max(max,dp[i]);
        }
        
        
        
        System.out.println(max);
    }

}
