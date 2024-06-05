정수 삼각형
        제출 내역
        문제 설명

        위와 같은 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우를 찾아보려고 합니다. 아래 칸으로 이동할 때는 대각선 방향으로 한 칸 오른쪽 또는 왼쪽으로만 이동 가능합니다. 예를 들어 3에서는 그 아래칸의 8 또는 1로만 이동이 가능합니다.

        삼각형의 정보가 담긴 배열 triangle이 매개변수로 주어질 때, 거쳐간 숫자의 최댓값을 return 하도록 solution 함수를 완성하세요.

        제한사항
        삼각형의 높이는 1 이상 500 이하입니다.
        삼각형을 이루고 있는 숫자는 0 이상 9,999 이하의 정수입니다.
        입출력 예
        triangle	result
        [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]	30
//     static int result = 0;
//     static int[][] triangleGlobal;
//     static int maxCnt = 0;

//     public int solution(int[][] triangle) {
//         int answer = 0;
//         maxCnt = triangle.length; // 피라미드 전체 높이
//         triangleGlobal = triangle;

//         calc(0, triangle, 0, 0);

//         return result;
//     }

//     // cnt: 피라미드 높이
//     // triangle: 피라미드
//     // leaf: 전층 선택 순번
//     // maxCnt: 피라미드 최고 높이 maxCnt == cnt 일 경우 결과값 확인 필요
//     // sum: 현재 높이 합산 결과 값
//     static void calc(int cnt, int leaf, int sum){
//         if(maxCnt == cnt){
//             if( sum > result ) result = sum;
//             return;
//         }else{
//             int[] row = triangleGlobal[cnt]; // 현재 층의 값들 확인
//             int rowLen = row.length;

//             // 다음층으로 이동
//             calc(cnt + 1, leaf, sum + row[leaf]);
//             calc(cnt + 1, leaf + 1, sum + row[leaf]);
//         }
//     }

import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        for(int i = 1; i < triangle.length ; i++) {
            for(int j = 0; j < triangle[i].length ; j++) {

                if(j == 0) {//왼쪽 끝
                    triangle[i][j] += triangle[i-1][j];
                }
                else if(j == i) {//오른쪽 끝
                    triangle[i][j] += triangle[i-1][j-1];
                }
                else {
                    triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j-1]);
                }

                answer = Math.max(answer, triangle[i][j]);
            }
        }
        return answer;
    }
}