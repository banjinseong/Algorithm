import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int q =0;
        for(String str : friends){
            map.put(str,q);
            q++;
        }
        int[][] arr = new int[friends.length][friends.length];
        int[] point = new int[friends.length];
        int[] result = new int[friends.length];
        for(String str : gifts){
            String[] srr = str.split(" ");
            int a = map.get(srr[0]);
            int b = map.get(srr[1]);
            arr[a][b]++;
            point[a]++;
            point[b]--;
        }
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr[i].length; j++){
                if(arr[i][j]>arr[j][i]){
                    result[i]++;
                }else if(arr[i][j]<arr[j][i]){
                    result[j]++;
                }else{
                    if(point[i]>point[j]){
                        result[i]++;
                    }else if(point[i]<point[j]){
                        result[j]++;
                    }
                }
            }
        }
        int max = 0;
        for(int c : result){
            if(c>max){
                max=c;
            }
        }
        int answer = max;
        return answer;
    }
}