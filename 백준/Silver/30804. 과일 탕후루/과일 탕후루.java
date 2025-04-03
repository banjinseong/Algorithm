import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] number = br.readLine().split(" ");

        int max = 0;
        int temp = 1;

        int[] record = new int[2];//최대2개
        int pev = Integer.parseInt(number[0]);
        int conn = 1; //연속된숫자.

        record[0] = Integer.parseInt(number[0]);



        for (int i = 1; i < n; i++) {
            int now = Integer.parseInt(number[i]);

            if(now != pev){
                if(record[1] == 0){
                    record[1] = now;
                    temp++;
                    conn = 1;
                    pev = now;
                }else{
                    if(record[0] != now && record[1] != now){
                        record[0] = pev;
                        record[1] = now;
                        if(max<temp){
                            max = temp;
                        }
                        temp = conn +1;
                        conn = 1;
                        pev = now;
                    }else{
                        temp++;
                        conn = 1;
                        pev = now;
                    }
                }
            }else{
                temp++;
                conn++;
            }
        }
        if(max<temp){
            max = temp;
        }
        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}

