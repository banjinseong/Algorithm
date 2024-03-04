class Solution {
    public int[] solution(int N, int[] stages) {
        double[] drr = new double[N];
        int[] arr = new int[N];
        int clear = stages.length;
        for(int i=0; i<N; i++){
            double fail = 0;
            for(int j=0; j<stages.length; j++){
                if(stages[j]==i+1){
                    fail++;
                }
            }
            drr[i] = fail/clear;
            clear -= fail;
        }
        arr[N-1] = N;
        for(int i=N-2; i>=0; i--){
            arr[i] = i+1;
            for(int j=i; j<N-1; j++){
                if(drr[arr[j]-1]<drr[arr[j+1]-1]){
                    int temp = arr[j+1];
                    arr[j+1] = i+1;
                    arr[j] = temp;
                }
            }
        }
        int[] answer = arr;
        return answer;
    }
}