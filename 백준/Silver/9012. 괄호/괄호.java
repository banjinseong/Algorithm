import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<t; i++){
            int start=0;
            String str = br.readLine();
            if(str.charAt(0) == ')'){
                builder.append("NO\n");
                continue;
            }
            for(int j=0; j<str.length(); j++){
                if(str.charAt(j) == '('){
                    start++;
                }else{
                    start--;
                }
                if(start<0){
                    builder.append("NO\n");
                    break;
                }
            }
            if(start == 0){
                builder.append("YES\n");
            }else if (start>0){
                builder.append("NO\n");
            }
        }
        System.out.println(builder);
    }
}
