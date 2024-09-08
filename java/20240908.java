import java.util.*;
//    소수 찾기
//    제출 내역
//    문제 설명
//    한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
//
//    각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
//
//    제한사항
//    numbers는 길이 1 이상 7 이하인 문자열입니다.
//    numbers는 0~9까지 숫자만으로 이루어져 있습니다.
//    "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.

class Solution {
    static int answer = 0;

    static Set<Integer> st = new HashSet<>();

    public int solution(String numbers) {
        int num_len = numbers.length();
        // 각 자릿수
        String[] number = numbers.split("");

        boolean[] visited = new boolean[num_len];

        // 모든 조합의 값 리스트 추출 필요
        calc(0, num_len, number, "", visited);
        for (Integer num : st) {

            System.out.println(num);
            if (calc(num)) {
                answer++;
            }
        }


        return answer;
    }

    public static void calc(int cnt, int len, String[] number, String sb, boolean[] visited){
        if(cnt == len){
            return;
        }

        for(int i = 0; i < len; i++){
            if(visited[i]) continue;
            visited[i] = true;
            String next_sb = sb + number[i];

            st.add(Integer.parseInt(next_sb));
            calc(cnt + 1, len, number, next_sb, visited);

            visited[i] = false;
        }
    }

    public static boolean calc(int N){
        if(N < 2) return false;

        // 2 부터 N/2까지 나눠지는 값이 있으면 소수 아님
        for(int i = 2; i <= (int) (N / 2); i++){
            if(N % i == 0) return false;
        }
        return true;
    }
}


package com.org.fcss01.controller;
//    문제
//    <그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
//    철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
//    여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다.
//    <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
//
//
//
//    입력
//    첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
//
//    출력
//    첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q20240908 {

    static int[] nx = {-1, 1, 0, 0};
    static int[] ny = {0, 0, -1, 1};

    static boolean[][] chk;

    // 아파트 단지별 세대 수
    static List<Integer> li = new ArrayList<>();

    static int sum = 0;
    public static void solution(int[][] apt) {


        int N = apt.length; // 아파트 크기
        chk = new boolean[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(chk[i][j]) continue;
                if(apt[i][j] == 0) continue;
                sum = 0;
                calc(i, j, N, apt);

                li.add(sum);
            }
        }
        int[] lia = li.stream().mapToInt(i -> i).toArray();


        Arrays.sort(lia);
        System.out.println("q202140908");
        System.out.println(lia.length);

        for(int a : lia){
            System.out.println(a);
        }
        return;
    }

    public static void calc(int x, int y, int N, int[][] apt){
        for(int i = 0; i < 4; i++){
            int cx = x + nx[i];
            int cy = y + ny[i];

            if(cx < 0 || cx > N - 1 || cy < 0 || cy > N - 1) continue;
            if(chk[cx][cy]) continue;
            if(apt[cx][cy] == 0) continue;

            chk[cx][cy] = true;
            sum++;
            calc(cx, cy, N, apt);
        }
    }

}
