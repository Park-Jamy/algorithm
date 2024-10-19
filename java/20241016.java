import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String[] an = br.readLine().split(" ");
    String[] bn = br.readLine().split(" ");

    int[] a = new int[n];
    Integer[] b = new Integer[n];
    for(int i = 0; i < n; i++){
      a[i] = Integer.parseInt(an[i]);
      b[i] = Integer.parseInt(bn[i]);
    }

    Arrays.sort(a);
    Arrays.sort(b, Collections.reverseOrder());

    int answer = 0;

    for(int i = 0; i < n; i++){
      answer += a[i] * b[i];
    }

    System.out.println(answer);
  }
}

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nm = br.readLine().split(" ");

    int n = Integer.parseInt(nm[0]); // 교체해야 하는 줄 갯수
    int m = Integer.parseInt(nm[1]);
    
    int[][] pricePackageSe = new int[m][2];

    for(int i = 0; i < m; i++){
      String[] pricePackageSeStr = br.readLine().split(" ");

      pricePackageSe[i][0] = Integer.parseInt(pricePackageSeStr[0]); // 6개 살 때 가격
      pricePackageSe[i][1] = Integer.parseInt(pricePackageSeStr[1]); // 1개 살 때 가격
    }

    int answer = Integer.MAX_VALUE;

    for(int i = 0; i < m; i++){
      int ackage = pricePackageSe[i][0];
      int se     = pricePackageSe[i][1];
      int a = 0;
      
      if(n % 6 > 0) a = ackage * ((int)(n / 6) + 1);
      else a = ackage * ((int)(n / 6));
       
      int b = se * n;

      answer = Math.min(a, Math.min(b,answer));
      System.out.println(answer);
    }

    System.out.println(answer);
  }
}

