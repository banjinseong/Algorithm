import java.util.*;
class Solution {
    int[][] visited;
    int[] movX = {0, 0, -1, 1};
    int[] movY = {-1, 1, 0, 0};
    public int solution(String[] board) {
        int answer = 0;
        visited = new int[board.length][board[0].length()];
        int x = -1, y=0;
        for(int i=0; i<board.length; i++){
            if(x != -1){
                break;
            }
            for(int j=0; j<board[0].length(); j++){
                if(board[i].charAt(j)=='R'){
                    x=i;
                    y=j;
                    break;
                }
            }
        }
        Pos pos = bfs(x,y,board);
        if(pos.count == 0){
            answer = -1;
        }else{
            answer = pos.count;
        }
        return answer;
    }
    
    public Pos bfs(int x, int y, String[] board){
        Pos clr = new Pos();
        Queue<Pos> que = new LinkedList<>();
        que.add(new Pos(x,y, 0));
        while(!que.isEmpty()){
            Pos pos = que.poll();
            int a = pos.x;
            int b = pos.y;
            for(int i=0; i<4; i++){
                int tempA = a;
                int tempB = b;
                while(true){
                    tempA += movX[i];
                    tempB += movY[i];
                    if(tempA<0 || tempA>=board.length){
                        tempA -= movX[i];
                        tempB -= movY[i];
                        if(visited[tempA][tempB] == 0 || visited[tempA][tempB] > (pos.count+1) ){
                            visited[tempA][tempB] = pos.count + 1;
                            if(board[tempA].charAt(tempB)=='G'){
                                clr.x=tempA;
                                clr.y=tempB;
                                clr.count = pos.count+1;
                                break;
                            }
                            que.add(new Pos(tempA, tempB, pos.count+1));
                        }
                        break;
                    }
                    if(tempB<0 || tempB>=board[0].length()){
                        tempA -= movX[i];
                        tempB -= movY[i];
                        if(visited[tempA][tempB] == 0 || visited[tempA][tempB] > (pos.count+1) ){
                            visited[tempA][tempB] = pos.count + 1;
                            if(board[tempA].charAt(tempB)=='G'){
                                clr.x=tempA;
                                clr.y=tempB;
                                clr.count = pos.count+1;
                                break;
                            }
                            que.add(new Pos(tempA, tempB, pos.count+1));
                        }
                        break;
                    }
                    if(board[tempA].charAt(tempB)=='D'){
                        tempA -= movX[i];
                        tempB -= movY[i];
                        if(visited[tempA][tempB] == 0 || visited[tempA][tempB] > (pos.count+1) ){
                            visited[tempA][tempB] = pos.count + 1;
                            if(board[tempA].charAt(tempB)=='G'){
                                clr.x=tempA;
                                clr.y=tempB;
                                clr.count = pos.count+1;
                                break;
                            }
                            que.add(new Pos(tempA, tempB, pos.count+1));
                        }
                        break;
                    }
                }
            }
        }
        return clr;
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