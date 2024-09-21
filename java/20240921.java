import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] NM = br.readLine().split(" ");

    int N = Integer.parseInt(NM[0]);
    int M = Integer.parseInt(NM[1]);

    Map<String, Integer> map = new HashMap<String, Integer>();

    for (int i = 0; i < N; i++){
      String str = br.readLine();
      
      int str_len = str.length();

      if(str_len < M) continue; // M 보다 짧은 단어는 패스
      
      map.put(str, map.getOrDefault(str, 0) + 1); // 각 단어별 출연 건수
    }

    int map_int = map.size();


    List<String> list = new ArrayList<String>(map.keySet());
    // words 리스트를 정렬
    Collections.sort(list, new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            // 자주 등장하는 단어 순서대로 정렬
            if (Integer.compare(map.get(o1), map.get(o2)) != 0) {
                return Integer.compare(map.get(o2), map.get(o1));
            }
            // 등장 횟수가 같으면 길이가 긴 단어가 먼저 오도록 정렬
            if (o1.length() != o2.length()) {
                return o2.length() - o1.length();
            }
            // 등장 횟수와 길이가 같으면 사전 순으로 정렬
            return o1.compareTo(o2);
        }
    });
    //List<String> words = new ArrayList<>(map.keySet());
    // for(Map.Entry<String, Integer> set : map.entrySet()){
    //   String now_str = set.getKey(); // 단어

    //   list.add(now_str);
    // }

    // String[] result = new String[map_int];
    
    // for(int i = 0; i < map_int - 1; i++){
    //   result[i] = list.get(i);
    // }

    // for(int i = 0; i < map_int - 1; i++){
    //   String now_str1 = list.get(i);
    //   for(int j = i + 1; j < map_int; j++){
    //     String now_str2 = list.get(j);

    //     if(map.get(now_str1) < map.get(now_str2)){
    //       String temp = result[i];
    //       result[i] = result[j];
    //       result[j] = temp;
    //     }else if(map.get(now_str1) == map.get(now_str2)){
    //       if(now_str1.length() < now_str2.length()){
    //         String temp = result[i];
    //         result[i] = result[j];
    //         result[j] = temp;
    //       }else if(now_str1.length() == now_str2.length()){
    //         if(now_str1.compareTo(now_str2) < 0){
    //           String temp = result[i];
    //           result[i] = result[j];
    //           result[j] = temp;
    //         }
    //       }
    //     }
    //   }
    // }

        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str + "\n");
        }
        System.out.println(sb);
  }
}

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] SN = br.readLine().split(" ");
    
    int s = Integer.parseInt(SN[0]);

    String N = SN[1];

    //   윷놀이 
    //   $Y$, 
    
    //   같은 그림 찾기 
    //   $F$, 
    
    //   원카드 
    //   $O$
    Set<String> st = new HashSet<String>();
    
    for(int i = 0; i < s; i++){
      String str = br.readLine();
      st.add(str);
    }

    int st_size = st.size();

    int chk = 0;

    if(N.equals("Y")){
      chk = 1;
    }else if(N.equals("F")){
      chk = 2;
    }else{
      chk = 3;
    }

    System.out.print((int)(st_size / chk));
  }
}
