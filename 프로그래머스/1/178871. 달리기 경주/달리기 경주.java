import java.util.HashMap;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int i = 0;
        for(String str : players){
            map.put(str, i);
            i++;
        }
        for(String str : callings){
            int ch = map.get(str);
            String temp = players[ch-1];
            players[ch] = temp;
            players[ch-1] = str;
            map.put(str,ch-1);
            map.put(temp, ch);
        }
        String[] answer = players;
        return answer;
    }
}