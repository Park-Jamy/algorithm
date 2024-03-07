//수열과 구간 쿼리 4
//        제출 내역
//        문제 설명
//        정수 배열 arr와 2차원 정수 배열 queries이 주어집니다. queries의 원소는 각각 하나의 query를 나타내며, [s, e, k] 꼴입니다.
//
//        각 query마다 순서대로 s ≤ i ≤ e인 모든 i에 대해 i가 k의 배수이면 arr[i]에 1을 더합니다.
//
//        위 규칙에 따라 queries를 처리한 이후의 arr를 return 하는 solution 함수를 완성해 주세요.
//
//        제한사항
//        1 ≤ arr의 길이 ≤ 1,000
//        0 ≤ arr의 원소 ≤ 1,000,000
//        1 ≤ queries의 길이 ≤ 1,000
//        0 ≤ s ≤ e < arr의 길이
//        0 ≤ k ≤ 5

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[arr.length];


        for(int[] query : queries){
            int s = query[0];
            int e = query[1];
            int k = query[2];

            for(int i = s; i <= e; i++){
                if(i % k == 0) arr[i]++;
            }
        }

        return arr;
    }
}


//배열 만들기 2
//        제출 내역
//        문제 설명
//        정수 l과 r이 주어졌을 때, l 이상 r이하의 정수 중에서 숫자 "0"과 "5"로만 이루어진 모든 정수를 오름차순으로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.
//
//        만약 그러한 정수가 없다면, -1이 담긴 배열을 return 합니다.
//
//        제한사항
//        1 ≤ l ≤ r ≤ 1,000,000

import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(int l, int r) {
        int[] answer;

        List<Integer> chkList = new ArrayList<Integer>();

        for(int i = 1; i <= 64; i++){
            int chk = Integer.valueOf(Integer.toBinaryString(i)) * 5;
            if( l <= chk && chk <= r ) chkList.add(chk);
        }

        if(chkList.size() == 0) {
            answer = new int[1];
            answer[0] = -1;
        }
        else {
            answer = new int[chkList.size()];

            for(int i = 0; i < chkList.size(); i++) answer[i] = chkList.get(i);
        }

        return answer;
    }
}

//    카운트 업
//    제출 내역
//    문제 설명
//    정수 start_num와 end_num가 주어질 때, start_num부터 end_num까지의 숫자를 차례로 담은 리스트를 return하도록 solution 함수를 완성해주세요.
//
//        제한사항
//        0 ≤ start_num ≤ end_num ≤ 50

class Solution {
    public int[] solution(int start_num, int end_num) {
        int[] answer = new int[end_num - start_num + 1];

        for(int i = start_num; i <= end_num; i++) {
            answer[i - start_num] = i;
        }
        //return IntStream.rangeClosed(start, end).toArray();
        return answer;
    }
}

