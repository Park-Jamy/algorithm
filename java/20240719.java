package org.Y2024.M06.D26;

public class q2024071901 {
    public static int solution(int[][] triangle){
        int n = triangle.length;// 확인 해야 하는 길이

        // 내려가면서 값을 저장할 공간
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        // 위에서 부터 i 번째 줄
        for(int i = 1; i < n; i++){
            // 가로 줄로 i 번째
            for(int j = 0; j < i + 1; j++){
                if(j == 0){
                    dp[i][j] = triangle[i][j] + dp[i-1][j];
                }else if(j == i){
                    dp[i][j] = triangle[i][j] + dp[i-1][j-1];
                }else{
                    dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j], dp[i-1][j-1]);
                }
            }
        }
        int result = 0;

        for(int r : dp[n-1]){
            if(result < r) result = r;
        }

        return result;
    }
}


package org.Y2024.M06.D26;

public class q2024071902 {
    public static int solution(int[][] land){
        int h = land.length;// 높이

        int[][] dp = new int[h][4]; // 내려가면서 최댓값 저장하는 공간

        // 첫번째 줄 저장되어 있는 값으로 초기화
        for(int i = 0; i < 4; i++){
            dp[0][i] = land[0][i];
        }

        for(int i = 1; i < h; i++){
            for(int j = 0; j < 4; j++){

                int max = 0;

                for(int k = 0; k < 4; k++){
                    if( k != j && max < dp[i-1][k]) max = dp[i-1][k];
                }

                dp[i][j] = max + land[i][j];
            }
        }

        int result = 0;

        for(int re : dp[h-1]){
            if(result < re) result = re;
        }

        return 0;
    }
}

package org.Y2024.M06.D26;

public class q2024071903 {
    public static int solution(int[][] board){
        int h = board.length;
        int w = board[0].length;

        int[][] dp = new int[h][w];

        for(int i = 0; i < h; i++){
            dp[i][0] = board[i][0];
        }

        for(int i = 0; i < w; i++){
            dp[0][i] = board[0][i];
        }

        // 0 인 값은 넘어가기
        // 1 인 값에서 시작
        // 본인 포함 왼쪽 기준으로 1이 몇개가 있는지 확인
        // 본인 포함 윗쪽 기준으로 1의 개수가 동일한 만큼 max 값 갱신

        // i번째줄 체크
        for(int i = 1; i < h; i++){
            for(int j = 1; j < w; j++){

                // 현재 값이 0일 경우 넘어가기
                if(board[i][j] == 0) continue;

                dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])) + 1;
            }
        }

        int result = 0;
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(result < dp[i][j]) result = dp[i][j];
            }
        }
        return (int) Math.pow(result, 2);
    }
}

package org.Y2024.M06.D26;


//문제
//        삼각형의 세 변의 길이가 주어질 때 변의 길이에 따라 다음과 같이 정의한다.
//
//        Equilateral :  세 변의 길이가 모두 같은 경우
//        Isosceles : 두 변의 길이만 같은 경우
//        Scalene : 세 변의 길이가 모두 다른 경우
//        단 주어진 세 변의 길이가 삼각형의 조건을 만족하지 못하는 경우에는 "Invalid" 를 출력한다.
//        예를 들어 6, 3, 2가 이 경우에 해당한다. 가장 긴 변의 길이보다 나머지 두 변의 길이의 합이 길지 않으면 삼각형의 조건을 만족하지 못한다.
//
//        세 변의 길이가 주어질 때 위 정의에 따른 결과를 출력하시오.
//
//        입력
//        각 줄에는 1,000을 넘지 않는 양의 정수 3개가 입력된다. 마지막 줄은 0 0 0이며 이 줄은 계산하지 않는다.
//
//        출력
//        각 입력에 맞는 결과 (Equilateral, Isosceles, Scalene, Invalid) 를 출력하시오.

        import java.util.Scanner;

public class q2024071904 {
    public static String[] solution(int[][] list){
        int a = list.length;
        int b = list[0].length;

        String[] result = new String[a];

        for(int i = 0; i < a; i++){
            int[] li = list[i];

            int count = 0;

            if(li[0] == 0 || li[2] == 0 || li[1] == 0)
                result[i] = "Invalid";

            if(li[0] + li[1] < li[2] || li[2] + li[1] < li[0] || li[0] + li[2] < li[1])
                result[i] = "Invalid";

            if(li[0] == li[1] || li[2] == li[1] || li[2] == li[0]){
                count++;
            }

            if(count == 0) result[i] = "Scalene";
            else if(count == 1) result[i] = "Isosceles";
            else if(count == 3) result[i] = "Equilateral";
        }

        return result;
    }
}
