class Solution {
    public int solution(String s) {
        String result="";
        int i = 0;
        while(i<s.length()){
            char a = s.charAt(i);
            if(a>='0' && a<='9'){
                result += a;
                i++;
            }else{
                if(a == 'z'){
                    result += '0';
                    i +=4;
                }else if(a == 'o'){
                    result += '1';
                    i +=3;
                }else if(a == 't'){
                    if(s.charAt(i+1) == 'w'){
                        result += '2';
                        i +=3;
                    }else{
                        result += '3';
                        i +=5;
                    }
                }else if(a == 'f'){
                    if(s.charAt(i+1) == 'o'){
                        result += '4';
                        i +=4;
                    }else{
                        result += '5';
                        i +=4;
                    }
                }else if(a == 's'){
                    if(s.charAt(i+1) == 'i'){
                        result += '6';
                        i +=3;
                    }else{
                        result += '7';
                        i +=5;
                    }
                }else if(a == 'e'){
                    result += '8';
                    i +=5;
                }else if(a == 'n'){
                    result += '9';
                    i +=4;
                }
            }
        }
        int answer = Integer.parseInt(result);
        return answer;
    }
}