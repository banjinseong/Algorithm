import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<name.length; i++){
            map.put(name[i], yearning[i]);
        }
        int[] arr = new int[photo.length];
        for(int i=0; i<photo.length; i++){
            for(int j=0; j<photo[i].length; j++){
                if(map.get(photo[i][j]) != null){
                    arr[i] +=map.get(photo[i][j]);
                }
            }
        }
        int[] answer = arr;
        return answer;
    }
}