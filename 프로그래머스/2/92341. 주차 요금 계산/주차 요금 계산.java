import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Integer> time = new HashMap<>();
        List<String> list = new ArrayList<>();
        int[] arr;
        for(int i=0; i<records.length; i++){
            String[] srr = records[i].split(" ");
            if(srr[2].equals("IN")){
                if(!map.containsKey(srr[1])){
                    list.add(srr[1]);
                }
                map.put(srr[1],srr[0]);
            }else{
                String[] end = srr[0].split(":");
                String[] start = map.get(srr[1]).split(":");
                map.put(srr[1],"0");
                int endTime = Integer.parseInt(end[0])*60 + Integer.parseInt(end[1]);
                int startTime = Integer.parseInt(start[0])*60 + Integer.parseInt(start[1]);
                int using = endTime - startTime;
                if(!time.containsKey(srr[1])){
                    time.put(srr[1],using);
                }else{
                    time.put(srr[1],time.get(srr[1]) + using);
                }
                
            }
        }
        Collections.sort(list);
        arr = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            String str = list.get(i);
            if(!map.get(str).equals("0")){
                String[] start = map.get(str).split(":");
                int endTime = 23*60 + 59;
                int startTime = Integer.parseInt(start[0])*60 + Integer.parseInt(start[1]);
                int using = endTime - startTime;
                if(!time.containsKey(str)){
                    time.put(str,using);
                }else{
                    time.put(str,time.get(str) + using);
                }
            }
            if(time.get(str)<fees[0]){
                arr[i] = fees[1];
            }else{
                arr[i] = fees[1] + (int)Math.ceil((time.get(str)-fees[0])/(double)fees[2])*fees[3];
            }
        }
        
        return arr;
    }
}