package com.org.fcss01.controller;

//타겟 넘버
//제출 내역
//문제 설명
//n개의 음이 아닌 정수들이 있습니다. 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
//
//제한사항
//주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
//각 숫자는 1 이상 50 이하인 자연수입니다.
//타겟 넘버는 1 이상 1000 이하인 자연수입니다.
public class q20240907 {
    private static int answer = 0;
    private static int numbers_len = 0;
    public int solution(int[] numbers, int target) {
        numbers_len = numbers.length;

        calc(0, 0, numbers, target);

        return answer;
    }

    public static void calc(int num, int sum, int[] numbers, int target){
        if(numbers_len == num){
            if(sum == target) answer++;
            return;
        }else{
            calc(num + 1, sum + numbers[num], numbers, target);
            calc(num + 1, sum - numbers[num], numbers, target);
        }

    }
}

package com.org.fcss01.controller;

        import java.util.LinkedList;
        import java.util.Queue;

//        게임 맵 최단거리
//        제출 내역
//        문제 설명
//        ROR 게임은 두 팀으로 나누어서 진행하며, 상대 팀 진영을 먼저 파괴하면 이기는 게임입니다. 따라서, 각 팀은 상대 팀 진영에 최대한 빨리 도착하는 것이 유리합니다.
//
//        지금부터 당신은 한 팀의 팀원이 되어 게임을 진행하려고 합니다. 다음은 5 x 5 크기의 맵에, 당신의 캐릭터가 (행: 1, 열: 1) 위치에 있고,
//        상대 팀 진영은 (행: 5, 열: 5) 위치에 있는 경우의 예시입니다.
//
//
//        위 그림에서 검은색 부분은 벽으로 막혀있어 갈 수 없는 길이며, 흰색 부분은 갈 수 있는 길입니다. 캐릭터가 움직일 때는 동, 서, 남, 북 방향으로 한 칸씩 이동하며,
//        게임 맵을 벗어난 길은 갈 수 없습니다.
//        아래 예시는 캐릭터가 상대 팀 진영으로 가는 두 가지 방법을 나타내고 있습니다.
//
//        첫 번째 방법은 11개의 칸을 지나서 상대 팀 진영에 도착했습니다.
//        최단거리2_hnjd3b.png
//
//        두 번째 방법은 15개의 칸을 지나서 상대팀 진영에 도착했습니다.
//        최단거리3_ntxygd.png
//
//        위 예시에서는 첫 번째 방법보다 더 빠르게 상대팀 진영에 도착하는 방법은 없으므로, 이 방법이 상대 팀 진영으로 가는 가장 빠른 방법입니다.
//
//        만약, 상대 팀이 자신의 팀 진영 주위에 벽을 세워두었다면 상대 팀 진영에 도착하지 못할 수도 있습니다. 예를 들어, 다음과 같은 경우에 당신의 캐릭터는 상대 팀 진영에 도착할 수 없습니다.
//
//        최단거리4_of9xfg.png
//
//        게임 맵의 상태 maps가 매개변수로 주어질 때, 캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 return 하도록 solution 함수를 완성해주세요.
//        단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return 해주세요.
//
//        제한사항
//        maps는 n x m 크기의 게임 맵의 상태가 들어있는 2차원 배열로, n과 m은 각각 1 이상 100 이하의 자연수입니다.
//        n과 m은 서로 같을 수도, 다를 수도 있지만, n과 m이 모두 1인 경우는 입력으로 주어지지 않습니다.
//        maps는 0과 1로만 이루어져 있으며, 0은 벽이 있는 자리, 1은 벽이 없는 자리를 나타냅니다.
//        처음에 캐릭터는 게임 맵의 좌측 상단인 (1, 1) 위치에 있으며, 상대방 진영은 게임 맵의 우측 하단인 (n, m) 위치에 있습니다.
        import java.util.*;

class Solution {
    static int[] xx = {-1, 1, 0, 0};
    static int[] yy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;

        // 초기화
        int[][] mapslen = new int[N][M];
        mapslen[0][0] = 1;
        calc(N, M, maps, mapslen);

        int min = mapslen[N-1][M-1];

        if(min == 0) min = -1;

        return min;
    }

    public static void calc(int N, int M, int[][] maps, int[][] mapslen){

        int x = 0;
        int y = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nx = now[0];
            int ny = now[1];

            for (int i = 0; i < 4; i++) {

                int cx = nx + xx[i];
                int cy = ny + yy[i];

                if (cx < 0 || cx > N - 1 || cy < 0 || cy > M - 1) continue; // 사각을 넘어갔을 경우
                if (maps[cx][cy] == 0) continue;    // 벽일 경우
                if (mapslen[cx][cy] != 0) continue; // 방문 여부

                mapslen[cx][cy] = mapslen[nx][ny] + 1;

                q.add(new int[]{cx, cy});
            }
        }
    }

}
