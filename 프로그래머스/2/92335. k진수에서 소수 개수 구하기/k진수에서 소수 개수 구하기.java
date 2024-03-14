class Solution {
    public int solution(int n, int k) {
        String str = "0";
        String temp = "";
        int answer = 0;
        if(k==10){
            str = n+"0";
            for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '0'){
                if(!temp.isEmpty()){
                    Long a = Long.parseLong(temp);
                    temp = "";
                    boolean chk = false;
                    for(int j=2; j<=Math.sqrt(a); j++){
                        if(a%j==0){
                            chk = true;
                            break;
                        }
                    }
                    if(!chk && a!=1){
                        answer++;
                    }
                }
            }else{
                temp += str.charAt(i);
            }
        }
        }else{
            while(n>0){
                if(n<k){
                    str += n;
                    break;
                }

                str += "" + n%k;
                n = n/k;
            }
            for(int i= str.length()-1; i>=0; i--){
            if(str.charAt(i) == '0'){
                if(!temp.isEmpty()){
                    Long a = Long.parseLong(temp);
                    temp = "";
                    boolean chk = false;
                    for(int j=2; j<=Math.sqrt(a); j++){
                        if(a%j==0){
                            chk = true;
                            break;
                        }
                    }
                    if(!chk && a!=1){
                        answer++;
                    }
                }
            }else{
                temp += str.charAt(i);
            }
        }
        }
        
        
        return answer;
    }
}