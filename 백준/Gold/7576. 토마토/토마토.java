import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Math.min;

class Main {

    public static boolean[][] visited;
    public static int[][] arr;
    public static int[][] finish;
    public static Queue<int[]> que = new LinkedList<>();
    public static int n;
    public static int k;
    public static int[] chx = {-1,1,0,0};
    public static int[] chy = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] srr = br.readLine().split(" ");
        k = Integer.parseInt(srr[0]);
        n = Integer.parseInt(srr[1]);
        arr = new int[n][k];
        visited = new boolean[n][k];
        finish = new int[n][k];
        int startX=0;
        int startY=0;
        int turn=0;
        for (int i=0; i<n; i++){
            String[] srr2 = br.readLine().split(" ");
            for(int j=0; j<k; j++){
                arr[i][j] = Integer.parseInt(srr2[j]);
                if(arr[i][j]==1){
                    que.add(new int[]{i, j});
                    visited[i][j]=true;
                }
            }
        }
        bfs();
        int max=finish[0][0];
        for (int i=0; i<n; i++){
            for(int j=0; j<k; j++){
                if(!visited[i][j] && arr[i][j]!=-1){
                    max=-1;
                    break;
                }else if(max<finish[i][j]){
                    max=finish[i][j];
                }
            }
            if(max==-1){
                break;
            }
        }
        System.out.println(max);
    }
    public static void bfs(){
        while(!que.isEmpty()){
            int[] irr = que.poll();
            int x =irr[0];
            int y = irr[1];

            for(int i=0; i<4; i++){
                int newx=x+chx[i];
                int newy=y+chy[i];
                if(newx<0 || newx>n-1 || newy<0 || newy>k-1){
                    continue;
                }
                if(visited[newx][newy]){
                    continue;
                }
                visited[newx][newy]=true;
                if(arr[newx][newy]==-1){
                    continue;
                }
                finish[newx][newy] = finish[x][y]+1;
                que.add(new int[]{newx,newy});
            }
        }

    }

}
