package org.Y2024.M06.D26;
//    문제
//    유현이가 새 집으로 이사했다. 새 집의 크기는 N×N의 격자판으로 나타낼 수 있고, 1×1크기의 정사각형 칸으로 나누어져 있다.
//    각각의 칸은 (r, c)로 나타낼 수 있다. 여기서 r은 행의 번호, c는 열의 번호이고, 행과 열의 번호는 1부터 시작한다. 각각의 칸은 빈 칸이거나 벽이다.
//
//    오늘은 집 수리를 위해서 파이프 하나를 옮기려고 한다. 파이프는 아래와 같은 형태이고, 2개의 연속된 칸을 차지하는 크기이다.

//    파이프는 회전시킬 수 있으며, 아래와 같이 3가지 방향이 가능하다.

//    파이프는 매우 무겁기 때문에, 유현이는 파이프를 밀어서 이동시키려고 한다. 벽에는 새로운 벽지를 발랐기 때문에, 파이프가 벽을 긁으면 안 된다.
//    즉, 파이프는 항상 빈 칸만 차지해야 한다.
//
//    파이프를 밀 수 있는 방향은 총 3가지가 있으며, →, ↘, ↓ 방향이다. 파이프는 밀면서 회전시킬 수 있다. 회전은 45도만 회전시킬 수 있으며,
//    미는 방향은 오른쪽, 아래, 또는 오른쪽 아래 대각선 방향이어야 한다.
//
//    파이프가 가로로 놓여진 경우에 가능한 이동 방법은 총 2가지, 세로로 놓여진 경우에는 2가지, 대각선 방향으로 놓여진 경우에는 3가지가 있다.
//
//    아래 그림은 파이프가 놓여진 방향에 따라서 이동할 수 있는 방법을 모두 나타낸 것이고, 꼭 빈 칸이어야 하는 곳은 색으로 표시되어져 있다.

//
//    가장 처음에 파이프는 (1, 1)와 (1, 2)를 차지하고 있고, 방향은 가로이다. 파이프의 한쪽 끝을 (N, N)로 이동시키는 방법의 개수를 구해보자.
//
//    입력
//    첫째 줄에 집의 크기 N(3 ≤ N ≤ 16)이 주어진다. 둘째 줄부터 N개의 줄에는 집의 상태가 주어진다. 빈 칸은 0, 벽은 1로 주어진다.
//    (1, 1)과 (1, 2)는 항상 빈 칸이다.
//
//    출력
//    첫째 줄에 파이프의 한쪽 끝을 (N, N)으로 이동시키는 방법의 수를 출력한다. 이동시킬 수 없는 경우에는 0을 출력한다.
//    방법의 수는 항상 1,000,000보다 작거나 같다.
public class q2024091002 {

    //    static boolean[][] visited;
    static int[][] gmaps;
    static int answer = 0;
    public static int solution(int N, int[][] maps){
        // 45도만 꺾을 수 있다.
        // BFS를 통해서 모든 경우의 수 확인
        // visited 사용해 들린 곳 x
        // 가로로 먼저 시작
        // 대각선 or 가로로 밖에 불가능
        // 이전이 가로 -> 다음에는 대각(오른쪽), 가로
        // 이전이 대각선 -> 다음에는 세로, 대각(오른쪽), 가로
        // 이전이 세로 -> 다음에는 세로, 대각(오른쪽)

        boolean[][] visited = new boolean[N][N];
        gmaps = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                gmaps[i][j] = maps[i][j];
            }
        }

        visited[0][0] = true;
        visited[0][1] = true;

        calc(0, 1, N, 'r', visited);

        return answer;
    }
    //
    // past
