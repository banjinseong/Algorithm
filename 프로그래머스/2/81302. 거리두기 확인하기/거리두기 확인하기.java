import java.util.*;
class Solution {
    int[] movX = {0,0,-1,1};
    int[] movY = {-1,1,0,0};
    public ArrayList<Integer> solution(String[][] places) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<places.length; i++){
            boolean chk = true;
            for(int j=0; j<5; j++){
                for(int c=0; c<5; c++){
                    if(places[i][j].charAt(c)=='P'){
                        chk = bfs(j,c,places[i]);
                    }
                    if(!chk){
                        break;
                    }
                }
                if(!chk){
                    break;
                }
            }
            if(!chk){
                answer.add(0);
            }else{
                answer.add(1);
            }
        }
        return answer;
    }
    
    public boolean bfs(int x, int y, String[] places){
        Queue<Pos> que = new LinkedList<>();
        que.add(new Pos(x,y,0));
        while(!que.isEmpty()){
            Pos pos = que.poll();
            int AA = pos.x;
            int BB = pos.y;
            for(int i=0; i<4; i++){
                int a = AA + movX[i];
                int b = BB + movY[i];
                if(a<0 || a>=5){
                    continue;
                }
                if(b<0 || b>=5){
                    continue;
                }
                if(a==x && b==y){
                    continue;
                }
                if(places[a].charAt(b)=='P'){
                    return false;
                }
                if(pos.cnt==1){
                    continue;
                }
                if(pos.cnt==0 && places[a].charAt(b)=='O'){
                    que.add(new Pos(a,b,pos.cnt+1));
                }
            }
        }
        return true;
    }
}

class Pos{
    int x;
    int y;
    int cnt;
    Pos(int x, int y, int cnt){
        this.x=x;
        this.y=y;
        this.cnt=cnt;
    }
}