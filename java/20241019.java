package com.org.fcss01.controller;

import java.io.*;
import java.util.*;
//    문제
//    정사각형으로 이루어져 있는 섬과 바다 지도가 주어진다. 섬의 개수를 세는 프로그램을 작성하시오.
//
//
//
//    한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형이다.
//
//    두 정사각형이 같은 섬에 있으려면, 한 정사각형에서 다른 정사각형으로 걸어서 갈 수 있는 경로가 있어야 한다.
//    지도는 바다로 둘러싸여 있으며, 지도 밖으로 나갈 수 없다.
//
//    입력
//    입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다.
//    w와 h는 50보다 작거나 같은 양의 정수이다.
//
//    둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.
//
//    입력의 마지막 줄에는 0이 두 개 주어진다.
//
//    출력
//    각 테스트 케이스에 대해서, 섬의 개수를 출력한다.

public class q2024101901 {
    private static int[] mx = {1, -1, 0, 0, -1, 1, -1, 1};
    private static int[] my = {0, 0, -1, 0, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String[] str = br.readLine().split(" ");

            int w = Integer.parseInt(str[0]);
            int h = Integer.parseInt(str[1]);
            int answer = 0;
            // 00 일 경우 데이터 조회 끝
            if(w == 0 && h == 0) break;

            int[][] maps = new int[h][w];
            boolean[][] visited = new boolean[h][w];

            // maps 초기화
            for(int i = 0; i < h; i++){
                String[] nowStr = br.readLine().split(" ");

                for(int j = 0; j < w; j++){
                    maps[i][j] = Integer.parseInt(nowStr[j]);
                }
            }

            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(visited[i][j]) continue;
                    if(maps[i][j] == 0) continue;
                    answer++; // 섬 추가
                    visited[i][j] = true;

                    calc(0, 0, w, h, maps, visited);
                }
            }

            System.out.println(answer);
        }
    }

    private static void calc(int x, int y, int w, int h, int[][] maps, boolean[][] visited){
        for(int i = 0; i < 8; i++){
            int nx = x + mx[i];
            int ny = y + my[i];

            if( nx < 0 || nx > h - 1|| ny < 0 || ny > w - 1) continue;

            if(visited[nx][ny] || maps[nx][ny] == 0) continue;

            visited[nx][ny] = true;

            calc(nx, ny, w, h, maps, visited);
        }
    }
}


import java.io.*;
        import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int[][] westEast = new int[t][2];

        for(int i = 0; i < t; i++){
            String[] bridge = br.readLine().split(" ");

            westEast[i][0] = Integer.parseInt(bridge[0]);
            westEast[i][1] = Integer.parseInt(bridge[1]);
        }

        for(int i = 0; i < t; i++){
            int west = westEast[i][0];
            int east = westEast[i][1];
            calc(west, east);
        }
    }

    private static void calc(int west, int east){
        int[][] dp = new int[west][east];

        for(int i = 0; i < east; i++){
            dp[0][i] = 1;
        }



        for(int i = 1; i < west; i++){
            for(int j = i; j < east; j++){
                dp[i][j] = 0;

                for(int k = 0; k < j; k++){
                    dp[i][j] += dp[i-1][k];
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < east; i++){
            answer += dp[west-1][i];
        }

        System.out.println(answer);
    }
}