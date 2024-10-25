import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[][] grade = new String[20][3];
    double g_grade_sum = 0.0;
    double grade_sum = 0.0;
    for(int i = 0; i < 20; i++){
      String[] str = br.readLine().split(" ");
      
      grade[i][0] = str[0];
      grade[i][1] = str[1];
      grade[i][2] = str[2];
      
      if(!grade[i][2].equals("P")){
        grade_sum += Double.valueOf(str[1]);
      }
    }

    for(int i = 0; i < 20; i++){
      if(!grade[i][2].equals("P")){
        double now_grade = Double.valueOf(grade[i][1]);
        double now_point = calc(grade[i][2]);
  
        g_grade_sum += now_grade * now_point;
      }
    }

    System.out.println(g_grade_sum/grade_sum);

  }

  private static double calc(String point){
    double answer = 0;
    if(point.equals("A+")){
      answer = 4.5;
    }else if(point.equals("A0")){
      answer = 4.0;
    }else if(point.equals("B+")){
      answer = 3.5;
    }else if(point.equals("B0")){
      answer = 3.0;
    }else if(point.equals("C+")){
      answer = 2.5;
    }else if(point.equals("C0")){
      answer = 2.0;
    }else if(point.equals("D+")){
      answer = 1.5;
    }else if(point.equals("D0")){
      answer = 1.0;
    }else if(point.equals("F")){
      answer = 0.0;
    }

    return answer;
  }
}


import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = -1;
        int N = Integer.parseInt(br.readLine());
        //5원을 사용할 수 있는 횟수 기준 내림차순 탐색
        for(int i=N/5;i>=0;i--){
            if((N - (5 * i))%2 == 0){	//5원을 i개 쓰고 2원으로 거스를 수 있을 때
                answer = i + (N - (5 * i))/2;	//동전의 개수 저장
                break;	//가장 먼저 거슬러 줄 때가 최소 개수
            }
        }
        bw.write(answer + "");		//최소 개수 BufferedWriter 저장
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
}

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String ss = br.readLine();

    int ss_len = ss.length();
    StringBuffer sb = new StringBuffer();
    StringBuffer sb1 = new StringBuffer();

    for (int i = 0; i < ss_len; i++) {
      if (ss.charAt(i) == '<') {
        String str_mid = calc(sb1.toString());
        sb.append(str_mid);
        
        sb.append("<");

        while (true) {
          i++;
          if (ss.charAt(i) == '>') {
            sb.append(">");
            sb1 = new StringBuffer();
            break;
          }
          sb.append(ss.charAt(i));
        }
      } else {
        sb1.append(ss.charAt(i));
      }
      if(i == ss_len - 1){
        String str_mid = calc(sb1.toString());
        sb.append(str_mid);
      }
    }

    System.out.println(sb.toString());
  }

  private static String calc(String str) {
    StringBuffer sb = new StringBuffer();

    int str_len = str.length();

    String[] str_arr = str.split(" ");

    if(str_arr.length > 1){
      for(int i = 0; i < str_arr.length; i++){
        //StringBuffer sb1 = new StringBuffer();

        String now_str = str_arr[i];

        int now_str_len = now_str.length();

        for (int j = 0; j < now_str_len; j++) {
          sb.append(now_str.charAt(now_str_len - j - 1));
        }

        if(i != str_arr.length - 1){
          sb.append(" ");
        }
      }
    }else{
      for (int i = 0; i < str_len; i++) {
        sb.append(str.charAt(str_len - i - 1));
      }
    }
    

    return sb.toString();
  }
}
