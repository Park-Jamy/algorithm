package org.Y2024.M06.D26;

//    문제
//    크기가 N×M인 지도가 존재한다. 지도의 오른쪽은 동쪽, 위쪽은 북쪽이다. 이 지도의 위에 주사위가 하나 놓여져 있으며,
//    주사위의 전개도는 아래와 같다. 지도의 좌표는 (r, c)로 나타내며, r는 북쪽으로부터 떨어진 칸의 개수,
//    c는 서쪽으로부터 떨어진 칸의 개수이다.
//
//      2
//    4 1 3
//      5
//      6
//    주사위는 지도 위에 윗 면이 1이고, 동쪽을 바라보는 방향이 3인 상태로 놓여져 있으며, 놓여져 있는 곳의 좌표는 (x, y) 이다.
//    가장 처음에 주사위에는 모든 면에 0이 적혀져 있다.
//
//    지도의 각 칸에는 정수가 하나씩 쓰여져 있다.
//    주사위를 굴렸을 때,
//    이동한 칸에 쓰여 있는 수가
//    0이면, 주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다.
//    0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0이 된다.
//
//    주사위를 놓은 곳의 좌표와 이동시키는 명령이 주어졌을 때, 주사위가 이동했을 때 마다 상단에 쓰여 있는 값을 구하는 프로그램을 작성하시오.
//
//    주사위는 지도의 바깥으로 이동시킬 수 없다. 만약 바깥으로 이동시키려고 하는 경우에는 해당 명령을 무시해야 하며, 출력도 하면 안 된다.
//
//    입력
//    첫째 줄에 지도의 세로 크기 N, 가로 크기 M (1 ≤ N, M ≤ 20), 주사위를 놓은 곳의 좌표 x, y(0 ≤ x ≤ N-1, 0 ≤ y ≤ M-1),
//    그리고 명령의 개수 K (1 ≤ K ≤ 1,000)가 주어진다.
//
//    둘째 줄부터 N개의 줄에 지도에 쓰여 있는 수가 북쪽부터 남쪽으로, 각 줄은 서쪽부터 동쪽 순서대로 주어진다. 주사위를 놓은 칸에 쓰여
//    있는 수는 항상 0이다. 지도의 각 칸에 쓰여 있는 수는 10 미만의 자연수 또는 0이다.
//
//    마지막 줄에는 이동하는 명령이 순서대로 주어진다. 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4로 주어진다.
//
//    출력
//    이동할 때마다 주사위의 윗 면에 쓰여 있는 수를 출력한다. 만약 바깥으로 이동시키려고 하는 경우에는 해당 명령을 무시해야 하며,
//    출력도 하면 안 된다.

import java.io.*;

public class q2024092501 {

    static int[] dice = {1,2,3,4,5,6};
    static int[][] maps;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NMXYstr = br.readLine().split(" ");

        int N = Integer.parseInt(NMXYstr[0]);
        int M = Integer.parseInt(NMXYstr[1]);
        int x = Integer.parseInt(NMXYstr[2]);
        int y = Integer.parseInt(NMXYstr[3]);
        int k = Integer.parseInt(NMXYstr[4]);


        maps = new int[N][M];

        for(int i = 0; i < N; i++){
            String[] now = br.readLine().split(" ");
            
            for(int j = 0; j < M; j++){
                maps[i][j] = Integer.parseInt(now[j]);
            }
        }
        
        String[] roll = br.readLine().split(" ");
        
        for(int i = 0; i < k; k++){
            // 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
            int move = Integer.parseInt(roll[k]);
            int xx = x;
            int yy = y;
            if(move == 1){
                yy = yy + 1;
                if(!calc(x,y, N,M)) continue;
                
                eCalc();
                
                System.out.println(dice[5]);
            }else if(move == 2){
                yy = yy - 1;
                if(!calc(x,y, N,M)) continue;

                wCalc();

                System.out.println(dice[5]);

            }else if(move == 3){
                xx = xx - 1;
                if(!calc(x,y, N,M)) continue;

                sCalc();

                System.out.println(dice[5]);

            }else if(move == 4){
                xx = xx + 1;
                if(!calc(x,y, N,M)) continue;

                nCalc();

                System.out.println(dice[5]);

            }
        }
        
        // dice[5] 가 바닥면
    }
    
    private static boolean calc(int x, int y, int N, int M){
        if(x < 0 || x > N - 1 || y < 0 || y > M - 1) {
            System.out.println(0);
            return false;
        }
        return true;
    }


    // 동서남북으로 움직일 때 바닥면으로 가는 것 체크
    // 동
    private static void eCalc(){
        int temp = dice[0];
        dice[0] = dice[3];
        dice[3] = dice[5];
        dice[5] = dice[2];
        dice[2] = temp;
    }
    // 서
    private static void wCalc(){
        int temp = dice[0];
        dice[0] = dice[2];
        dice[2] = dice[5];
        dice[5] = dice[3];
        dice[3] = temp;
    }

    //남
    private static void sCalc(){
        int temp = dice[0];
        dice[0] = dice[1];
        dice[1] = dice[5];
        dice[5] = dice[4];
        dice[4] = temp;
    }

    //북
    private static void nCalc(){
        int temp = dice[0];
        dice[0] = dice[4];
        dice[4] = dice[5];
        dice[5] = dice[1];
        dice[1] = temp;
    }
}


public class q2024092501 {
    private static int[][] citys;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        citys = new int[n + 1][n + 1];
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < n + 1; j++) {
                citys[i][j] = 9999999;

                if(i == j) citys[i][j] = 0;

            }
        }

        // i -> j 로 넘어갈 때 기본 세팅
        for(int i = 0; i < m; i++){
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);

            citys[a][b] = Math.min(citys[a][b], c);
        }


        for (int k = 1; k < n + 1; k++) {
            for(int i = 1; i < n + 1; i++){
                for(int j = 1; j < n + 1; j++){
                    // 최단경로 초기화
                    if (citys[i][j] > citys[i][k] + citys[k][j]) {
                        citys[i][j] = citys[i][k] + citys[k][j];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < n + 1; i++){


            for(int j = 1; j < n + 1; j++){
                if (citys[i][j] == 9999999) {
                    citys[i][j] = 0;
                }
                sb.append(citys[i][j]);

                if(j != n) sb.append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
