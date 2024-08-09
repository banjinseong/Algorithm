import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[] visited = new int[1000010];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
        int min = 100003;
        Queue<Integer> q = new LinkedList<>();
        String[] srr = br.readLine().split(" ");
        int s = Integer.parseInt(srr[0]);
        int e = Integer.parseInt(srr[1]);
        visited[e] = 100003;
        visited[s] = 1;
        q.add(s);
        if(s>=e){
            min = s-e;
            visited[e] = min+1;
            q.clear();
        }
        while(!q.isEmpty()){
            int poll = q.poll();
            if(visited[poll]>=min){
                continue;
            }
            if(poll >= 1){
                if(visited[poll-1]==0){
                    visited[poll-1] = visited[poll] + 1;
                    q.add(poll-1);
                }else if(visited[poll-1]>visited[poll]+1){
                    visited[poll-1] = visited[poll] + 1;
                    q.add(poll-1);
                }
            }

            if(visited[poll+1]==0){
                visited[poll+1] = visited[poll] + 1;
                q.add(poll+1);
            }else if(visited[poll+1]>visited[poll]+1){
                visited[poll+1] = visited[poll] + 1;
                q.add(poll+1);
            }
            if(poll*2<=100000){
                if(visited[poll*2]==0){
                    visited[poll*2] = visited[poll] + 1;
                    q.add(poll*2);
                }else if(visited[poll*2]>visited[poll]+1){
                    visited[poll*2] = visited[poll] + 1;
                    q.add(poll*2);
                }
            }



            if(poll-1 == e){
                min = Integer.min(min, visited[poll-1]);
            }
            if(poll+1 == e){
                min = Integer.min(min, visited[poll+1]);
            }
            if(poll*2 == e){
                min = Integer.min(min, visited[poll*2]);
            }

        }


        System.out.println(visited[e]-1);
    }


}