//문자열 섞기
//        제출 내역
//        문제 설명
//        길이가 같은 두 문자열 str1과 str2가 주어집니다.
//
//        두 문자열의 각 문자가 앞에서부터 서로 번갈아가면서 한 번씩 등장하는 문자열을 만들어 return 하는 solution 함수를 완성해 주세요.

class Solution {
    public String solution(String str1, String str2) {
        String answer = "";

        int str_len = str1.length();

        for(int i = 0; i < str_len; i++){
            // String.valueOf(str1.charAt(i));
            answer = answer + str1.charAt(i) + str2.charAt(i);
        }

        return answer;
    }
}


//    문자 리스트를 문자열로 변환하기
//    제출 내역
//    문제 설명
//    문자들이 담겨있는 배열 arr가 주어집니다. arr의 원소들을 순서대로 이어 붙인 문자열을 return 하는 solution함수를 작성해 주세요.
//
//        제한사항
//        1 ≤ arr의 길이 ≤ 200
//        arr의 원소는 전부 알파벳 소문자로 이루어진 길이가 1인 문자열입니다.

class Solution {
    public String solution(String[] arr) {
        String answer = "";

        int arr_len = arr.length;

        for(int i = 0; i < arr_len; i++){ // String a : arr
            answer += arr[i];
        }

        return answer; // return String.join("", arr);
    }
}


//    문자열 곱하기
//    제출 내역
//    문제 설명
//    문자열 my_string과 정수 k가 주어질 때, my_string을 k번 반복한 문자열을 return 하는 solution 함수를 작성해 주세요.
//
//        제한사항
//        1 ≤ my_string의 길이 ≤ 100
//        my_string은 영소문자로만 이루어져 있습니다.
//        1 ≤ k ≤ 100

class Solution {
    public String solution(String my_string, int k) {
        String answer = "";

        for(int i = 0; i < k; i++){
            answer += my_string;
        }

        return answer; // my_string.repeat(k);
    }
}


//    더 크게 합치기
//        제출 내역
//        문제 설명
//        연산 ⊕는 두 정수에 대한 연산으로 두 정수를 붙여서 쓴 값을 반환합니다. 예를 들면 다음과 같습니다.
//
//        12 ⊕ 3 = 123
//        3 ⊕ 12 = 312
//        양의 정수 a와 b가 주어졌을 때, a ⊕ b와 b ⊕ a 중 더 큰 값을 return 하는 solution 함수를 완성해 주세요.
//
//        단, a ⊕ b와 b ⊕ a가 같다면 a ⊕ b를 return 합니다.
//
//        제한사항
//        1 ≤ a, b < 10,000

class Solution {
    public int solution(int a, int b) {
        int answer = 0;

        String a_str = String.valueOf(a);
        String b_str = String.valueOf(b);

        String ab_str = a_str + b_str;
        String ba_str = b_str + a_str;

        int ab = Integer.valueOf(ab_str);
        int ba = Integer.valueOf(ba_str);

        //Java는 문자열 + 숫자에서 숫자를 문자열로 처리
        //int aLong = Integer.parseInt(""+a+b);
        //int bLong = Integer.parseInt(""+b+a);

        // Math.max(ab,ba)
        if(ab >= ba) answer = ab;
        else answer = ba;

        return answer;
    }
}


//    두 수의 연산값 비교하기
//    제출 내역
//    문제 설명
//연산 ⊕는 두 정수에 대한 연산으로 두 정수를 붙여서 쓴 값을 반환합니다. 예를 들면 다음과 같습니다.
//
//        12 ⊕ 3 = 123
//        3 ⊕ 12 = 312
//        양의 정수 a와 b가 주어졌을 때, a ⊕ b와 2 * a * b 중 더 큰 값을 return하는 solution 함수를 완성해 주세요.
//
//        단, a ⊕ b와 2 * a * b가 같으면 a ⊕ b를 return 합니다.
//
//        제한사항
//        1 ≤ a, b < 10,000

class Solution {
    public int solution(int a, int b) {

        int ab = Integer.valueOf(a + "" + b);
        int ab2 = 2 * a * b;


        return Math.max(ab, ab2);
    }
}