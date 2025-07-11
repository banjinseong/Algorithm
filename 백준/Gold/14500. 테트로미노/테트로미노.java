import java.io.*;
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] arr = new int[n][m];
        int max = 0;

        int[][][] types = {
                { {0, 0, 0}, {1, 2, 3} },  // type1
                { {1, 2, 3}, {0, 0, 0} },  // type2
                { {1, 2, 2}, {0, 0, 1} },  // type3
                { {1, 2, 2}, {0, 0, -1} }, // type4
                { {0, 1, 2}, {1, 1, 1} },  // type5
                { {0, 1, 2}, {-1, -1, -1} }, // type6
                { {1, 1, 2}, {0, 1, 1} },  // type7
                { {1, 1, 2}, {0, -1, -1} },// type8
                { {0, -1, -1}, {1, 1, 2} },// type9
                { {0, 1, 1}, {1, 1, 2} },  // type10
                { {-1, -1, -1}, {0, 1, 2} },  // type11
                { {0, 0, 1}, {1, 2, 2} },  // type12
                { {0, 0, -1}, {1, 2, 2} }, // type13
                { {1, 1, 1}, {0, 1, 2} },  // type14
                { {0, 1, 1}, {1, 0, 1} },   // type15

                { {1, 1, 2}, {-1, 0, 0} }, // type16
                { {1, 1, 1}, {-1, 1, 0} }, // type17
                { {1, 1, 2}, {0, 1, 0} },  // type18
                { {-1, -1, -1}, {-1, 1, 0} } // type19
        };



        for(int i = 0; i < n; i++){
            String[] s1 = bf.readLine().split(" ");
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(s1[j]);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for (int z = 0; z < 15; z++){
                    if(i+types[z][0][2] >= 0 && i+types[z][0][2] < n && j+types[z][1][2] >= 0 && j+types[z][1][2] < m){
                        max = Math.max(max, arr[i][j] + arr[i+types[z][0][0]][j+types[z][1][0]] + arr[i+types[z][0][1]][j+types[z][1][1]] + arr[i+types[z][0][2]][j+types[z][1][2]]);
                    }
                }
                for(int z = 15; z < 19; z++){
                    if(i+types[z][0][0] >= 0 && i+types[z][0][2] < n && j+types[z][1][0] >= 0 && j+types[z][1][1] < m){
                        max = Math.max(max, arr[i][j] + arr[i+types[z][0][0]][j+types[z][1][0]] + arr[i+types[z][0][1]][j+types[z][1][1]] + arr[i+types[z][0][2]][j+types[z][1][2]]);
                    }
                }

            }
        }
        System.out.println(max);

    }
}