//    가로 : r
//    대각 : s
//    세로 : h
    private static void calc(int x, int y, int N, char past, boolean[][] visited){
        if(x == N-1 && y == N-1) {
            answer++;
            return;
        }

        if(past == 'r'){        // 대각(오른쪽), 가로
            // 대각
            int sx = x + 1;
            int sy = y + 1;

            if(validChk(sx,sy,N,visited,'s')){
                visited[sx][sy] = true;
                calc(sx, sy, N, 's', visited);
                visited[sx][sy] = false;

            }
            // 가로
            int rx = x;
            int ry = y + 1;

            if(validChk(rx,ry,N,visited,'r')){
                visited[rx][ry] = true;
                calc(rx, ry, N, 'r', visited);
                visited[rx][ry] = false;
            }

        }else if(past == 's'){  // 세로, 대각(오른쪽), 가로
            // 대각
            int sx = x + 1;
            int sy = y + 1;

            if(validChk(sx,sy,N,visited,'s')){
                visited[sx][sy] = true;
                calc(sx, sy, N, 's', visited);
                visited[sx][sy] = false;

            }
            // 가로
            int rx = x;
            int ry = y + 1;

            if(validChk(rx,ry,N,visited,'r')){
                visited[rx][ry] = true;
                calc(rx, ry, N, 'r', visited);
                visited[rx][ry] = false;

            }
            // 세로
            int hx = x + 1;
            int hy = y;

            if(validChk(hx,hy,N,visited,'h')){
                visited[hx][hy] = true;
                calc(hx, hy, N, 'h', visited);
                visited[hx][hy] = false;
            }
        }else{                  // 세로, 대각(오른쪽)
            // 대각
            int sx = x + 1;
            int sy = y + 1;

            if(validChk(sx,sy,N,visited,'s')){
                visited[sx][sy] = true;
                calc(sx, sy, N, 's', visited);
                visited[sx][sy] = false;
            }

            // 세로
            int hx = x + 1;
            int hy = y;

            if(validChk(hx,hy,N,visited,'h')) {
                visited[hx][hy] = true;
                calc(hx, hy, N, 'h', visited);
                visited[hx][hy] = false;
            }
        }

    }

    private static boolean validChk(int x, int y, int N, boolean[][] visited, char past){
        if(x < 0 || x > N - 1 || y < 0 || y > N - 1) return false;
        if(visited[x][y]) return false;
        if(gmaps[x][y] == 1) return false;
        if(past == 's'){
            if(gmaps[x-1][y] == 1 || gmaps[x][y-1] == 1) return false;
        }

        return true;
    }
}


package org.Y2024.M06.D26;
//    문제
//    길이가 N인 수식이 있다. 수식은 0보다 크거나 같고, 9보다 작거나 같은 정수와 연산자(+, -, ×)로 이루어져 있다.
//    연산자 우선순위는 모두 동일하기 때문에, 수식을 계산할 때는 왼쪽에서부터 순서대로 계산해야 한다. 예를 들어, 3+8×7-9×2의 결과는 136이다.
//
//    수식에 괄호를 추가하면, 괄호 안에 들어있는 식은 먼저 계산해야 한다. 단, 괄호 안에는 연산자가 하나만 들어 있어야 한다.
//    예를 들어, 3+8×7-9×2에 괄호를 3+(8×7)-(9×2)와 같이 추가했으면, 식의 결과는 41이 된다. 하지만, 중첩된 괄호는 사용할 수 없다.
//    즉, 3+((8×7)-9)×2, 3+((8×7)-(9×2))은 모두 괄호 안에 괄호가 있기 때문에, 올바른 식이 아니다.
//
//    수식이 주어졌을 때, 괄호를 적절히 추가해 만들 수 있는 식의 결과의 최댓값을 구하는 프로그램을 작성하시오. 추가하는 괄호 개수의 제한은 없으며,
//    추가하지 않아도 된다.
//
//    입력
//    첫째 줄에 수식의 길이 N(1 ≤ N ≤ 19)가 주어진다. 둘째 줄에는 수식이 주어진다. 수식에 포함된 정수는 모두 0보다 크거나 같고, 9보다 작거나 같다.
//    문자열은 정수로 시작하고, 연산자와 정수가 번갈아가면서 나온다. 연산자는 +, -, * 중 하나이다. 여기서 *는 곱하기 연산을 나타내는 × 연산이다.
//    항상 올바른 수식만 주어지기 때문에, N은 홀수이다.
//
//    출력
//    첫째 줄에 괄호를 적절히 추가해서 얻을 수 있는 결과의 최댓값을 출력한다. 정답은 231보다 작고, -231보다 크다.

        import java.util.ArrayList;
        import java.util.LinkedList;
        import java.util.*;

//      9
//      3+8*7-9*2    136
public class q2024091001 {


    static int answer = Integer.MIN_VALUE;
    static List<Integer> num = new ArrayList<>();
    static List<Character> op = new ArrayList<>();
    public static int solution(int N, String num_list){


        // i가 홀수 일 때, 연산자 알 수 있음
        int minus_cnt = 0;
        for(int i = 0; i < N; i++){
            if(i % 2 != 0){
                op.add(num_list.charAt(i));
            }else{
                num.add(num_list.charAt(i) -'0');
            }
        }

        dfs(0, num.get(0));

        return answer;
    }

    public static void dfs(int cnt, int sol){
        if(cnt >= op.size()) {
            answer = Math.max(answer, sol);
            return;
        }else{
            char now_op = op.get(cnt);

            int one = calc(sol, now_op, num.get(cnt+1));
            dfs(cnt + 1, one);
            if(cnt+1 < op.size()) {
                int two = calc(num.get(cnt + 1), op.get(cnt + 1), num.get(cnt + 2));
                int result = calc(sol, now_op, two);

                dfs(cnt + 2, result);
            }
        }
    }

    public static int calc(int start, char calculor, int end){
        if(calculor == '+'){
            return start + end;
        }else if(calculor == '-'){
            return start - end;
        }else{
            return start * end;
        }
    }
}
