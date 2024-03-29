class Solution {
    public int solution(String[] board) {
        int answer = 0;
        int x = 0;
        int o = 0;
        int winx = 0;
        int wino = 0;
        for(int i=0; i<3; i++){
            if(board[i].equals("OOO")){
                wino++;
            }else if(board[i].equals("XXX")){
                winx++;
            }
            for(int j=0; j<3; j++){
                if(board[i].charAt(j) == 'O'){
                    o++;
                }else if(board[i].charAt(j) == 'X'){
                    x++;
                }
            }
        }
        if(board[0].charAt(0) == board[1].charAt(0) && board[0].charAt(0) == board[2].charAt(0)){
            if(board[0].charAt(0) == 'O'){
                wino++;
            }else if(board[0].charAt(0) == 'X'){
                winx++;
            }
        }if(board[0].charAt(1) == board[1].charAt(1) && board[0].charAt(1) == board[2].charAt(1)){
            if(board[0].charAt(1) == 'O'){
                wino++;
            }else if(board[0].charAt(1) == 'X'){
                winx++;
            }
        }if(board[0].charAt(2) == board[1].charAt(2) && board[0].charAt(2) == board[2].charAt(2)){
            if(board[0].charAt(2) == 'O'){
                wino++;
            }else if(board[0].charAt(2) == 'X'){
                winx++;
            }
        }
        if(board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2)){
            if(board[0].charAt(0) == 'O'){
                wino++;
            }else if(board[0].charAt(0) == 'X'){
                winx++;
            }
        }
        if(board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0)){
            if(board[0].charAt(2) == 'O'){
                wino++;
            }else if(board[0].charAt(2) == 'X'){
                winx++;
            }
        }
        if(o==x || o == x+1){
            if(wino>=1 && winx==0){
                if(o == x +1){
                    answer =1;
                }
            }else if(winx == 1 && wino ==0){
                if(o==x){
                    answer = 1;
                }
            }else if(wino ==0 && winx ==0){
                answer = 1;
            }
        }
        return answer;
    }
    
}