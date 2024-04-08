import java.io.*;

class Main {
    static long[] arr = new long[100];
    static int temp = 4;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long answer = 0l;
        int[][] arr = new int[n+1][2];
        int[] dp = new int[n+2];
        for(int i=1; i<=n; i++){
            String[] srr = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(srr[0]);
            arr[i][1] = Integer.parseInt(srr[1]);
        }

        for(int i=1; i<=n; i++){
            int t = arr[i][0];
            int p = arr[i][1];
            int max = 0;
            if(i+t>n+1){
                continue;
            }
            for(int j=2; j<=i; j++){
                max = Math.max(dp[j], max);
            }
            dp[i+t] = Math.max(max + p,dp[i+t]);

        }
        for(int i=1; i<=n+1; i++){
            answer = Math.max(dp[i],answer);
        }

        System.out.println(answer);
    }

}
