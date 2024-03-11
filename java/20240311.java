//올바른 괄호
//        제출 내역
//        문제 설명
//        괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어
//
//        "()()" 또는 "(())()" 는 올바른 괄호입니다.
//        ")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
//        '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
//
//        제한사항
//        문자열 s의 길이 : 100,000 이하의 자연수
//        문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.

//        입출력 예
//        s	answer
//        "()()"	true
//        "(())()"	true
//        ")()("	false
//        "(()("	false

import java.util.Stack;

import static java.lang.Integer.toBinaryString;

class solution {
    boolean solution(String s) {
        boolean answer = true;
        boolean err = false;
        Stack<Character> st = new Stack<Character>();

        for(int i = 0; i < s.length(); i++){
            if( s.charAt(i) == '(' ) st.push(s.charAt(i));
            else {
                if(st.size() != 0){
                    char top = st.peek();
                    if(top == '(') st.pop();
                    else {
                        err = true;
                        break;
                    }
                }
                else {
                    err = true;
                    break;
                }
            }
        }

        if(!err){
            if(st.size() == 0) answer = true;
            else answer = false;
        }
        else answer = false;

        return answer;
    }
}


//    이진 변환 반복하기
//        제출 내역
//        문제 설명
//        0과 1로 이루어진 어떤 문자열 x에 대한 이진 변환을 다음과 같이 정의합니다.
//
//        x의 모든 0을 제거합니다.
//        x의 길이를 c라고 하면, x를 "c를 2진법으로 표현한 문자열"로 바꿉니다.
//        예를 들어, x = "0111010"이라면, x에 이진 변환을 가하면 x = "0111010" -> "1111" -> "100" 이 됩니다.
//
//        0과 1로 이루어진 문자열 s가 매개변수로 주어집니다. s가 "1"이 될 때까지 계속해서 s에 이진 변환을 가했을 때, 이진 변환의 횟수와 변환 과정에서 제거된 모든 0의 개수를 각각 배열에 담아 return 하도록 solution 함수를 완성해주세요.
//
//        제한사항
//        s의 길이는 1 이상 150,000 이하입니다.
//        s에는 '1'이 최소 하나 이상 포함되어 있습니다.

class solution(String s) {
    int[] answer = new int[2];

    StringBuilder sb;

    int Count = 0;
    int zeroCount = 0;

    while(true){
        sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            String now = String.valueOf(s.charAt(i));

            if(now.equals("1")) sb.append("1");
            else zeroCount++;

        }

        Count++;

        if(sb.equals("1")) break;
        else {
            int len = sb.length();
            s = String.valueOf(toBinaryString(len));
        }
    }

    answer[0] = Count;
    answer[1] = zeroCount;

    return answer;
}

//    int[] answer = new int[2];
//    int count = 0; // 반복 횟수
//    int zeroCount = 0; // 0 삭제 횟수
//
//        while (!s.equals("1")) { // 이진 변환값이 1이면 반복 중단
//                int length = s.length(); // 이진법 문자열 길이
//                s = s.replace("0", ""); // 이진법 문자열에서 0 제거
//
//                // 전체 이진 문자 길이에서 0제거한 길이를 뺌
//                // zeroCount엔 삭제한 0 갯수가 담김
//                zeroCount += length - s.length();
//                count ++; // 반복 횟수
//
//                s = Integer.toBinaryString(s.length()); // 문자열 길이를 이진법으로 변환
//                }
//
//                answer[0] = count;
//                answer[1] = zeroCount;
//                return answer;



//    숫자의 표현
//    제출 내역
//    문제 설명
//    Finn은 요즘 수학공부에 빠져 있습니다. 수학 공부를 하던 Finn은 자연수 n을 연속한 자연수들로 표현 하는 방법이 여러개라는 사실을 알게 되었습니다. 예를들어 15는 다음과 같이 4가지로 표현 할 수 있습니다.
//
//        1 + 2 + 3 + 4 + 5 = 15
//        4 + 5 + 6 = 15
//        7 + 8 = 15
//        15 = 15
//        자연수 n이 매개변수로 주어질 때, 연속된 자연수들로 n을 표현하는 방법의 수를 return하는 solution를 완성해주세요.
//
//        제한사항
//        n은 10,000 이하의 자연수 입니다.
//        입출력 예
//        n	result
//        15	4

class solution(String s){
    int answer = 0;
    int aInt = Integer.valueOf(s);
    // s 보다 작은 수 부터 +1 씩 하며 연속되는 숫자들을 더해준다.
    // 작으면 다음 숫자를 더해주고 높으면 out , 같으면 answer +1

