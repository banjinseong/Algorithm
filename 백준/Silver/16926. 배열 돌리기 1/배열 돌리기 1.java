import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] srr = br.readLine().split(" ");
        int n = Integer.parseInt(srr[0]);
        int m = Integer.parseInt(srr[1]);
        int r = Integer.parseInt(srr[2]);
        int[][] arr = new int[n][m];
        int cnt;
        if(Math.min(n,m)%2==0){
            cnt = Math.min(n,m)/2;
        }else{
            cnt = Math.min(n,m)/2 +1;
        }
        int temp = 0;
        for(int i=0; i<n; i++){
            String[] srr2 = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(srr2[j]);
            }
        }
        for(int c=0; c<r; c++){
            for(int i=0; i<cnt; i++){
                int a = i;
                int b = i;
                int temp2;
                temp = arr[a][b];

                a++;
                while(a<n-i){
                    temp2 = arr[a][b];
                    arr[a][b] = temp;
                    temp = temp2;
                    a++;
                }
                a--;

                b++;
                while(b<m-i){
                    temp2 = arr[a][b];
                    arr[a][b] = temp;
                    temp = temp2;
                    b++;
                }
                b--;

                a--;
                while(a>=i){
                    temp2 = arr[a][b];
                    arr[a][b] = temp;
                    temp = temp2;
                    a--;
                }
                a++;
                b--;
                while(b>=i){
                    temp2 = arr[a][b];
                    arr[a][b] = temp;
                    temp = temp2;
                    b--;
                }
            }
        }


        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
