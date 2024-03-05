//마지막 두 원소
//        제출 내역
//        문제 설명
//        정수 리스트 num_list가 주어질 때, 마지막 원소가 그전 원소보다 크면 마지막 원소에서 그전 원소를 뺀 값을 마지막 원소가 그전 원소보다 크지 않다면 마지막 원소를 두 배한 값을 추가하여 return하도록 solution 함수를 완성해주세요.
//
//        제한사항
//        2 ≤ num_list의 길이 ≤ 10
//        1 ≤ num_list의 원소 ≤ 9

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer;
        int listLen = num_list.length;

        answer = new int[listLen + 1]; // answer은 num_list보다 1개 더 큰 리스트

        int i = 0;
        for(int num : num_list) {
            answer[i] = num;
            i++;
        }

        // if(num_list[listLen-1] > num_list[listLen-2]) answer[listLen] = num_list[listLen-1] - num_list[listLen-2];
        // else answer[listLen] =  num_list[listLen-1]*2;

        answer[listLen] = (num_list[listLen-1] > num_list[listLen-2]) ? num_list[listLen-1] - num_list[listLen-2] :  num_list[listLen-1]*2;

        return answer;
    }
}


//    수 조작하기 1
//        제출 내역
//        문제 설명
//        정수 n과 문자열 control이 주어집니다. control은 "w", "a", "s", "d"의 4개의 문자로 이루어져 있으며, control의 앞에서부터 순서대로 문자에 따라 n의 값을 바꿉니다.
//
//        "w" : n이 1 커집니다.
//        "s" : n이 1 작아집니다.
//        "d" : n이 10 커집니다.
//        "a" : n이 10 작아집니다.
//        위 규칙에 따라 n을 바꿨을 때 가장 마지막에 나오는 n의 값을 return 하는 solution 함수를 완성해 주세요.
//
//        제한사항
//        -100,000 ≤ n ≤ 100,000
//        1 ≤ control의 길이 ≤ 100,000
//        control은 알파벳 소문자 "w", "a", "s", "d"로 이루어진 문자열입니다.

class Solution {
    public int solution(int n, String control) {
        n += countChar(control, 'w') * 1;
        n -= countChar(control, 's') * 1;
        n += countChar(control, 'd') * 10;
        n -= countChar(control, 'a') * 10;

        return n ;
    }
    public static long countChar(String str, char ch) {
        return str.chars()
                .filter(c -> c == ch)
                .count();
    }
}

//
//for(char c : control.toCharArray()){
//        n += c == 'w' ? 1 : c == 's' ? -1 : c == 'd' ? 10 : -10;
//        }
//        return n;


//    수 조작하기 2
//        제출 내역
//        문제 설명
//        정수 배열 numLog가 주어집니다. 처음에 numLog[0]에서 부터 시작해 "w", "a", "s", "d"로 이루어진 문자열을 입력으로 받아 순서대로 다음과 같은 조작을 했다고 합시다.
//
//        "w" : 수에 1을 더한다.
//        "s" : 수에 1을 뺀다.
//        "d" : 수에 10을 더한다.
//        "a" : 수에 10을 뺀다.
//        그리고 매번 조작을 할 때마다 결괏값을 기록한 정수 배열이 numLog입니다. 즉, numLog[i]는 numLog[0]로부터 총 i번의 조작을 가한 결과가 저장되어 있습니다.
//
//        주어진 정수 배열 numLog에 대해 조작을 위해 입력받은 문자열을 return 하는 solution 함수를 완성해 주세요.
//
//        제한사항
//        2 ≤ numLog의 길이 ≤ 100,000
//        -100,000 ≤ numLog[0] ≤ 100,000
//        1 ≤ i ≤ numLog의 길이인 모든 i에 대해 |numLog[i] - numLog[i - 1]|의 값은 1 또는 10입니다.

class Solution {
    public String solution(int[] numLog) {
        StringBuilder answer = new StringBuilder();

        for(int i = 1; i < numLog.length; i++) {

            if(numLog[i] - numLog[i-1] == 1) answer.append("w");
            if(numLog[i] - numLog[i-1] == -1) answer.append("s");
            if(numLog[i] - numLog[i-1] == 10) answer.append("d");
            if(numLog[i] - numLog[i-1] == -10) answer.append("a");


        }
        return String.valueOf(answer);
    }
}


//    수열과 구간 쿼리 3
//        제출 내역
//        문제 설명
//        정수 배열 arr와 2차원 정수 배열 queries이 주어집니다. queries의 원소는 각각 하나의 query를 나타내며, [i, j] 꼴입니다.
//
//        각 query마다 순서대로 arr[i]의 값과 arr[j]의 값을 서로 바꿉니다.
//
//        위 규칙에 따라 queries를 처리한 이후의 arr를 return 하는 solution 함수를 완성해 주세요.
//
//        제한사항
//        1 ≤ arr의 길이 ≤ 1,000
//        0 ≤ arr의 원소 ≤ 1,000,000
//        1 ≤ queries의 길이 ≤ 1,000
//        0 ≤ i < j < arr의 길이

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[arr.length];

        for (int[] query : queries){
            int stay = arr[query[0]]; // 기존 arr[query[0]] 저장
            arr[query[0]] = arr[query[1]];
            arr[query[1]] = stay;
        }

        return arr;
    }
}


//    수열과 구간 쿼리 2
//        제출 내역
//        문제 설명
//        정수 배열 arr와 2차원 정수 배열 queries이 주어집니다. queries의 원소는 각각 하나의 query를 나타내며, [s, e, k] 꼴입니다.
//
//        각 query마다 순서대로 s ≤ i ≤ e인 모든 i에 대해 k보다 크면서 가장 작은 arr[i]를 찾습니다.
//
//        각 쿼리의 순서에 맞게 답을 저장한 배열을 반환하는 solution 함수를 완성해 주세요.
//        단, 특정 쿼리의 답이 존재하지 않으면 -1을 저장합니다.
//
//        제한사항
//        1 ≤ arr의 길이 ≤ 1,000
//        0 ≤ arr의 원소 ≤ 1,000,000
//        1 ≤ queries의 길이 ≤ 1,000
//        0 ≤ s ≤ e < arr의 길이
//        0 ≤ k ≤ 1,000,000

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int count = 0;

        for(int[] query : queries){

            int chk   = 0;
            int start = query[0];
            int end   = query[1] + 1;
            int key   = query[2];

            int[] a = Arrays.copyOfRange(arr,start,end);
            Arrays.sort(a);

            for(int i = 0; i < end - start; i++){
                if(a[i] > key) {
                    answer[count] = a[i];
                    break;
                }else chk++;
            }

            if(chk == end - start) answer[count] = -1;
            count++;
        }

        return answer;
    }
}