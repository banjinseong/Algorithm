import java.util.*;
class Main {
  public static void main(String[] args){
    int count;
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    for(;a<=b; a++){
      count = 0; 
      for(int i=2; i*i<=a; i++){
        if(a%i == 0){
          count++;
          break;
        }
      }
      if(count==0 && a != 1){
        System.out.println(a);
      }
    }
  }
}