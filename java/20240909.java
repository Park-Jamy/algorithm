package org.Y2024.M06.D26;
//    문제
//    눈금의 간격이 1인 M×N(M,N≤100)크기의 모눈종이가 있다. 이 모눈종이 위에 눈금에 맞추어 K개의 직사각형을 그릴 때,
//    이들 K개의 직사각형의 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어진다.
//
//    예를 들어 M=5, N=7 인 모눈종이 위에 <그림 1>과 같이 직사각형 3개를 그렸다면,
//    그 나머지 영역은 <그림 2>와 같이 3개의 분리된 영역으로 나누어지게 된다.
//
//
//
//    <그림 2>와 같이 분리된 세 영역의 넓이는 각각 1, 7, 13이 된다.
//
//    M, N과 K 그리고 K개의 직사각형의 좌표가 주어질 때, K개의 직사각형 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어지는지,
//    그리고 분리된 각 영역의 넓이가 얼마인지를 구하여 이를 출력하는 프로그램을 작성하시오.
//
//    입력
//    첫째 줄에 M과 N, 그리고 K가 빈칸을 사이에 두고 차례로 주어진다. M, N, K는 모두 100 이하의 자연수이다.
//    둘째 줄부터 K개의 줄에는 한 줄에 하나씩 직사각형의 왼쪽 아래 꼭짓점의 x, y좌표값과 오른쪽 위 꼭짓점의 x, y좌표값이 빈칸을 사이에 두고 차례로 주어진다.
//    모눈종이의 왼쪽 아래 꼭짓점의 좌표는 (0,0)이고, 오른쪽 위 꼭짓점의 좌표는(N,M)이다. 입력되는 K개의 직사각형들이 모눈종이 전체를 채우는 경우는 없다.
//
//    출력
//    첫째 줄에 분리되어 나누어지는 영역의 개수를 출력한다. 둘째 줄에는 각 영역의 넓이를 오름차순으로 정렬하여 빈칸을 사이에 두고 출력한다.

import java.util.*;
import java.util.List;

//5 7 3
//0 2 4 4
//1 1 2 5
//4 0 6 2
public class q2024090901 {

    private static int[][] ractangles;
    private static boolean[][] visited;
    private static int[] cx = {-1, 1, 0, 0};
    private static int[] cy = {0, 0, -1, 1};
    private static List<Integer> li = new ArrayList<>();

    private static int sum = 0;

    public static void solution(int N, int M, int K, int[][] racs){
        ractangles = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < K; i++){
            int x1 = racs[i][1];
            int y1 = racs[i][0];
            int x2 = racs[i][3];
            int y2 = racs[i][2];

            calc(x1, y1, x2, y2);
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(ractangles[i][j] == 1 || visited[i][j]) continue;
                visited[i][j] = true;
                sum = 1;
                BFS(i, j, N, M);
                li.add(sum);
            }
        }

        int[] a = li.stream().mapToInt(i -> i).toArray();
        Arrays.sort(a);
        for(int i : a){
            System.out.println(i);
        }

    }
    public static void calc(int x1, int y1, int x2, int y2){
        for(int i = x1; i < x2 ; i++){
            for(int j = y1; j < y2; j++){
                ractangles[i][j] = 1;
            }
        }
    }

    public static void BFS(int x, int y, int N, int M){
        for(int i = 0; i < 4; i++){
            int nx = x + cx[i];
            int ny = y + cy[i];

            if( nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1) continue;
            if(visited[nx][ny]) continue;
            if(ractangles[nx][ny] == 1) continue;

            visited[nx][ny] = true;

            sum++;

            BFS(nx, ny, N, M);
        }
    }
}

package org.Y2024.M06.D26;
//    촌수계산
//    시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//    1 초	128 MB	56970	29290	21989	50.674%
//    문제
//    우리 나라는 가족 혹은 친척들 사이의 관계를 촌수라는 단위로 표현하는 독특한 문화를 가지고 있다.
//    이러한 촌수는 다음과 같은 방식으로 계산된다. 기본적으로 부모와 자식 사이를 1촌으로 정의하고 이로부터 사람들 간의 촌수를 계산한다.
//    예를 들면 나와 아버지, 아버지와 할아버지는 각각 1촌으로 나와 할아버지는 2촌이 되고, 아버지 형제들과 할아버지는 1촌, 나와 아버지 형제들과는 3촌이 된다.
//
//    여러 사람들에 대한 부모 자식들 간의 관계가 주어졌을 때, 주어진 두 사람의 촌수를 계산하는 프로그램을 작성하시오.
//
//    입력
//    사람들은 1, 2, 3, …, n (1 ≤ n ≤ 100)의 연속된 번호로 각각 표시된다. 입력 파일의 첫째 줄에는 전체 사람의 수 n이 주어지고,
//    둘째 줄에는 촌수를 계산해야 하는 서로 다른 두 사람의 번호가 주어진다.
//    그리고 셋째 줄에는 부모 자식들 간의 관계의 개수 m이 주어진다.
//    넷째 줄부터는 부모 자식간의 관계를 나타내는 두 번호 x,y가 각 줄에 나온다. 이때 앞에 나오는 번호 x는 뒤에 나오는 정수 y의 부모 번호를 나타낸다.
//
//    각 사람의 부모는 최대 한 명만 주어진다.
//
//    출력
//    입력에서 요구한 두 사람의 촌수를 나타내는 정수를 출력한다. 어떤 경우에는 두 사람의 친척 관계가 전혀 없어 촌수를 계산할 수 없을 때가 있다.
//    이때에는 -1을 출력해야 한다.

        import java.util.*;
public class q2024090902 {
    private static boolean[] chk;
    public static int solution(int N, int[] M, int K, int[][] net){
        Queue<Integer> q = new LinkedList<>();
        chk = new boolean[K];
        boolean ok = false;
        int cnt = 0;

        q.add(M[0]);

        while(!q.isEmpty()){
            int now = q.remove();


            for(int i = 0; i < K; i++){
                if(chk[i]) continue;


                if(net[i][1] == now) {
                    cnt++;
                    q.add(net[i][0]);
                    chk[i] = true;

                    if(net[i][0] == M[1]) {
                        ok = true;
                        break;
                    }

                } else if(net[i][0] == now) {
                    cnt++;
                    q.add(net[i][1]);
                    chk[i] = true;

                    if(net[i][1] == M[1]) {
                        ok = true;
                        break;
                    }
                }
            }
        }
        if(!ok) cnt = -1;

        return cnt;
    }
}
