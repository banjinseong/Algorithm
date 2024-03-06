import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] srr = br.readLine().split(" ");
        boolean chk = false;
        int a = Integer.parseInt(srr[0]);
        int b = Integer.parseInt(srr[1]);
        int c = Integer.parseInt(srr[2]);
        int d = Integer.parseInt(srr[3]);
        int e = Integer.parseInt(srr[4]);
        int f = Integer.parseInt(srr[5]);
        for(int i=-999; i<1000; i++){
            if(chk == true){
                break;
            }
            for(int j=-999; j<1000; j++){
                if(a*i + b*j == c && d*i + e*j == f){
                    chk = true;
                    System.out.print(i + " " + j);
                    break;
                }
            }
        }
    }
}
