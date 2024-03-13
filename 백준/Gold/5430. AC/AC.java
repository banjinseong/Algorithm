import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        continueLoop:
        for(int i=0; i<t; i++){
            boolean r = true;
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            String[] x = str.substring(1,str.length()-1).split(",");
            Deque<Integer> deck = new ArrayDeque<>();
            for(int j=0; j<n; j++){
                deck.add(Integer.parseInt(x[j]));
            }
            for(int j=0; j<p.length(); j++){
                char ch = p.charAt(j);
                try {
                    if(ch=='R'){
                        if(r){
                            r=false;
                        }else{
                            r=true;
                        }
                    }else{
                        if(r){
                            deck.removeFirst();
                        }else{
                            deck.removeLast();
                        }
                    }
                }catch (Exception e){
                    builder.append("error\n");
                    continue continueLoop;
                }
            }
            int c = deck.size();
            builder.append("[");
            if(r){
                for(int j=0; j<c; j++){
                    builder.append(String.valueOf(deck.pollFirst()));
                    if(j<c-1){
                        builder.append(",");
                    }
                }
            }else{
                for(int j=c-1; j>=0; j--){
                    builder.append(String.valueOf(deck.pollLast()));
                    if(j>0){
                        builder.append(",");
                    }
                }
            }
            builder.append("]\n");
        }
        System.out.println(builder);
    }
}
