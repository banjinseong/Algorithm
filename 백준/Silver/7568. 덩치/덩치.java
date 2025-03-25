import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++){
            String[] srr = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(srr[0]);
            arr[i][1] = Integer.parseInt(srr[1]);
        }
        for(int i=0; i<n; i++){
            int rank =1;
            for(int j=0; j<n; j++){
                if(arr[i][0]<arr[j][0]) {
                    if (arr[i][1] < arr[j][1]) {
                        rank++;
                    }
                }
            }
            System.out.print(rank + " ");
        }
    }
}
