//점프와 순간 이동
//        제출 내역
//        문제 설명
//        OO 연구소는 한 번에 K 칸을 앞으로 점프하거나, (현재까지 온 거리) x 2 에 해당하는 위치로 순간이동을 할 수 있는 특수한
//        기능을 가진 아이언 슈트를 개발하여 판매하고 있습니다. 이 아이언 슈트는 건전지로 작동되는데, 순간이동을 하면 건전지
//        사용량이 줄지 않지만, 앞으로 K 칸을 점프하면 K 만큼의 건전지 사용량이 듭니다.
//        그러므로 아이언 슈트를 착용하고 이동할 때는 순간 이동을 하는 것이 더 효율적입니다.
//        아이언 슈트 구매자는 아이언 슈트를 착용하고 거리가 N 만큼 떨어져 있는 장소로 가려고 합니다.
//        단, 건전지 사용량을 줄이기 위해 점프로 이동하는 것은 최소로 하려고 합니다.
//        아이언 슈트 구매자가 이동하려는 거리 N이 주어졌을 때, 사용해야 하는 건전지 사용량의 최솟값을 return하는
//        solution 함수를 만들어 주세요.
//
//        예를 들어 거리가 5만큼 떨어져 있는 장소로 가려고 합니다.
//        아이언 슈트를 입고 거리가 5만큼 떨어져 있는 장소로 갈 수 있는 경우의 수는 여러 가지입니다.
//
//        처음 위치 0 에서 5 칸을 앞으로 점프하면 바로 도착하지만, 건전지 사용량이 5 만큼 듭니다.

//        처음 위치 0 에서 2 칸을 앞으로 점프한 다음 순간이동 하면 (현재까지 온 거리 : 2) x 2에 해당하는 위치로 이동할 수 있으므로 위치 4로 이동합니다.
//        이때 1 칸을 앞으로 점프하면 도착하므로 건전지 사용량이 3 만큼 듭니다.

//        처음 위치 0 에서 1 칸을 앞으로 점프한 다음 순간이동 하면 (현재까지 온 거리 : 1) x 2에 해당하는 위치로 이동할 수 있으므로 위치 2로 이동됩니다.
//        이때 다시 순간이동 하면 (현재까지 온 거리 : 2) x 2 만큼 이동할 수 있으므로 위치 4로 이동합니다. 이때 1 칸을 앞으로 점프하면 도착하므로 건전지 사용량이 2 만큼 듭니다.

//        위의 3가지 경우 거리가 5만큼 떨어져 있는 장소로 가기 위해서 3번째 경우가 건전지 사용량이 가장 적으므로 답은 2가 됩니다.
//
//        제한 사항
//        숫자 N: 1 이상 10억 이하의 자연수
//        숫자 K: 1 이상의 자연수

//        입출력 예
//        N	result
//        5	2
//        6	2
//        5000	5

import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        // 텔레포트를 하고 나서
        int minPower = 0;

        while( n != 0 ){
            minPower += n % 2;
            n = n / 2;
        }

        return minPower;
    }
}


//    멀리 뛰기
//    제출 내역
//    문제 설명
//    효진이는 멀리 뛰기를 연습하고 있습니다. 효진이는 한번에 1칸, 또는 2칸을 뛸 수 있습니다. 칸이 총 4개 있을 때, 효진이는
//        (1칸, 1칸, 1칸, 1칸)
//        (1칸, 2칸, 1칸)
//        (1칸, 1칸, 2칸)
//        (2칸, 1칸, 1칸)
//        (2칸, 2칸)
//        의 5가지 방법으로 맨 끝 칸에 도달할 수 있습니다. 멀리뛰기에 사용될 칸의 수 n이 주어질 때, 효진이가 끝에 도달하는 방법이 몇 가지인지 알아내, 여기에 1234567를 나눈 나머지를 리턴하는 함수, solution을 완성하세요. 예를 들어 4가 입력된다면, 5를 return하면 됩니다.
//
//        제한 사항
//        n은 1 이상, 2000 이하인 정수입니다.
//        입출력 예
//        n	result
//        4	5
//        3	3

class Solution {
    public long solution(int n) {
        long[]arr=new long[n+1];
        arr[0]=1;
        arr[1]=1;
        for(int i=2;i<n+1;i++){
            arr[i] = arr[i-1] % 1234567 + arr[i-2] % 1234567;
        }
        return arr[n] % 1234567;
    }

    public static double fibonache(long end){
        if(end <= 1){
            return 1;
        }else {
            return end * fibonache(end - 1) ;
        }
    }
}


//    약수의 합

//    제출 내역
//    문제 설명
//    정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.
//
//        제한 사항
//     n은 0 이상 3000이하인 정수입니다.

class Solution {
    public int solution(int n) {
        int answer = 0;

        for(int i = 1; i <= n/2; i++){
            if( n % i == 0) answer += i;
        }

        return answer;
    }
}


//    문자열을 정수로 바꾸기
//        제출 내역
//        문제 설명
//        문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요.
//
//        제한 조건
//        s의 길이는 1 이상 5이하입니다.
//        s의 맨앞에는 부호(+, -)가 올 수 있습니다.
//        s는 부호와 숫자로만 이루어져있습니다.
//        s는 "0"으로 시작하지 않습니다.
//        입출력 예
//예를들어 str이 "1234"이면 1234를 반환하고, "-1234"이면 -1234를 반환하면 됩니다.
//        str은 부호(+,-)와 숫자로만 구성되어 있고, 잘못된 값이 입력되는 경우는 없습니다.
class Solution {
    public int solution(String s) {
        int answer = 0;
        int minus = 0;

        if(s.charAt(0) == '-') {
            minus = 1;
            s = s.substring(1,s.length());
        }

        return answer = minus == 1 ? -Integer.valueOf(s) :Integer.valueOf(s);
    }
}


//    x만큼 간격이 있는 n개의 숫자
//        제출 내역
//        문제 설명
//        함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다. 다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.
//
//        제한 조건
//        x는 -10000000 이상, 10000000 이하인 정수입니다.
//        n은 1000 이하인 자연수입니다.
//        입출력 예
//        x	n	answer
//        2	5	[2,4,6,8,10]
//        4	3	[4,8,12]
//        -4	2	[-4, -8]

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        for(int i = 1; i <= n; i++){
            answer[i-1] = x * i;
        }

        return answer;
    }
}