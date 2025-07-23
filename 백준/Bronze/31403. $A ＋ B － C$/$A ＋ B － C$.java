import java.io.*;
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();
        bw.write(String.valueOf(Integer.parseInt(a)+Integer.parseInt(b)-Integer.parseInt(c)));
        bw.newLine();
        bw.write(String.valueOf(Integer.parseInt(a+b) - Integer.parseInt(c)));
        bw.flush();
        bw.close();
        br.close();
    }
}