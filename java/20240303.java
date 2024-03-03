//n의 배수
//제출 내역
//문제 설명
//정수 num과 n이 매개 변수로 주어질 때, num이 n의 배수이면 1을 return n의 배수가 아니라면 0을 return하도록 solution 함수를 완성해주세요.
//
//제한사항
//2 ≤ num ≤ 100
//2 ≤ n ≤ 9

class Solution {
    public int solution(int num, int n) {
        int answer = 0;
        
        // answer = num % n == 0 ? 1 : 0;
        answer = num % n;
        
        if(answer == 0) return 1;
        else return 0;
    }
}


//공배수
//제출 내역
//문제 설명
//정수 number와 n, m이 주어집니다. number가 n의 배수이면서 m의 배수이면 1을 아니라면 0을 return하도록 solution 함수를 완성해주세요.
//
//제한사항
//10 ≤ number ≤ 100
//2 ≤ n, m < 10

class Solution {
    public int solution(int number, int n, int m) {
        int answer = 0;
        
        answer = number % n == 0 ? (number % m == 0 ? 1 : 0) : 0;
        
        return answer;
    }
}


//홀짝에 따라 다른 값 반환하기
//제출 내역
//문제 설명
//양의 정수 n이 매개변수로 주어질 때, n이 홀수라면 n 이하의 홀수인 모든 양의 정수의 합을 return 하고 n이 짝수라면 n 이하의 짝수인 모든 양의 정수의 제곱의 합을 return 하는 solution 함수를 작성해 주세요.
//
//제한사항
//1 ≤ n ≤ 100

class Solution {
    public int solution(int n) {
        int answer = 0;
        int chk = n % 2 == 0 ? 1 : 0;
        
        for(int i = 1; i <= n; i++){
            if(chk == 1 && i % 2 == 0 ){ // 짝수이면
                answer += i*i;
            } else if((chk != 1 && i % 2 != 0 )) { // 홀수이면 
                answer += i;
            }
        }
        return answer;
    }
}

//class Solution {
//    public int solution(int n) {
//            int answer = 0;
//        if (n % 2 == 0) {
//            for (int i = 2; i <= n; i += 2) {
//                answer += i * i;
//            }
//        } else {
//            for (int i = 1; i <= n; i += 2) {
//                answer += i;
//            }
//        }
//        return answer;
//    }
//}


//조건 문자열
//제출 내역
//문제 설명
//문자열에 따라 다음과 같이 두 수의 크기를 비교하려고 합니다.
//
//두 수가 n과 m이라면
//">", "=" : n >= m
//"<", "=" : n <= m
//">", "!" : n > m
//"<", "!" : n < m
//두 문자열 ineq와 eq가 주어집니다. ineq는 "<"와 ">"중 하나고, eq는 "="와 "!"중 하나입니다. 그리고 두 정수 n과 m이 주어질 때, n과 m이 ineq와 eq의 조건에 맞으면 1을 아니면 0을 return하도록 solution 함수를 완성해주세요.
//
//제한 사항
//1 ≤ n, m ≤ 100

class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        
        String strSum = ineq.concat(eq);
        
        
        if( strSum.equals("<=")){
            if( n <= m ) answer = 1;
            else answer = 0;
        }else if(strSum.equals(">=")){
            if( n >= m ) answer = 1;
            else answer = 0;
        }else if(strSum.equals("<!")){
            if( n < m ) answer = 1;
            else answer = 0;
        }else {
            if( n > m ) answer = 1;
            else answer = 0;
        }
        
        return answer;
    }
}


//flag에 따라 다른 값 반환하기
//제출 내역
//문제 설명
//두 정수 a, b와 boolean 변수 flag가 매개변수로 주어질 때, flag가 true면 a + b를 false면 a - b를 return 하는 solution 함수를 작성해 주세요.
//
//제한사항
//-1,000 ≤ a, b ≤ 1,000

class Solution {
    public int solution(int a, int b, boolean flag) {
        int answer = 0;
        
        answer = flag == true ? a + b : a - b;
        
        return answer;
    }
}