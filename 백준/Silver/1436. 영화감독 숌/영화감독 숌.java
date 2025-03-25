import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String set = "666";
        int i=666;
        int temp=0;
        while(true){
            String j = String.valueOf(i);
            if(j.contains(set)){
                temp++;
                if(temp==n){
                    break;
                }
            }
            i++;
        }
        System.out.println(i);
    }
}
