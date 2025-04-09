import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class Main {

    public static char[][] origin;
    public static int[][] visited;
    public static int[] movX = {-1,1,0,0};
    public static int[] movY = {0,0,-1,1};
    public static Stack<int[]> stack = new Stack<>();
    public static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);


        origin = new char[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s1 = br.readLine();
            for (int j = 0; j < m; j++) {
                origin[i][j] = s1.charAt(j);
                if(origin[i][j] == 'I'){
                    visited[i][j] = 1;
                    stack.push(new int[]{i,j});
                }
            }
        }
        dfs();
        if(result>0){
            bw.write(String.valueOf(result));
        }else{
            bw.write("TT");
        }
        bw.flush();
        bw.close();
    }


    public static void dfs() {
        int[] pop = stack.pop();
        int x = pop[0];
        int y = pop[1];

        for (int i = 0; i < 4; i++) {
            int newX = x + movX[i];
            int newY = y + movY[i];
            if(newX >= visited.length || newX < 0 || newY >= visited[0].length || newY < 0 || visited[newX][newY] == 1 || origin[newX][newY] == 'X'){
                continue;
            }
            if(origin[newX][newY] == 'P'){
                result++;
            }
            visited[newX][newY] = 1;
            stack.push(new int[]{newX,newY});
            dfs();
        }

    }
}

