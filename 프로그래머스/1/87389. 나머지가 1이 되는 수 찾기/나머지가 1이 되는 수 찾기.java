class Solution {
    public int solution(int n) {
        int result = 0;
        for(int i=1; i<n; i++){
            if(n%i == 1){
                result=i;
                break;
            }
        }
        int answer = result;
        return answer;
    }
}