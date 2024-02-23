//    덧셈식 출력하기
//            제출 내역
//            문제 설명
//            두 정수 a, b가 주어질 때 다음과 같은 형태의 계산식을 출력하는 코드를 작성해 보세요.
//
//            a + b = c
//            제한사항
//            1 ≤ a, b ≤ 100


import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int c = a + b;

        // String c = String.format("%d + %d = %d", a, b, a+b);
        System.out.println(a + " + " + b + " = " + c);
    }
}

//    문자열 붙여서 출력하기
//        제출 내역
//        문제 설명
//        두 개의 문자열 str1, str2가 공백으로 구분되어 입력으로 주어집니다.
//        입출력 예와 같이 str1과 str2을 이어서 출력하는 코드를 작성해 보세요.
//
//        제한사항
//        1 ≤ str1, str2의 길이 ≤ 10

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();



        System.out.println( a + b );
    }
}

//    문자열 돌리기
//    제출 내역
//    문제 설명
//    문자열 str이 주어집니다.
//        문자열을 시계방향으로 90도 돌려서 아래 입출력 예와 같이 출력하는 코드를 작성해 보세요.
//
//        제한사항
//        1 ≤ str의 길이 ≤ 10

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String[] arr = a.split("");

        int arr_len = a.length();

        for(int i = 0; i < arr_len; i++){ // for (char ch : a.toCharArray())

            // System.out.println(a.charAt(i));
            System.out.println(arr[i]);
        }
    }
}

//    홀짝 구분하기
//    제출 내역
//    문제 설명
//    자연수 n이 입력으로 주어졌을 때 만약 n이 짝수이면 "n is even"을, 홀수이면 "n is odd"를 출력하는 코드를 작성해 보세요.
//
//        제한사항
//        1 ≤ n ≤ 1,000

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // System.out.print(n + " is "+(n % 2 == 0 ? "even" : "odd"));

        if( n % 2 == 0 ) { // 짝수
            System.out.println( n + " is even" );
        }else { // 홀수
            System.out.println( n + " is odd" );
        }
    }
}

//    문자열 겹쳐쓰기
//    제출 내역
//    문제 설명
//    문자열 my_string, overwrite_string과 정수 s가 주어집니다. 문자열 my_string의 인덱스 s부터 overwrite_string의 길이만큼을 문자열 overwrite_string으로 바꾼 문자열을 return 하는 solution 함수를 작성해 주세요.
//
//        제한사항
//        my_string와 overwrite_string은 숫자와 알파벳으로 이루어져 있습니다.
//        1 ≤ overwrite_string의 길이 ≤ my_string의 길이 ≤ 1,000
//        0 ≤ s ≤ my_string의 길이 - overwrite_string의 길이

class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";

        int my_len = my_string.length();
        int ov_len = overwrite_string.length();

//        String answer = my_string.substring(0, s) + overwrite_string;
//
//        if(my_string.length() > answer.length()) {
//            answer += my_string.substring(answer.length());
//        }

        for( int i = 0; i < my_len; i++){
            if( i < s || s + ov_len - 1 < i ){
                answer = answer.concat(String.valueOf(my_string.charAt(i)));
            }else {
                answer = answer.concat(String.valueOf(overwrite_string.charAt(i - s)));
            }
        }

        return answer;
    }
}