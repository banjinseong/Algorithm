import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max=0;
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        String[] srr = br.readLine().split(" ");
        
        for(int i=1; i<=n; i++){
            arr[i]= Integer.parseInt(srr[i-1]);     
        }
        
        
        for(int i=1; i<=n; i++){
            dp[i] = 1;
            for(int j=1; j<i; j++){
                if(arr[j]<arr[i] && dp[i]<dp[j]+1){
                    dp[i] = dp[j]+1;
                }
            }
        }
        
        for(int i=1; i<=n; i++){
            max = Math.max(dp[i],max);
        }
        

        System.out.println(max);
    }

}
