import java.io.*;
class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
    long total = 0, maxR,result=0;
    String[] srr = bf.readLine().split(" ");
    int n = Integer.parseInt(srr[0]);
    int rep = Integer.parseInt(srr[1]);
    int[] arr = new int[n];
    for(int i=0; i<n; i++){
      arr[i] = Integer.parseInt(bf.readLine());
      total += arr[i];
    }
    maxR = total/rep;
    long tempR = maxR;
    while(maxR != 0){
      int ren =0;
      for(int i=0; i<n; i++){
        ren += arr[i]/tempR;
      }
      if(maxR != 1){
        maxR = maxR/2 + maxR%2;
      }else{
        maxR = maxR/2;
      }
      if(ren>=rep){
        if(tempR>result){
          result = tempR;
        }
        tempR += maxR;
      }else{
        tempR -=maxR;
      }
      
    }
    bw.write(String.valueOf(result));
    bw.flush();
    bw.close();
  }
}