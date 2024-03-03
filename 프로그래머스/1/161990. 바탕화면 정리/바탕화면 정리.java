class Solution {
    public int[] solution(String[] wallpaper) {
        int x1=wallpaper[0].length(), x2=0, y1=wallpaper.length, y2=0;
        for(int i=0; i<wallpaper.length; i++){
            for(int j=0; j<wallpaper[0].length(); j++){
                char a = wallpaper[i].charAt(j);
                if(a == '#'){
                    if(x1>j){
                        x1=j;
                    }
                    if(x2<j+1){
                        x2=j+1;
                    }
                    if(y1>i){
                        y1=i;
                    }
                    if(y2<i+1){
                        y2=i+1;
                    }
                }
            }
        }
        int[] answer = {y1,x1,y2,x2};
        return answer;
    }
}