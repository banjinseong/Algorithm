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
        Arrays.sort(arr, (a1,a2) ->{
            if(a1[1]==a2[1]){
                return a1[0] - a2[0];
            }else{
                return a1[1] - a2[1];
            }
        });
        for(int i=0; i<n; i++){
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}
