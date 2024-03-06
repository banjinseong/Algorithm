import java.io.*;
import java.util.*;

class Main {
    static int[] arr;
    static int n,c;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] srr = br.readLine().split(" ");
        n = Integer.parseInt(srr[0]);
        c = Integer.parseInt(srr[1]);
        int left, right, mid;
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());

        }
        Arrays.sort(arr);
        left=0;
        right=arr[n-1];
        if(c==2){
            left = right-arr[0]+1;
            right=0;
        }
        while(left<right){
            mid = (right+left)/2;
            if(c <= clen(mid)){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        System.out.println(left-1);
    }

    static int clen(int len){
        int a = 0;
        int b = 0;
        int chk = 1;
        while(b<n){
            if(arr[b] -arr[a] >= len){
                a = b++;
                chk++;
            }else{
                b++;
            }
        }

        return chk;
    }

}
