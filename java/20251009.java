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

         int min = mapslen[N - 1][M - 1];

         if (min == 0) min = -1;

         return min;
     }

     public static void calc(int N, int M, int[][] maps, int[][] mapslen) {

         int x = 0;
         int y = 0;

         Queue<int[]> q = new LinkedList<>();
         q.add(new int[]{x, y});

         while (!q.isEmpty()) {
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



 import java.util.*;

 class Solution {

     static int gn = 0;

     public int solution(int n, int[][] computers) {
         // n 은 컴퓨터 개수
         gn = n;
         // 답변
         int answer = 0;

         int[] visited = new int[n];

         for(int i = 0; i < n; i++){
             visited[i] = 0;
         }

         for(int i = 0; i < n; i++) {
             if(visited[i] == 0) {
                 visited[i] = 1;
                 calc(i, computers, visited);
                 answer++;
             }
         }

         return answer;
     }

     private static void calc(int start, int[][] computers, int[] visited){
         for(int i = 0; i < gn; i++){
             if(computers[start][i] == 1  // 연결되어 있고
                     && visited[i] == 0){ // 방문한적이 없다면
                 visited[i] = 1;

                 calc(i, computers, visited);
             }
         }
     }
 }



