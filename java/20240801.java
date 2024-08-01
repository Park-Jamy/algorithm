package org.Y2024.M06.D26;

import java.util.ArrayList;
import java.util.List;

//문제
//<그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
//
//
//
//        입력
//        첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
//
//        출력
//        첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
public class q2024080101 {
    static int[] nx = {-1, 1, 0, 0};
    static int[] ny = {0, 0, -1, 1};

    static boolean[][] visited;

    static int sum = 0;

    public static int[] solution(int[][] apts){

        int[] result;

        int N = apts.length;
        int M = apts[0].length;

        List<Integer> list = new ArrayList<>();

        visited = new boolean[N][M];
        int count = 0; // 단지 갯수
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j]){
                    if(apts[i][j] == 1){
                        visited[i][j] = true;
                        count++;
                        sum = 1;
                        calc(j, i, N, M, apts);

                        list.add(sum);
                    }
                }
            }
        }

        result = list.stream().mapToInt(i->i).sorted().toArray();

        return result;
    }

    public static void calc(int x, int y, int N, int M, int[][] apts){
        for(int i = 0; i < 4; i++){
            int cx = x + nx[i];
            int cy = y + ny[i];

            if(cx < 0 || cx > M - 1 || cy < 0 || cy > N - 1){
                continue;
            }

            if(visited[cy][cx]){
                continue;
            }

            if(apts[cy][cx] == 0){
                continue;
            }
            sum++;
            visited[cy][cx] = true;

            calc(cx, cy, N, M, apts);
        }
    }
}


package org.Y2024.M06.D26;
//문제
//        정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
//
//        1+1+1+1
//        1+1+2
//        1+2+1
//        2+1+1
//        2+2
//        1+3
//        3+1
//        정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
//
//        입력
//        첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 11보다 작다.
//
//        출력
//        각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.
public class q2024080102 {
    static int[] dp;

    public static int solution(int n){

        // 4라면
        // 3 까지의 테스트 케이스 수 + 2 까지의 테스트 케이스 수 + 1 까지의 테스트 케이스 수

        dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        return dp[n];
    }
}
