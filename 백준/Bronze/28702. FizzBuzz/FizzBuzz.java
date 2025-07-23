import java.io.*;
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] srr = new String[3];
        int next = 0;
        String x;
        for (int i = 0; i < 3; i++) {
            srr[i] = br.readLine();
            if(!srr[i].contains("Buzz") && !srr[i].contains("Fizz")){
                next = Integer.parseInt(srr[i]) + 3 - i;
            }
        }

        if(next % 3 == 0 && next % 5 == 0){
            x = "FizzBuzz";
        }else{
            if(next % 3 == 0){
                x = "Fizz";
            }else if(next % 5 == 0){
                x = "Buzz";
            }else{
                x = String.valueOf(next);
            }
        }

        bw.write(x);
        bw.close();
        br.close();
    }
}