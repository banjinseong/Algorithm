import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] arr = new int[book_time.length][2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<book_time.length; i++){
            int a = Integer.parseInt(book_time[i][0].substring(0,2)) * 60;
            int b = Integer.parseInt(book_time[i][0].substring(3));
            arr[i][0] = a+b;
            
            int c = Integer.parseInt(book_time[i][1].substring(0,2)) * 60;
            int d = Integer.parseInt(book_time[i][1].substring(3));
            arr[i][1] = c+d+10;
        }
        Arrays.sort(arr, (o1, o2) ->{
            return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
        });
        map.put(0,arr[0][1]);
        
        answer++;
        for(int i=1; i<arr.length; i++){
            for(int j=0; j<=map.size(); j++){
                if(j==map.size()){
                    map.put(j,arr[i][1]);
                    answer++;
                    break;
                }
                if(map.get(j)<= arr[i][0]){
                    map.put(j,arr[i][1]);
                    break;
                }
            }
        }
        return answer;
    }
}