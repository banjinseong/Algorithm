import java.io.*;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+2];
        arr[1] = 1;
        arr[2] = 3;
        for (int i = 3; i <=n; i++) {
            if(i%2==0){
                arr[i] = (arr[i-1]*2 + 1)%10007;    
            }else{
                arr[i] = (arr[i-1]*2 - 1)%10007;
            }
            
        }
        System.out.println(arr[n]);
    }

}
