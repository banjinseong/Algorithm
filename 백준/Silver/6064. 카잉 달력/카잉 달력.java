import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int x = Integer.parseInt(s[2]);
            int y = Integer.parseInt(s[3]);

            int tempY = x % m == 0 ? m : x % m;

            int count = x;
            boolean exist = false;

            int re;
            if(n%2==0 && m%2==0){
                re = m / 2;
            }else{
                re = m;
            }

            for(int j = 0; j < re; j++){
                if(tempY == y){
                    exist = true;
                    break;
                }
                tempY = (tempY+n) % m == 0 ? m : (tempY+n) % m;
                count += n;

            }

            bw.write(exist ? String.valueOf(count) : "-1");
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}

