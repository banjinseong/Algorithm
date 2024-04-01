import java.util.*;
class Solution {
    boolean[][] visited;
    int[] movX = {0,0,-1,1};
    int[] movY = {-1,1,0,0};
    public ArrayList<Integer> solution(String[] maps) {
        ArrayList<Integer> answer = new ArrayList<>();
        visited = new boolean[maps.length][maps[0].length()];
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                int a = bfs(i,j,maps);
                if(a != 0){
                    answer.add(a);
                }
            }
        }
        if(answer.size() == 0){
            answer.add(-1);
        }else{
            Collections.sort(answer);
        }
        return answer;
    }
    
    public int bfs(int x, int y, String[] maps){
        if(visited[x][y] || maps[x].charAt(y) == 'X'){
            visited[x][y] = true;
            return 0;
        }
        int total= maps[x].charAt(y) - '0';
        visited[x][y] = true;
        Queue<Pos> que = new LinkedList<>();
        que.add(new Pos(x,y));
        while(!que.isEmpty()){
            Pos pos = que.poll();
            for(int i=0; i<4; i++){
                int a = pos.x + movX[i];
                int b = pos.y + movY[i];
                if(a<0 || a>= maps.length){
                    continue;
                }
                if(b<0 || b>= maps[0].length()){
                    continue;
                }
                if(maps[a].charAt(b) == 'X'){
                    visited[a][b]=true;
                    continue;
                }
                if(!visited[a][b]){
                    visited[a][b] = true;
                    total += maps[a].charAt(b) - '0';
                    que.add(new Pos(a,b));
                }
            }
        }
        return total;
    }
    
}

class Pos{
    int x;
    int y;
    public Pos(){}
    public Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}