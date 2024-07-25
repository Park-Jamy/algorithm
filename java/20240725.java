import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String first = br.readLine();
        int first_len = first.length;

        int result = 0;
        String[] firstList = first.split("");

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < first_len; i++){
            map.put(firstList[i], getOrDefault(firstList[i], 1) + 1);
        }

        for(int i = 0; i < N-1; i++){
            String str = br.readLine();
            String[] strList = str.split("");
            int str_len = strList.length;
            int chk = 0;
            for(int j = 0; j < str_len; j++){
                String now = strList[j];

                if(map.containsKey(now)){
                    map.put(now, map.get(now) - 1);
                }else{
                    chk++;
                }
            }

            for(String key : map.keySet()){
                if(map.get(key) != 0) chk++;
            }

            if(chk <= 1) result++;
        }

        return result;
    }
}

package org.Y2024.M06.D26;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;

public class q2024072502 {

    public static int solution(int M){
        int result = 0;

        List<Integer> list = new ArrayList<>();

        // M 이하의 소수 리스트 만들기
        for(int i = 2; i <= M; i++){
            int nowNum = calc(i);

            if(nowNum != 0){
                list.add(nowNum);
            }
        }

        int[] numList = list.stream().mapToInt(i -> i).toArray();
        int numLen = numList.length;


        int start = 0, end = 0;
        int sum = 0;
        while(true){
            if(start == end) {
                sum += numList[start];
            }else if(start < end){
                sum += numList[end];
            }
            // M이 맞을 경우
            if(sum == M){
                sum = 0;
                start++;
                end = start;
                result++;
            }else if(sum > M){
                sum = 0;
                start++;
                end = start;
            }else{
                end++;
            }

            if(start >= numLen || end >= numLen) break;
        }

        return result;

    }

    public static int calc(int M){

        if(M == 2) return M;
        else {
            for (int i = 2; i <= Math.sqrt(M); i++) {
                if (M % i == 0) {
                    return 0;
                }
            }
            return M;
        }
    }
}


package org.Y2024.M06.D26;

        import java.nio.channels.Pipe;
        import java.util.*;



class Point{
    int num;
    String gemName;

    public Point(int num, String gemName){
        this.num = num;
        this.gemName = gemName;
    }
}
public class q2024072501 {
    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        int min = 10000;
        int gems_len = gems.length;
        Set<String> gemList = new HashSet<>();

        // 보석 리스트
        for(int i = 0; i < gems_len; i++){
            gemList.add(gems[i]);
        }

        //
        // Arrays.copyOfRange(gems, 1, 5);
        //

        // 보석 갯수
        int gemSize = gemList.size();

        for(int i = 0; i < gems_len; i++){

            Set<String> gemChkList = new HashSet<>();

            for(int j = i; j < gems_len; j++){
                gemChkList.add(gems[j]);

                if(gemChkList.size() == gemSize){
                    if(min > (j - i)) {
                        min = (j - i);
                        answer[0] = i+1;
                        answer[1] = j+1;
                    }
                    break;
                }
            }
        }

        return answer;
    }
}