        for(int i = 1; i <= aInt; i++)
    {
        int result = 0;
        for( int j = i; j <= aInt; j++){
            result += j;
            if(result == aInt) {
                answer++;
                break;
            }else if( result > aInt)
                break;
        }
    }
        return answer;
}

//    귤 고르기

//    제출 내역
//    문제 설명

//    경화는 과수원에서 귤을 수확했습니다. 경화는 수확한 귤 중 'k'개를 골라 상자 하나에 담아 판매하려고 합니다.
//    그런데 수확한 귤의 크기가 일정하지 않아 보기에 좋지 않다고 생각한 경화는 귤을 크기별로 분류했을 때
//    서로 다른 종류의 수를 최소화하고 싶습니다.
//
//        예를 들어, 경화가 수확한 귤 8개의 크기가 [1, 3, 2, 5, 4, 5, 2, 3] 이라고 합시다.
//        경화가 귤 6개를 판매하고 싶다면, 크기가 1, 4인 귤을 제외한 여섯 개의 귤을 상자에 담으면,
//        귤의 크기의 종류가 2, 3, 5로 총 3가지가 되며 이때가 서로 다른 종류가 최소일 때입니다.
//
//        경화가 한 상자에 담으려는 귤의 개수 k와 귤의 크기를 담은 배열 tangerine이 매개변수로 주어집니다.
//        경화가 귤 k개를 고를 때 크기가 서로 다른 종류의 수의 최솟값을 return 하도록 solution 함수를 작성해주세요.
//
//        제한사항
//        1 ≤ k ≤ tangerine의 길이 ≤ 100,000
//        1 ≤ tangerine의 원소 ≤ 10,000,000

class solution(int k, int[] tangerine){
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        Arrays.sort(tangerine);

        for(int i = 0; i < tangerine.length; i++){
        if(map.containsKey(tangerine[i])){
            map.put(tangerine[i], map.get(tangerine[i]) + 1);
        }else {
            map.put(tangerine[i], 1);
        }
    }

    List<Integer> keySet = new ArrayList<>(map.keySet());

    // Value 값으로 내림차순 정렬
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

    int answer = 0;
    int num = 0;

        for(int key : keySet){

        num += map.get(key);

        if(num >= k) {
            answer++;
            break;
        }else {
            answer++;
        }
    }
        return answer;
}


//구명보트
//        제출 내역
//        문제 설명
//        무인도에 갇힌 사람들을 구명보트를 이용하여 구출하려고 합니다. 구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다.
//
//        예를 들어, 사람들의 몸무게가 [70kg, 50kg, 80kg, 50kg]이고 구명보트의 무게 제한이 100kg이라면 2번째 사람과 4번째 사람은 같이 탈 수 있지만 1번째 사람과 3번째 사람의 무게의 합은 150kg이므로 구명보트의 무게 제한을 초과하여 같이 탈 수 없습니다.
//
//        구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 합니다.
//
//        사람들의 몸무게를 담은 배열 people과 구명보트의 무게 제한 limit가 매개변수로 주어질 때, 모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return 하도록 solution 함수를 작성해주세요.
//
//        제한사항
//        무인도에 갇힌 사람은 1명 이상 50,000명 이하입니다.
//        각 사람의 몸무게는 40kg 이상 240kg 이하입니다.
//        구명보트의 무게 제한은 40kg 이상 240kg 이하입니다.
//        구명보트의 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어지므로 사람들을 구출할 수 없는 경우는 없습니다.

//        입출력 예
//        people	limit	return
//        [70, 50, 80, 50]	100	3
//        [70, 80, 50]	100	3

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int peopleCnt = people.length;
        Arrays.sort(people);

        int e = 0;

        for( int i = peopleCnt - 1; i >= e; i--){
            if( people[i] + people[e] <= limit ){
                e++;
                answer++;
            }else {
                answer++;
            }
        }

        return answer;
    }
}


//    다음 큰 숫자
//        제출 내역
//        문제 설명
//        자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.
//
//        조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
//        조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
//        조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
//        예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.
//
//        자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.
//
//        제한 사항
//        n은 1,000,000 이하의 자연수 입니다.

//        입출력 예
//        n	result
//        78	83
//        15	23

class Solution {
    public int solution(int n) {
        int answer = 0;
        int nCnt = calc(n);

        for(int i = n + 1; i < 1000000; i++){
            if(nCnt == calc(i)) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    public static int calc(int num){
        String str = String.valueOf(Integer.toBinaryString(num));

        int cntOne = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '1') cntOne++;
        }

        return cntOne;
    }
}