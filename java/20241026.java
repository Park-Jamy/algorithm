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

import java.util.*;
import java.io.*;

public class Main {

  private static int[][] map;
  private static int[] list;
  //private static 
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    map = new int[n+1][n+1];
    list = new int[n+1];
    list[0] = -1;
    
    for(int i = 0; i < n - 1; i++){
      String[] nums = br.readLine().split(" ");
      int x = Integer.parseInt(nums[0]);
      int y = Integer.parseInt(nums[1]);

      map[x][y] = map[y][x] = 1;
    }

    StringBuffer sb = new StringBuffer();
    
    boolean[][] visited = new boolean[n+1][n+1];
    find(n, 1, visited);
    
    // 2번 부터 부모 노드 확인
    for(int i = 2; i < n + 1; i++){
      sb.append(list[i]).append("\n");
    }

    System.out.println(sb.toString());
  }

  private static void find(int n, int parent, boolean[][] visited){

    // if(list[sun] != 0) return; // 이미 부모 노드를 찾은 경우
    // else{
    //   if(map[parent][sun] == 1){
    //     list[sun] = parent;
    //     return;
    //   }else{
        for(int i = 1; i < n + 1; i++){
          
          if(visited[parent][i]) continue;
          
          if(map[parent][i] != 1) continue;
          
          if(list[i] != 0) 
          list[i] = parent;
          
          visited[parent][i] = visited[i][parent] = true;

          find(n, i, visited);
        }
      // }
    // }
  }
}
