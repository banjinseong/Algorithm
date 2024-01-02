import java.io.*;
import java.util.*;


class Main {

  public static boolean[] visitedDfs;
  public static boolean[] visitedBfs;
  public static ArrayList<Integer>[] list;
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] srr = br.readLine().split(" ");
    int n = Integer.parseInt(srr[0]);
    int k = Integer.parseInt(srr[1]);
    int start = Integer.parseInt(srr[2]);
    visitedDfs = new boolean[n+1];
    visitedBfs = new boolean[n+1];
    list = new ArrayList[n+1];
    for(int i=0; i<=n; i++){
        list[i] = new ArrayList<>();
    }
    for (int i=0; i<k; i++){
        String[] arr = br.readLine().split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        list[a].add(b);
        list[b].add(a);
    }
    for(int i=1; i<=n; i++){
      Collections.sort(list[i]);
    }
    visitedDfs[start] = true;
    visitedBfs[start] = true;
    System.out.print(start+" ");
    dfs(start);
    System.out.print("\n"+start+" ");
    bfs(start);
  }

  public static void dfs(int start){
    Stack<Integer> stack = new Stack<>();
    stack.push(start);  
    while(stack.size()!=0){
      int n = stack.peek();
      boolean node = false;
      for(int i:list[n]){
        if(visitedDfs[i]==false){
          node=true;
          stack.push(i);
          visitedDfs[i]=true;
          System.out.print(i+" ");
          break;
        }
      }
      if(!node){
        stack.pop();
      }
    }
  }

  public static void bfs(int start){
    Queue<Integer> q = new LinkedList<>();
    q.add(start);
    while(q.size()!=0){
      int a = q.poll();
      for(int i: list[a]){
        if(visitedBfs[i] == false){
          visitedBfs[i] = true;
          System.out.print(i+" ");
          q.add(i);
        }
      }
    }
  }
}