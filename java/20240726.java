package org.Y2024.M06.D26;

import java.util.*;
public class q2024072601 {
    public static long solution(int n, int[] times) {
        Arrays.sort(times);
        long min = 1;

        // times 배열의 최악의 경우는 범위
        // n명 기준으로 times의 가장 마지막 시간까지 탐색하는 경우.
        long max = (long) times[times.length-1]*n;
        long mid = 0;
        long sum;
        long answer = max;

        while(min <= max) {
            sum = 0;
            mid = (min + max) / 2;

            for(int time : times) {
                sum += mid / time;
            }

            if(sum >= n) {
                answer = mid;
                max = mid - 1;
            }
            else {
                min = mid + 1;
            }
        }


        return answer;
    }
}


package org.Y2024.M06.D26;
        import java.util.*;
public class q2024072602 {

    static int[] xx = {-1, 1, 0, 0};
    static int[] yy = {0, 0, -1, 1};



    public static int solution(int[][] maps) {
        int answer =0;
        int h = maps.length;
        int r = maps[0].length;
        answer = h * r;

        int[][] visite = new int[h][r];

        calc(h, r, maps, visite);

        answer = visite[h-1][r-1];


        if(answer == 0){
            answer = -1;
        }

        return answer;
    }

    public static void calc(int h, int r, int[][] maps, int[][] visite){
        int x = 0;
        int y = 0;
        visite[x][y] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});

        while(!q.isEmpty()){
            int[] now = q.remove();
            int nx = now[0];
            int ny = now[1];

            for(int i = 0; i < 4; i++){
                int cx = nx + xx[i];
                int cy = ny + yy[i];

                if(cx < 0 || cx >= r || cy < 0 || cy >= h){
                    continue;
                }

                if(visite[cy][cx] == 0 && maps[cy][cx] == 1){
                    visite[cy][cx] = visite[ny][nx] + 1;
                    q.add(new int[]{cx, cy});
                }
            }
        }
    }
}


package org.Y2024.M06.D26;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Stack;

public class q2024072603 {
    public static char[] solution(char[][] graph, char start, int n){
        char[] answer;
        int graph_len = graph.length;
        answer = new char[graph_len];
        Stack<Character> st = new Stack<>();

        List<Character> c  = new ArrayList<>();

        st.push(start);
        c.add(start);

        while(!st.isEmpty()){
            char now_char = st.peek();
            int chk = 0;
            for(int i = 0; i < graph_len; i++){
                char chk_char = graph[i][0];

                if(chk_char == now_char){
                    graph[i][0] = '0';
                    st.push(graph[i][1]);
                    c.add(graph[i][1]);
                    chk = 1;
                    break;
                }
            }

            if(chk == 0) st.pop();
        }

        for(int i = 0; i < graph_len; i++){
            answer[i] = c.get(i);
        }

        return answer;
    }
}


package org.Y2024.M06.D26;

        import java.util.*;

public class q2024072604 {
    static boolean[][] visit;
    static int answer; // 건설 비용
    static int n; // 배열 크기
    static int[][][] arr; //[dir][x][y]

    static class Point {
        int x, y, dir, cost;

        Point(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }

    public int solution(int[][] board) {
        // 직진 - 100, 코너 - 600
        // 코너를 돈다 = 방향을 바꾼다 => 현재 방향을 기억해야 한다
        answer = Integer.MAX_VALUE;
        n = board.length;
        arr = new int[4][n][n];
        for(int i=0;i<4;i++) {
            for(int x=0;x<n;x++) {
                for(int y=0;y<n;y++) {
                    arr[i][x][y] = Integer.MAX_VALUE;
                }
            }
        }
        visit = new boolean[n][n];

        bfs(0, 0, -1, 0, board); //(0,0)에서 출발, 초기 방향은 -1(출발)

        return answer;
    }

    private static void bfs(int x, int y, int dir, int cost, int[][] board) {
        int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
        int[] dy = {0, 0, -1, 1};

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y, dir, cost));
        visit[x][y] = true;

        while (!q.isEmpty()) {
            Point point = q.poll();
            int px = point.x;
            int py = point.y;
            int pdir = point.dir;
            int pcost = point.cost;

            if (px == n - 1 && py == n - 1) {
                answer = Math.min(answer, pcost);
            }

            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];
                int ndir = i;
                int ncost = pcost;

                if(nx<0 || nx>=n || ny<0 || ny>=n || board[nx][ny]==1) {
                    continue;
                }

                if(pdir == -1) { // 출발하는 경우는 무조건 100
                    ncost += 100;
                } else if(pdir==ndir) { // 방향이 같다 - 직진
                    ncost += 100;
                } else { // 코너 돌기
                    ncost += 600;
                }

                if(!visit[nx][ny] || arr[ndir][nx][ny] >= ncost) {
                    visit[nx][ny] = true;
                    arr[ndir][nx][ny] = ncost;
                    q.add(new Point(nx, ny, ndir, ncost));
                }
            }
        }
    }
}


package org.Y2024.M06.D26;

        import java.util.Arrays;

public class q2024072605 {
    public static long solution(int[] sequence) {
        long answer = 0;
        int sequence_size = sequence.length;
        // 구간을 정한다음
        // 짝수값, 홀수값 나눠서 더하기
        // 절댓값이 가장 큰 구간 확인

        int[] a = new int[sequence_size], b = new int[sequence_size];

        int n = 1;
        for(int i = 0; i < sequence_size; i++){
            a[i] = sequence[i] * n;
            n *= -1;
            b[i] = sequence[i] * n;
        }

        long[] dpa = new long[sequence_size];
        long[] dpb = new long[sequence_size];
        dpa[0] = a[0];
        dpb[0] = b[0];

        answer = Math.max(dpa[0], dpb[0]);

        for(int i = 1; i < sequence_size; i++){
            dpa[i] = Math.max(dpa[i-1] + a[i], a[i]);
            dpb[i] = Math.max(dpb[i-1] + b[i], b[i]);

            answer = answer < Math.max(dpa[i], dpb[i]) ? Math.max(dpa[i], dpb[i]) : answer;
        }

        return answer;
    }
}
