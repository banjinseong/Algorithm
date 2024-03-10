import java.io.*;

class Main {
    static int[][] arr;
    static int[][] homes = new int[1001][3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result;
        arr = new int[n][3];
        for(int i=0; i<n; i++){
            String[] srr = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(srr[0]);
            arr[i][1] = Integer.parseInt(srr[1]);
            arr[i][2] = Integer.parseInt(srr[2]);
        }
        for(int i=0; i<3; i++){
            homes[n-1][i] = arr[n-1][i];
        }
        for(int i=n-1; i>0; i--){
            for(int j=0; j<3; j++){
                for(int k=0; k<3; k++){
                    if(j==k){
                        continue;
                    }
                    if(homes[i-1][k]==0){
                        homes[i-1][k]=homes[i][j]+arr[i-1][k];
                    }else if(homes[i-1][k]>homes[i][j]+arr[i-1][k]){
                        homes[i-1][k]=homes[i][j]+arr[i-1][k];
                    }
                }
            }
        }
        result = Math.min(homes[0][0],homes[0][1]);
        result = Math.min(result,homes[0][2]);
        System.out.println(result);
    }

}
