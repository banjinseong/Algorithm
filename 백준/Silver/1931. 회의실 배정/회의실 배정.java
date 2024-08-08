import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static HashMap<Integer,Integer> map = new HashMap<>();
    public static HashMap<Integer,Integer> map2 = new HashMap<>();
    public static int endTime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        endTime = 0;

        int temp = 0;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] srr = br.readLine().split(" ");
            int k = Integer.parseInt(srr[0]);
            int v = Integer.parseInt(srr[1]);

            if(endTime < k) {
                endTime = k;
            }
            if(k==v){
                if(map2.containsKey(k)){
                    map2.put(k,map2.get(k)+1);
                }else{
                    map2.put(k,1);
                }
                if(!map.containsKey(k)){
                    map.put(k,v);
                }
                continue;
            }
            if(!map.containsKey(k)){
                map.put(k, v);
            }else{
                if(map.get(k)==k){
                    map.put(k,v);
                }
                else if(map.get(k) > v){
                    map.put(k, v);
                }
            }
        }

        for (int i= 0; i<=endTime; i++) {
            if(map2.containsKey(i)){
                temp += map2.get(i);
            }
            if(map.containsKey(i)){
                boolean chk = true;
                for(int j = i+1; j <= map.get(i); j++){
                    if(map.containsKey(j)){
                        if( map.get(j) < map.get(i)){
                            i=j-1;
                            chk = false;
                            break;
                        }
                    }
                }
                if(!chk){
                    continue;
                }
                if(i==map.get(i)) {
                    i = map.get(i);
                }else{
                    i = map.get(i)-1;
                    temp++;
                }

            }
        }
        System.out.println(temp);
    }


}