import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[][] arr;
    public static int blue=0;
    public static int white=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }
        chkPaper(0,N-1,0,N-1);
        sb.append(white).append("\n").append(blue);
        System.out.println(sb);
    }

    public static void chkPaper(int x1, int x2, int y1, int y2){
        boolean chk = true;
        int t = arr[x1][y1];
        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                if(t!=arr[i][j] || !chk) {
                    chk = false;
                    break;
                }
            }
        }

        if(!chk){
            chkPaper(x1, (x1+x2)/2, y1, (y1+y2)/2);
            chkPaper(x1, (x1+x2)/2, (y1+y2)/2+1, y2);
            chkPaper((x1+x2)/2+1, x2 , y1, (y1+y2)/2);
            chkPaper((x1+x2)/2+1, x2 , (y1+y2)/2+1, y2);

        } else if (t == 0) {
            white++;
        }else{
            blue++;
        }
    }
}