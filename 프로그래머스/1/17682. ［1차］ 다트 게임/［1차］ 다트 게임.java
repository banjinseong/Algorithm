class Solution {
    public int solution(String dartResult) {
        int total = 0;
        int back = 0;
        int now = 0;
        String num = "";
        int n = 0;
        for(int i=0; i<dartResult.length(); i++){
            if(dartResult.charAt(i)>='0'&&dartResult.charAt(i)<='9'){
                if(dartResult.charAt(i+1)=='0'){
                   num += dartResult.charAt(i);
                    continue;
                }
                total += back;
                back=now;
                num += dartResult.charAt(i);

            }else{
                if(!num.equals("")){
                    n = Integer.parseInt(num);
                    num="";
                }
                
                if(dartResult.charAt(i)=='S'){
                    now = n;
                }else if(dartResult.charAt(i)=='D'){
                    now = n*n;
                }else if(dartResult.charAt(i)=='T'){
                    now = n*n*n;
                }else if(dartResult.charAt(i)=='*'){
                    back *=2;
                    now *=2;
                }else{
                    now *= -1;
                }
            }
        }
        
        int answer = total+back+now;
        return answer;
    }
}