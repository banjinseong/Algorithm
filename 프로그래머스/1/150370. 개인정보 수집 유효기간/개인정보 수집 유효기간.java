import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] todays = today.split("\\.");
        int year = Integer.parseInt(todays[0]);
        int month = Integer.parseInt(todays[1]);
        int day = Integer.parseInt(todays[2]);
        int i=1;
        String str = "";
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(String s : terms){
            String[] ss = s.split(" ");
            map.put(ss[0].charAt(0), Integer.parseInt(ss[1]));
        }
    
        for(String s : privacies){
            String[] ss = s.split(" ");
            String[] old = ss[0].split("\\.");
            int term = map.get(ss[1].charAt(0));
            int plusYear = Integer.parseInt(old[0]);
            int plusMonth = Integer.parseInt(old[1])+term;
            int plusDay = Integer.parseInt(old[2])-1;
            if(plusDay == 0){
                plusDay = 28;
                plusMonth -= 1;
            }
            while(plusMonth>12){
                plusMonth -= 12;
                plusYear += 1;
            }
            if(plusYear==year){
                if(plusMonth==month){
                    if(day>plusDay){
                        str += " "+i;
                    }
                }else if(month>plusMonth){
                    str += " "+i;
                }
            }else if(year>plusYear){
                str += " "+i;
            }
            i++;
        }
        String[] srr = str.split(" ");
        int[] arr = new int[srr.length-1];
        for(int j =1; j<srr.length; j++){
            arr[j-1] = Integer.parseInt(srr[j]);
        }
        int[] answer = arr;
        return answer;
    }
}