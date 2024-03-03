import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> cut = new HashMap<>();
        List<String>[] list = new ArrayList[id_list.length]; 
        int[] result = new int[id_list.length];
        for(int i=0; i<id_list.length; i++){
            map.put(id_list[i],i);
            cut.put(id_list[i],0);
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<report.length; i++){
            String[] srr = report[i].split(" ");
            int a = map.get(srr[0]);
            if(!list[a].contains(srr[1])){
                list[a].add(srr[1]);
            }
        }
        for(int i=0; i<id_list.length; i++){
            for(int j=0; j<list[i].size(); j++){
                cut.put(list[i].get(j),cut.get(list[i].get(j))+1);
            }
        }
        for(int i=0; i<id_list.length; i++){
            int x = 0;
            for(int j=0; j<list[i].size(); j++){
                if(cut.get(list[i].get(j)) >= k){
                    x++;
                }
            }
            result[i] = x;
        }
        int[] answer = result;
        return answer;
    }
}