
//문자열 내 p와 y의 개수
//        제출 내역
//        문제 설명
//        대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True,
//        다르면 False를 return 하는 solution를 완성하세요. 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다.
//        단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
//
//        예를 들어 s가 "pPoooyY"면 true를 return하고 "Pyy"라면 false를 return합니다.
//
//        제한사항
//        문자열 s의 길이 : 50 이하의 자연수
//        문자열 s는 알파벳으로만 이루어져 있습니다.
//        입출력 예
//        s	answer
//        "pPoooyY"	true
//        "Pyy"	false

import java.lang.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();

        int sLen = s.length();

        int pCnt = 0;
        int yCnt = 0;


        for( int i = 0; i < sLen; i++ ){
            char nowChar = s.charAt(i); // 현재 문자 확인

            if( nowChar == 'p') pCnt++;
            else if( nowChar == 'y') yCnt++;

        }

        if( yCnt == 0 && pCnt == 0){
            return true;
        }
        else {
            if( yCnt == pCnt ) return true;
            else return false;
        }
    }
}


//    정수 제곱근 판별
//        제출 내역

//        문제 설명
//        임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
//        n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
//
//        제한 사항
//        n은 1이상, 50000000000000 이하인 양의 정수입니다.

//        입출력 예
//        n	return
//        121	144
//        3	-1

class Solution {
    public long solution(long n) {
        long answer = 0;

        for(long i = 1; i <= n / 2; i++){
            if( n % i == 0 && n / i == i) {
                answer = i;
                break;
            }
            if( i == n / 2 ) answer = -1;
        }

        return answer = answer == -1? -1 : (long)Math.pow(answer+1,2);
    }
}


//    괄호 회전하기
//    제출 내역
//    문제 설명
//    다음 규칙을 지키는 문자열을 올바른 괄호 문자열이라고 정의합니다.
//
//        (), [], {} 는 모두 올바른 괄호 문자열입니다.
//        만약 A가 올바른 괄호 문자열이라면, (A), [A], {A} 도 올바른 괄호 문자열입니다. 예를 들어, [] 가 올바른 괄호 문자열이므로,
//        ([]) 도 올바른 괄호 문자열입니다.
//        만약 A, B가 올바른 괄호 문자열이라면, AB 도 올바른 괄호 문자열입니다. 예를 들어, {} 와 ([]) 가 올바른 괄호 문자열이므로,
//        {}([]) 도 올바른 괄호 문자열입니다.
//        대괄호, 중괄호, 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다. 이 s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때
//        s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return 하도록 solution 함수를 완성해주세요.
//
//        제한사항
//        s의 길이는 1 이상 1,000 이하입니다.

//        입출력 예
//        s	result
//        "[](){}"	3
//        "}]()[{"	2
//        "[)(]"	0
//        "}}}"	0


class Solution {
    public int solution(String s) {
        int answer = -1;

        // 큐를 통해 맨 앞 데이터를 맨 뒤 데이터로 이동
        // 스텍을 통해 올바른 괄호 문자열인지 확인
        // 맞다면 answer +1
        // 전체 회전 수는 s 문자열 길이

        int rollCnt = 0;

        int sLen = s.length();

        Queue<Character> q = new LinkedList<>(); // 회전문
        Stack<Character> st = new Stack<>();     // 올바른지 체크 할 수 있는 공간

        // 초기 회전문 세팅
        for( int i = 0; i < sLen; i++ ){
            q.add(s.charAt(i));
        }
        System.out.println(q.peek());
        for( int j = 0; j < sLen; j++ ) {
            if(j != 0) {
                char c = q.poll();
                q.add(c);
            }

            Queue<Character> eq = q;

            // 올바른지 체크
            for (int i = 0; i < sLen; i++) {
                char nowChar = q.poll();

                if (nowChar == '{' || nowChar == '(' || nowChar == '[') st.push(nowChar);
                else {
                    if (st.size() == 0) st.push(nowChar); // st에 아무것도 없을 경우
                    else {
                        if ((st.peek() == '{' && nowChar == '}') ||
                                (st.peek() == '(' && nowChar == ')') ||
                                (st.peek() == '[' && nowChar == ']'))
                            st.pop();
                        else break;
                    }
                }

                if (i == sLen - 1 && st.size() == 0) rollCnt++;
            }
        }
        return rollCnt;
    }
}