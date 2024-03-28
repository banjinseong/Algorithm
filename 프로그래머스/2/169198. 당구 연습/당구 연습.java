class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer =new int[balls.length];
        
        for(int i=0; i<balls.length; i++){
            int min = Integer.MAX_VALUE;    

            min =Math.min(turnX(m,n,startX,startY,balls[i][0],balls[i][1]),
                          turnY(m,n,startX,startY,balls[i][0],balls[i][1]));

            answer[i] = min;
        }
        return answer;
    }
    public int turnX(int m, int n, int x1, int y1, int x2, int y2){
        int min = Integer.MAX_VALUE;
        if(x1==x2){
            if(y1>y2){
                min = Math.min(min, (n-y1+n-y2)*(n-y1+n-y2));
            }else{
                min = Math.min(min, (y1+y2) * (y1+y2));
            }
        }else{
            min = (n-y1+n-y2)*(n-y1+n-y2) + (x1-x2)*(x1-x2);
            min = Math.min(min,(y1+y2)*(y1+y2) + (x1-x2)*(x1-x2));
        }
        return min;
    }
    
    public int turnY(int m, int n, int x1, int y1, int x2, int y2){
        int min = Integer.MAX_VALUE;
        if(y1==y2){
            if(x1>x2){
                min = Math.min(min, (m-x1+m-x2)*(m-x1+m-x2));
            }else{
                min = Math.min(min, (x1+x2) * (x1+x2));
            }
        }else{
            min = (m-x1+m-x2)*(m-x1+m-x2) + (y1-y2)*(y1-y2);
            min = Math.min(min,(x1+x2)*(x1+x2) + (y1-y2)*(y1-y2));
        }
        return min;
    }
}