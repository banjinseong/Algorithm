class Solution {
    public int[] solution(String[] park, String[] routes) {
        char[][] park2 = new char[park.length][park[0].length()];
        int x=0;
        int y=0;
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[0].length(); j++){
                park2[i][j] = park[i].charAt(j);
                if(park2[i][j] == 'S'){
                    x=i;
                    y=j;
                }
            }
        }
        for(int i=0; i<routes.length; i++){
            String[] srr = routes[i].split(" ");
            int a=x;
            int b=y;
            if(srr[0].equals("N")){
                for(int j=0; j<Integer.parseInt(srr[1]); j++){
                    if(x-1 >= 0 && park2[x-1][y] == 'O'){
                        x -= 1;
                    }else{
                        x += j;
                        break;
                    }
                }
                park2[a][b] = 'O';
                park2[x][y] = 'S';
            }else if(srr[0].equals("S")){
                for(int j=0; j<Integer.parseInt(srr[1]); j++){
                    if(x+1 <park2.length && park2[x+1][y] == 'O'){
                        x += 1;
                    }else{
                        x -= j;
                        break;
                    }
                }
                park2[a][b] = 'O';
                park2[x][y] = 'S';
            }else if(srr[0].equals("W")){
                for(int j=0; j<Integer.parseInt(srr[1]); j++){
                    if(y-1 >= 0 && park2[x][y-1] == 'O'){
                        y -= 1;
                    }else{
                        y += j;
                        break;
                    }
                }
                park2[a][b] = 'O';
                park2[x][y] = 'S';
            }else{
                for(int j=0; j<Integer.parseInt(srr[1]); j++){
                    if(y+1 < park2[0].length && park2[x][y+1] == 'O'){
                        y += 1;
                    }else{
                        y -= j;
                        break;
                    }
                }
                park2[a][b] = 'O';
                park2[x][y] = 'S';
            }
        }
        int[] answer = {x,y};
        return answer;
    }
}