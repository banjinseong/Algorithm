import java.util.*;
class Main {  
  public static void main(String args[]) { 
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int temp;
    int count = a / 5;
    for(;count>=0; count--){
      temp = a - 5*count;
      if(temp == 0){
        System.out.println(count);
        break;
      }else if(temp % 3 == 0){
        count += temp/3;
        System.out.println(count);
        break;
      }
    }
    if(count == -1){
      System.out.println(-1);
    }
  } 
}