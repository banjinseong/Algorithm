import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


class Main {

    static int[][] visited;
    static int[][] count;
    static int[] movx = {1, -1, 0, 0};
    static int[] movy = {0, 0, -1, 1};
    static int[][] arr;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] srr = br.readLine().split(" ");
        int n = Integer.parseInt(srr[0]);
        int m = Integer.parseInt(srr[1]);

        visited = new int[n][m];
        arr = new int[n][m];
        count = new int[n][m];

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        q.add(new int[]{0, 0});
        visited[0][0] = 1;
        count[0][0] = 1;
        bfs(n,m);


        bw.write(String.valueOf(count[n-1][m-1]));
        bw.close();
        br.close();
    }

    static void bfs(int n, int m) {
        while(!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];

            for(int i = 0; i < 4; i++) {
                int newx= x + movx[i];
                int newy= y + movy[i];

                if(newx<0 || newx>=n || newy<0 || newy>=m){
                    continue;
                }
                if(arr[newx][newy] == 0){
                    continue;
                }
                if(visited[newx][newy] == 0){
                    visited[newx][newy] = 1;
                    count[newx][newy] = count[x][y] + 1;
                    q.add(new int[]{newx, newy});
                }else{
                    count[newx][newy] = Math.min(count[newx][newy], count[x][y] + 1);
                }

            }

        }

    }
}