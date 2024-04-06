import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long max = 0l;
        int[][] arr = new int[n+1][n+1];
        long[][] dp = new long[n+1][n+1];
        
        for(int i=1; i<=n; i++){
            String[] srr = br.readLine().split(" ");
            for(int j=1; j<=i; j++){
                arr[i][j] = Integer.parseInt(srr[j-1]);
            }
        }
        dp[1][1] = arr[1][1];
        
        for(int i=2; i<=n; i++){ 
            for(int j=1; j<=i; j++){
                dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + arr[i][j];
            }
        }
        
        for(int i=1; i<=n; i++){
            max = Math.max(dp[n][i],max);
        }
        
        
        
        
        System.out.println(max);
    }

}
