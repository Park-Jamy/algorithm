//예상 대진표
//        제출 내역
//        문제 설명
//        △△ 게임대회가 개최되었습니다. 이 대회는 N명이 참가하고, 토너먼트 형식으로 진행됩니다.
//        N명의 참가자는 각각 1부터 N번을 차례대로 배정받습니다. 그리고, 1번↔2번, 3번↔4번, ... ,
//        N-1번 ↔ N번의 참가자끼리 게임을 진행합니다. 각 게임에서 이긴 사람은 다음 라운드에 진출할 수 있습니다.
//        이때, 다음 라운드에 진출할 참가자의 번호는 다시 1번부터 N/2번을 차례대로 배정받습니다.
//        만약 1번↔2번 끼리 겨루는 게임에서 2번이 승리했다면 다음 라운드에서 1번을 부여받고,
//        3번↔4번에서 겨루는 게임에서 3번이 승리했다면 다음 라운드에서 2번을 부여받게 됩니다.
//        게임은 최종 한 명이 남을 때까지 진행됩니다.
//
//        이때, 처음 라운드에서 A번을 가진 참가자는 경쟁자로 생각하는 B번 참가자와 몇 번째 라운드에서 만나는지 궁금해졌습니다.
//        게임 참가자 수 N, 참가자 번호 A, 경쟁자 번호 B가 함수 solution의 매개변수로 주어질 때, 처음 라운드에서 A번을 가진
//        참가자는 경쟁자로 생각하는 B번 참가자와 몇 번째 라운드에서 만나는지 return 하는 solution 함수를 완성해 주세요.
//        단, A번 참가자와 B번 참가자는 서로 붙게 되기 전까지 항상 이긴다고 가정합니다.
//
//        제한사항
//        N : 21 이상 220 이하인 자연수 (2의 지수 승으로 주어지므로 부전승은 발생하지 않습니다.)
//        A, B : N 이하인 자연수 (단, A ≠ B 입니다.)

//        입출력 예
//        N	A	B	answer
//        8	4	7	3

import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while(true){

            // 다음 조 확인

            a = a % 2 == 1 ? a / 2 + 1 : a / 2;
            b = b % 2 == 1 ? b / 2 + 1 : b / 2;

            answer++;

            if( a == b ) break;
        }

        return answer;
    }
}


//    타겟 넘버
//    제출 내역
//    문제 설명
//    n개의 음이 아닌 정수들이 있습니다. 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
//    예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
//
//        -1+1+1+1+1 = 3
//        +1-1+1+1+1 = 3
//        +1+1-1+1+1 = 3
//        +1+1+1-1+1 = 3
//        +1+1+1+1-1 = 3
//        사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
//
//        제한사항
//        주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
//        각 숫자는 1 이상 50 이하인 자연수입니다.
//        타겟 넘버는 1 이상 1000 이하인 자연수입니다.

//        입출력 예
//        numbers	target	return
//        [1, 1, 1, 1, 1]	3	5
//        [4, 1, 2, 1]	4	2

import java.util.*;

class Solution {

    private static int answer = 0;

    public int solution(int[] numbers, int target) {

        // DFS
        // 확인 했는지 체크해 가며 진행
        // + a, - a 로 나누어 DFS 실행 마지막에서 target값 확인해 동일하다면 count++ 동일하지 않다면 count 변경 없음
        // 방문 여부 체크는 필요 없을 듯 하고, numbers, target, result 값을


        DFS(numbers, target, 0, 0);


        return answer;
    }

    public static void DFS(int[] numbers, int target, int result, int count){
        // 마지막 배열 수이고, result 값이 target 값과 동일하다면 answer 값을 +1 해주고 return
        if( count == numbers.length ) {
            if( result == target ) {
                answer++;
                return;
            }
            else return;
        }
        else{
            count++;
            DFS(numbers, target, result + numbers[count - 1], count);
            DFS(numbers, target, result - numbers[count - 1], count);
            return;
        }
    }
}


//    게임 맵 최단거리
//        제출 내역
//        문제 설명
//        ROR 게임은 두 팀으로 나누어서 진행하며, 상대 팀 진영을 먼저 파괴하면 이기는 게임입니다. 따라서, 각 팀은 상대 팀 진영에 최대한 빨리 도착하는 것이 유리합니다.
//
//        지금부터 당신은 한 팀의 팀원이 되어 게임을 진행하려고 합니다. 다음은 5 x 5 크기의 맵에, 당신의 캐릭터가 (행: 1, 열: 1) 위치에 있고, 상대 팀 진영은 (행: 5, 열: 5) 위치에 있는 경우의 예시입니다.
//
//        최단거리1_sxuruo.png
//
//        위 그림에서 검은색 부분은 벽으로 막혀있어 갈 수 없는 길이며, 흰색 부분은 갈 수 있는 길입니다. 캐릭터가 움직일 때는 동, 서, 남, 북 방향으로 한 칸씩 이동하며, 게임 맵을 벗어난 길은 갈 수 없습니다.
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
//        게임 맵의 상태 maps가 매개변수로 주어질 때, 캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 return 하도록 solution 함수를 완성해주세요. 단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return 해주세요.
//
//        제한사항
//        maps는 n x m 크기의 게임 맵의 상태가 들어있는 2차원 배열로, n과 m은 각각 1 이상 100 이하의 자연수입니다.
//        n과 m은 서로 같을 수도, 다를 수도 있지만, n과 m이 모두 1인 경우는 입력으로 주어지지 않습니다.
//        maps는 0과 1로만 이루어져 있으며, 0은 벽이 있는 자리, 1은 벽이 없는 자리를 나타냅니다.
//        처음에 캐릭터는 게임 맵의 좌측 상단인 (1, 1) 위치에 있으며, 상대방 진영은 게임 맵의 우측 하단인 (n, m) 위치에 있습니다.
//        입출력 예
//        maps	answer
//        [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]	11
//        [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]	-1

class Solution {

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public int solution(int[][] maps) {
        int answer = 0;

        int m = maps.length; // y
        int n = maps[0].length; // x
        // x,y을 확인할 수 있는 값
//        Map<Integer, Integer> map = new HashMap<>();
        int[][] chk = new int[m][n];


        int x = 0;
        int y = 0;
        chk[x][y] = 1;

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{x,y});

        // 상하좌우 체크
        //  0 <= x,y < n,m

        // (n,m) 위치에 오게 되면 result 값 +1 이후에 return;
        // 값이 0 인지 확인
        // 1 이라면 해당 값에 이전 값을 더함 후 상하좌우 체크

        while(!q.isEmpty()){
            int[] nowXY = q.remove();
            int nX = nowXY[0];
            int nY = nowXY[1];

            for (int i = 0; i < 4; i++) {
                int cX = nX + dx[i];
                int cY = nY + dy[i];

                if (nX < 0 || nX >= n || nY < 0 || nY >= m) {
                    continue;
                } else {
                    if( chk[nX][nY] == 0 && maps[cX][cY] == 1 ) {
                        chk[cX][cY] = chk[nX][nY] + 1;
                        q.add(new int[]{cX, cY});
                    }
                }
            }
        }

        if( chk[m-1][n-1] == 0 ) answer = 1;
        else answer = chk[m-1][n-1];


        return answer;
    }

}

