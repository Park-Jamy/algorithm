package org.Y2024.M06.D26;

import java.text.SimpleDateFormat;
import java.util.*;

class TimeInOut{
    Date date;
    String inOut;

    public TimeInOut(Date date, String inOut){
        this.date = date;
        this.inOut = inOut;
    }
}
public class q2024072201 {
    public static int[] solution(int[] fees, String[] records) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");

        int records_len = records.length;

        Map<String, TimeInOut> map = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();
        Map<String, Integer> resultMoney = new TreeMap<>();

        for(int i = 0; i < records_len; i++) {
            String[] list_str = records[i].split(" ");

            Date date = format.parse(list_str[0]);
            String num = list_str[1];
            String inOut = list_str[2];

            if(inOut.equals("IN")) { // 입차하는 차의 경우 차량 입출 기록과 상관 없이 업데이트 한다.
                map.put(num, new TimeInOut(date, inOut));
            }else { // 출차 하는 경우에
                Date inDate = map.get(num).date; // 입차한 시간
                String in_num = num;

                int difference = (int)(date.getTime() - inDate.getTime()) / ( 1000 * 60 );
                result.put(num, result.getOrDefault(num, 0) + difference);
                map.put(num, new TimeInOut(date, inOut));
            }
        }

        for(Map.Entry<String, TimeInOut> e : map.entrySet()){
            if("IN".equals(e.getValue().inOut)){
                String end = "23:59";
                Date end_date = format.parse(end);

                int difference = (int) (end_date.getTime() - e.getValue().date.getTime()) / ( 1000 * 60 );

                result.put(e.getKey(), result.get(e.getKey()) + difference);
            }
        }

        for(Map.Entry<String, Integer> e : result.entrySet()){
            int time = e.getValue();
            if(fees[0] >= time) { // 기본 시간안에 출차를 했다면 기본 금액만
                resultMoney.put(e.getKey(), fees[1]);
            }else if(fees[0] < time){ // 기본 시간 이상 주차를 했을 경우
                int a = e.getValue() - fees[0];
                int n = 0;
                if(a % fees[2] != 0) {
                    n = ((e.getValue() - fees[0]) / fees[2]) + 1;
                }else{
                    n = (e.getValue() - fees[0]) / fees[2];
                }
                int nowFee = fees[1] + (n * fees[3]);
                resultMoney.put(e.getKey(), nowFee);
            }
        }

        int[] list = new int[resultMoney.size()];

        int k = 0;
        for(Map.Entry<String, Integer> e : resultMoney.entrySet()){
            list[k] = e.getValue();
        }

        return list;
    }
}

package org.Y2024.M06.D26;

//        문제 설명

//        어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
//
//        예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.
//
//        문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다.
//        number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
//
//        제한 조건

//        number는 2자리 이상, 1,000,000자리 이하인 숫자입니다.
//        k는 1 이상 number의 자릿수 미만인 자연수입니다.

//        입출력 예

//        number	k	return
//        "1924"	2	"94"
//        "1231234"	3	"3234"
//        "4177252841"	4	"775841"

        import java.util.*;
public class q2024072202 {
    public static String solution(String number, int k){
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < result.length; i++) {
            sb.append(stack.get(i));
        }

        return sb.toString();
    }
}

package org.Y2024.M06.D26;
        import java.util.*;
public class q2024072203 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int seq_len =  sequence.length;

        // 부분 배열의 수가 1부터 seq_len 까지 인 것으로 가정하고
        // 수열 갯수를 올려가며 더한 값이 존재 하는지 확인
        for(int i = 1; i <= seq_len; i++){
            boolean chk = false;

            for(int j = 0; j <= seq_len - i; j++){
                int[] sub = Arrays.copyOfRange(sequence, j , j + i);
                int sum = 0;

                for(int a = 0; a < i; a++){
                    sum += sub[a];
                }

                if(sum == k) {

                    answer[0] = j;
                    answer[1] = j + i - 1;

                    chk = true;
                    break;
                }
            }

            if(chk) break;
        }

        return answer;
    }
}

package org.Y2024.M06.D26;

//        문제 설명
//
//        어느 공원 놀이터에는 시소가 하나 설치되어 있습니다. 이 시소는 중심으로부터 2(m), 3(m), 4(m) 거리의 지점에 좌석이 하나씩 있습니다.
//        이 시소를 두 명이 마주 보고 탄다고 할 때, 시소가 평형인 상태에서 각각에 의해 시소에 걸리는 토크의 크기가 서로 상쇄되어 완전한 균형을 이룰 수 있다면 그 두 사람을 시소 짝꿍이라고 합니다.
//        즉, 탑승한 사람의 무게와 시소 축과 좌석 간의 거리의 곱이 양쪽 다 같다면 시소 짝꿍이라고 할 수 있습니다.
//        사람들의 몸무게 목록 weights이 주어질 때, 시소 짝꿍이 몇 쌍 존재하는지 구하여 return 하도록 solution 함수를 완성해주세요.
//
//        제한 사항
//
//        2 ≤ weights의 길이 ≤ 100,000
//        100 ≤ weights[i] ≤ 1,000
//        몸무게 단위는 N(뉴턴)으로 주어집니다.
//        몸무게는 모두 정수입니다.


public class q2024072204 {
    public static long solution(int[] weights) {
        long answer = 0;

        int weight_len = weights.length;

        // 최소 공배수 가  4 이하인지 확인
        for(int i = 0; i < weight_len - 1; i++){
            for(int j = i + 1; j < weight_len; j++){
                int a = weights[i];
                int b = weights[j];

                long c = lcm(a,b);

                int ca = (int) c / a;
                int cb = (int) c / b;

                if( c / a <= 4 && c / b <= 4){
                    answer++;
                }
            }
        }

        return answer;
    }

    // 반복문 방식
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static long lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
