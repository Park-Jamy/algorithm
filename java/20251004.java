import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";

        String[] strList = s.split(" ");

        int min = 9999999;
        int max = -9999999;

        for(String str : strList){
            int now = Integer.valueOf(str);

            if(now < min){
                min = now;
            }

            if(now > max){
                max = now;
            }
        }

        return min + " " + max;
    }
}

class Solution
{
    public int solution(int n) {
        int answer = 1;

        // 연속된 자연수 중 시작 자연수
        for(int i = 1; i <= n ; i++){
            int resultInt = 0;

            for(int j = i; j <= n ; j++){
                if(resultInt == n){
                    answer++;
                    break;
                } else if (resultInt > n){
                    break;
                }
                resultInt += j;
            }
        }

        return answer;
    }
}