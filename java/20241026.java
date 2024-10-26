import java.util.*;
import java.io.*;

public class Main {
  private static Deque<Integer> dq = new ArrayDeque<Integer>();
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    
    for(int i = 0; i < n; i++){
      String[] str = br.readLine().split(" ");

      String calc = str[0];
      int num = 0;
      
      if(str.length > 1){
          num = Integer.parseInt(str[1]);
      }

      programe(calc, num);
    }
  }

  private static void programe(String calc, int num){
    if(calc.equals("push_front")){
      dq.addFirst(num);
    }else if(calc.equals("push_back")){
      dq.addLast(num);
    }else if(calc.equals("pop_front")){
      int answer = 0;

      if(dq.isEmpty()) answer = -1;
      else{
        answer = dq.removeFirst();
      }

      System.out.println(answer);
    }else if(calc.equals("pop_back")){
      int answer = 0;

      if(dq.isEmpty()) answer = -1;
      else{
        answer = dq.removeLast();
      }

      System.out.println(answer);
    }else if(calc.equals("size")){
      System.out.println(dq.size());
    }else if(calc.equals("empty")){
      
      int answer = 0;
      
      if(dq.isEmpty()) answer = 0;
      else answer = 1;

      System.out.println(answer);
      
    }else if(calc.equals("front")){

      int answer = 0;

      if(dq.isEmpty()) answer = -1;
      else{
        answer = dq.getFirst();
      }

      System.out.println(answer);

    }else if(calc.equals("back")){
      int answer = 0;

      if(dq.isEmpty()) answer = -1;
      else{
        answer = dq.getLast();
      }

      System.out.println(answer);
    }
  }
}
