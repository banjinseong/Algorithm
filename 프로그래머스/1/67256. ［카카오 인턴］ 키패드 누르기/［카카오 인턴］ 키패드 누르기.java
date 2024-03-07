class Solution {
    public String solution(int[] numbers, String hand) {
        int[] left = {3,0};
        int[] right = {3,2};
        String result= "";
        for(int i=0; i<numbers.length; i++){
            int shiftLeft=0;
            int shiftRight=0;
            int[] arr = new int[2];
            if(numbers[i]%3==1){
                left[0]=numbers[i]/3;
                left[1]=0;
                result +="L";
            }else if(numbers[i] == 0 || numbers[i]%3==2){
                arr[0]=numbers[i]/3;
                if(numbers[i]==0){
                    arr[0]=3;
                }
                arr[1]=1;
                shiftLeft = Math.abs(left[0]-arr[0])+Math.abs(left[1]-arr[1]);
                shiftRight = Math.abs(right[0]-arr[0])+Math.abs(right[1]-arr[1]);
                if(shiftLeft==shiftRight){
                    if(hand.equals("right")){
                        right[0] = arr[0];
                        right[1] = arr[1];
                        result +="R";
                    }else{
                        left[0] = arr[0];
                        left[1] = arr[1];
                        result +="L";
                    }
                }else if(shiftLeft<shiftRight){
                    left[0] = arr[0];
                    left[1] = arr[1];
                    result +="L";
                }else{
                    right[0] = arr[0];
                    right[1] = arr[1];
                    result +="R";
                }
            }else{
                right[0]=(numbers[i]-1)/3;
                right[1]=2;
                result +="R";
            }
            
        }
        String answer = result;
        return answer;
    }
}