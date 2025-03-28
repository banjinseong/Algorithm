import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] number = br.readLine().split(" ");
        int begin = Integer.parseInt(number[0]);
        int end = Integer.parseInt(number[1]);
        int cnt=0;

        for (int i = begin; i <= end; i++) {
            if(i!=2 && i%2==0){
                continue;
            }
            for(int j = 1; j <= Math.sqrt(i); j+=2) {
                if(j!=1 && i%j==0){
                    cnt++;
                    break;
                }
            }
            if(i!=1 && cnt==0){
                bw.write(i+"\n");
            }
            cnt =0;
        }
        bw.flush();
        bw.close();
    }
}

