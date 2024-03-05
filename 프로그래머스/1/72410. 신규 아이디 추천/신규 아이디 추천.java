class Solution {
    public String solution(String new_id) {
        boolean chk = false;
        int i = 0;
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^a-z0-9-_.]" , "");
        while(i<new_id.length()-1){
            if(new_id.charAt(i) == '.'){
                chk=true;
                int j = i;
                if(i==new_id.length()-1){
                    chk = false;
                }else{
                    j++;
                }
                
                while(chk && j<=new_id.length()-1){
                    if(new_id.charAt(j) != '.'){
                        chk = false;
                    }else{
                        j++;
                    }
                    
                }
                new_id = new_id.substring(0,i) + new_id.substring(j-1);
            }
            i++;
        }
        if(new_id.charAt(0) == '.'){
            new_id = new_id.substring(1);
        }
        if(new_id.length()>0 && new_id.charAt(new_id.length()-1) == '.'){
            new_id = new_id.substring(0,new_id.length()-1);
        }
        if(new_id.isEmpty()){
            new_id = "aaa";
        }
        if(new_id.length()>=16){
            new_id = new_id.substring(0,15);
            if(new_id.charAt(new_id.length()-1) == '.'){
            new_id = new_id.substring(0,new_id.length()-1);
            }
        }
        while(new_id.length()<=2){
            new_id = new_id + new_id.charAt(new_id.length()-1);
        }
        String answer = new_id;
        return answer;
    }
}