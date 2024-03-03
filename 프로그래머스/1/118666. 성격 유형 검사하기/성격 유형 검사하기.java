import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        String result = "";
        map.put('R',0);
        map.put('T',0);
        map.put('C',0);
        map.put('F',0);
        map.put('J',0);
        map.put('M',0);
        map.put('A',0);
        map.put('N',0);
        for(int i=0; i<survey.length; i++){
            String str1 = survey[i].substring(0,1);
            String str2 = survey[i].substring(1,2);
            int cho = choices[i];
            if(cho == 4){
                continue;
            }else if(cho<4){
                map.put(str1.charAt(0),map.get(str1.charAt(0))+4-cho);
            }else{
                map.put(str2.charAt(0),map.get(str2.charAt(0))+cho-4);
            }
        }
        result += (map.get('R') < map.get('T')) ? 'T' : 'R';
        result += (map.get('C') < map.get('F')) ? 'F' : 'C';
        result += (map.get('J') < map.get('M')) ? 'M' : 'J';
        result += (map.get('A') < map.get('N')) ? 'N' : 'A';
        String answer = result;
        return answer;
    }
}