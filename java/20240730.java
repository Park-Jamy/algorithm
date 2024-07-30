package org.Y2024.M06.D26;
//문제
//        어떤 큰 도화지에 그림이 그려져 있을 때, 그 그림의 개수와, 그 그림 중 넓이가 가장 넓은 것의 넓이를 출력하여라. 단, 그림이라는 것은 1로 연결된 것을 한 그림이라고 정의하자. 가로나 세로로 연결된 것은 연결이 된 것이고 대각선으로 연결이 된 것은 떨어진 그림이다. 그림의 넓이란 그림에 포함된 1의 개수이다.
//
//        입력
//        첫째 줄에 도화지의 세로 크기 n(1 ≤ n ≤ 500)과 가로 크기 m(1 ≤ m ≤ 500)이 차례로 주어진다. 두 번째 줄부터 n+1 줄 까지 그림의 정보가 주어진다. (단 그림의 정보는 0과 1이 공백을 두고 주어지며, 0은 색칠이 안된 부분, 1은 색칠이 된 부분을 의미한다)
//
//        출력
//        첫째 줄에는 그림의 개수, 둘째 줄에는 그 중 가장 넓은 그림의 넓이를 출력하여라. 단, 그림이 하나도 없는 경우에는 가장 넓은 그림의 넓이는 0이다.
public class q2024073001 {
    static int[] nx = {-1, 1, 0, 0};
    static int[] ny = {0, 0, -1, 1};

    static boolean[][] visited;
    static int[] result;

    static int sum = 0;

    public static int[] solution(int[][] pictures){

        result = new int[2];
        result[0] = 0;
        result[1] = 1;

        int n = pictures.length;
        int m = pictures[0].length;

        visited = new boolean[n][m];


        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                // 그림이 있는지 체크
                if(pictures[i][j] == 1) {
                    // 이미 방문한 곳이라면 넘어감
                    if (visited[i][j]) continue;

                    // 방문 처리
                    visited[i][j] = true;
                    // 그림 개수 추가
                    result[0]++;

                    sum = 1;
                    calc(i, j, n, m, pictures);
                }

            }
        }

        return result;
    }

    public static void calc(int x, int y, int n, int m, int[][] pictures){
        for(int i = 0; i < 4; i++){
            int cx = x + nx[i];
            int cy = y + ny[i];

            if(cx < 0 || cx > m - 1 || cy < 0 || cy > n - 1){
                continue;
            }

            if(pictures[cy][cx] == 0){
                continue;
            }

            if(visited[cy][cx]){
                continue;
            }

            visited[cy][cx] = true;

            sum++;
            calc(cx, cy, n, m, pictures);
        }

        if(result[1] < sum) result[1] = sum;
    }
}


package org.Y2024.M06.D26;

        import java.util.LinkedList;
        import java.util.Queue;

//문제
//        N×M크기의 배열로 표현되는 미로가 있다.
//
//        1	0	1	1	1	1
//        1	0	1	0	1	0
//        1	0	1	0	1	1
//        1	1	1	0	1	1
//        미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
//
//        위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
//
//        입력
//        첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
//
//        출력
//        첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
class MiroPoint{
    int x;
    int y;
    int point;

    public MiroPoint(int x, int y, int point){
        this.x = x;
        this.y = y;
        this.point = point;
    }
}

public class q2024073002 {
    static int[] nx = {-1, 1, 0, 0};
    static int[] ny = {0, 0, -1, 1};

    static boolean[][] visited;


    public static int solution(int N, int M, int[][] miro) {
        int n = miro.length;
        int m = miro[0].length;

        int result = Integer.MAX_VALUE;

        visited = new boolean[n][m];

        int chk = 0;

        Queue<MiroPoint> q = new LinkedList<>();

        q.add(new MiroPoint(0,0, 1));
        visited[0][0] = true;

        while(!q.isEmpty()){
            MiroPoint mp = q.poll();

            if((mp.x == m - 1) && (mp.y == n - 1)){
                chk = 1;

                result = mp.point;

                break;
            }


            for(int i = 0; i < 4; i++){
                int cx = mp.x + nx[i];
                int cy = mp.y + ny[i];

                if(cx < 0 || cx > m - 1 || cy < 0 || cy > n - 1){
                    continue;
                }

                if(miro[cy][cx] == 0){
                    continue;
                }

                if(visited[cy][cx]){
                    continue;
                }

                visited[cy][cx] = true;

                q.add(new MiroPoint(cx, cy, mp.point+1));
            }
        }

        if(chk == 0){
            return -1;
        }else {
            return result;
        }
    }
}


package org.Y2024.M06.D26;
//        문제
//        적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못한다. 따라서, 적록색약인 사람이 보는 그림은 아닌 사람이 보는 그림과는 좀 다를 수 있다.
//
//        크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다. 그림은 몇 개의 구역으로 나뉘어져 있는데, 구역은 같은 색으로 이루어져 있다. 또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다. (색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 한다)
//
//        예를 들어, 그림이 아래와 같은 경우에
//
//        RRRBB
//        GGBBB
//        BBBRR
//        BBRRR
//        RRRRR
//        적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다. (빨강 2, 파랑 1, 초록 1) 하지만, 적록색약인 사람은 구역을 3개 볼 수 있다. (빨강-초록 2, 파랑 1)
//
//        그림이 입력으로 주어졌을 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.
//
//        입력
//        첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100)
//
//        둘째 줄부터 N개 줄에는 그림이 주어진다.
//
//        출력
//        적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의 구역의 수를 공백으로 구분해 출력한다.
public class q2024073003 {
    static int[] nx = {-1, 1, 0, 0};
    static int[] ny = {0, 0, -1, 1};

    static boolean[][] visitedYes;
    static boolean[][] visitedNo;

    public static int[] solution(char[][] colors) {
        int[] result = new int[2];
        result[0] = 0;
        result[1] = 0;

        int n = colors.length;
        int m = colors[0].length;

        visitedNo = new boolean[n][m];
        visitedYes = new boolean[n][m];


        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visitedNo[i][j]){
                    visitedNo[i][j] = true;
                    result[0]++;
                    calc(false, colors[i][j], i, j, n, m, colors);
                }
                if(!visitedYes[i][j]){
                    visitedYes[i][j] = true;
                    result[1]++;
                    calc(true, colors[i][j], i, j, n, m, colors);
                }
            }
        }

        return result;
    }

    public static void calc(boolean yesNo, char color, int x, int y, int n, int m, char[][] colors){
        for(int i = 0; i < 4; i++){
            int cx = x + nx[i];
            int cy = y + ny[i];

            if(cx < 0 || cx > m - 1 || cy < 0 || cy > n - 1){
                continue;
            }

            //적록색맹 이라면
            if(yesNo) {

                if(color == 'R' || color == 'G'){
                    if(colors[cy][cx] == 'B'){
                        continue;
                    }
                }
                if (visitedYes[cy][cx]) {
                    continue;
                }

                visitedYes[cy][cx] = true;
            }else{

                if(colors[cy][cx] != color){
                    continue;
                }

                if (visitedNo[cy][cx]) {
                    continue;
                }

                visitedNo[cy][cx] = true;
            }
            calc(yesNo, color, cx, cy, n, m, colors);
        }


    }
}
