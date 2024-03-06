import java.io.*;
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] srr1 = bf.readLine().split(" ");
        String[] srr2 = bf.readLine().split(" ");
        int n = Integer.parseInt(srr1[0]);
        int minM = Integer.parseInt(srr1[1]);
        Long takeM = 0l;
        int right=0, left=0;
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(srr2[i]);
            if(right<arr[i]) {
                right = arr[i];
            }
        }

        while(left<right){
            int mid = (right+left)/2;
            takeM=0l;
            for(int i=0; i<n; i++){
                if(arr[i]-mid>0){
                    takeM += arr[i]-mid;
                }
            }

            if(takeM>=minM){
                left = mid+1;
            }else{
                right = mid;
            }


        }
        System.out.println(left-1);


    }
}