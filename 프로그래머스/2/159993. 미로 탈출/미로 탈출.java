import java.util.*;
class Solution {
    int[][] visited;
    int[] movX = {0,0,-1,1};
    int[] movY = {-1,1,0,0};
    public int solution(String[] maps) {
        int answer = 0;
        Pos s = new Pos();
        Pos l = new Pos();
        Pos f = new Pos();
        
        for(int i=0; i<maps.length; i++){
            if(maps[i].contains("L")){
                l.x=i;
                l.y = maps[i].indexOf("L");
            }
            if(maps[i].contains("S")){
                s.x=i;
                s.y = maps[i].indexOf("S");
            }
            if(maps[i].contains("E")){
                f.x=i;
                f.y = maps[i].indexOf("E");
            }
        }
        visited = new int[maps.length][maps[0].length()];
        bfs(s.x,s.y,maps);
        if(visited[l.x][l.y] != 0){
            answer += visited[l.x][l.y];
        }else{
            answer = -1;
        }
        visited = new int[maps.length][maps[0].length()];
        bfs(l.x,l.y,maps);
        if(answer != -1 && visited[f.x][f.y] != 0){
            answer += visited[f.x][f.y];
        }else{
            answer = -1;
        } 
        return answer;
    }
    
    public void bfs(int x, int y, String[] map){
        Queue<Pos> que = new LinkedList<>();
        que.add(new Pos(x,y,0));
        while(!que.isEmpty()){
            Pos pos = que.poll();
            for(int i=0; i<4; i++){
                int a = pos.x + movX[i];
                int b = pos.y + movY[i];
                if(a<0 || a>=map.length){
                    a -= movX[i];
                }
                if(b<0 || b>=map[0].length()){
                    b -= movY[i];
                }
                if(map[a].charAt(b) != 'X'){
                    if(visited[a][b] == 0 || visited[a][b]>pos.count+1){
                        visited[a][b] = pos.count+1;
                        que.add(new Pos(a,b,pos.count+1));    
                    }
                }
            }
            
        }
    }
    
}

class Pos{
    int x;
    int y;
    int count;
    public Pos(){}
    public Pos(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}