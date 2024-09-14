package org.Y2024.M06.D26;
//    문   제
//    ⚾는 9명으로 이루어진 두 팀이 공격과 수비를 번갈아 하는 게임이다. 하나의 이닝은 공격과 수비로 이루어져 있고,
//    총 N이닝 동안 게임을 진행해야 한다. 한 이닝에 3아웃이 발생하면 이닝이 종료되고, 두 팀이 공격과 수비를 서로 바꾼다.
//
//    두 팀은 경기가 시작하기 전까지 타순(타자가 타석에 서는 순서)을 정해야 하고, 경기 중에는 타순을 변경할 수 없다.
//    9번 타자까지 공을 쳤는데 3아웃이 발생하지 않은 상태면 이닝은 끝나지 않고, 1번 타자가 다시 타석에 선다. 타순은 이닝이 변경되어도 순서를 유지해야 한다.
//    예를 들어, 2이닝에 6번 타자가 마지막 타자였다면, 3이닝은 7번 타자부터 타석에 선다.
//
//    공격은 투수가 던진 공을 타석에 있는 타자가 치는 것이다. 공격 팀의 선수가 1루, 2루, 3루를 거쳐서 홈에 도착하면 1점을 득점한다.
//    타자가 홈에 도착하지 못하고 1루, 2루, 3루 중 하나에 머물러있을 수 있다. 루에 있는 선수를 주자라고 한다. 이닝이 시작될 때는 주자는 없다.
//
//    타자가 공을 쳐서 얻을 수 있는 결과는 안타, 2루타, 3루타, 홈런, 아웃 중 하나이다. 각각이 발생했을 때, 벌어지는 일은 다음과 같다.
//
//    안타: 타자와 모든 주자가 한 루씩 진루한다.
//    2루타: 타자와 모든 주자가 두 루씩 진루한다.
//    3루타: 타자와 모든 주자가 세 루씩 진루한다.
//    홈런: 타자와 모든 주자가 홈까지 진루한다.
//    아웃: 모든 주자는 진루하지 못하고, 공격 팀에 아웃이 하나 증가한다.
//    한 야구팀의 감독 아인타는 타순을 정하려고 한다. 아인타 팀의 선수는 총 9명이 있고, 1번부터 9번까지 번호가 매겨져 있다.
//    아인타는 자신이 가장 좋아하는 선수인 1번 선수를 4번 타자로 미리 결정했다. 이제 다른 선수의 타순을 모두 결정해야 한다.
//    아인타는 각 선수가 각 이닝에서 어떤 결과를 얻는지 미리 알고 있다. 가장 많은 득점을 하는 타순을 찾고, 그 때의 득점을 구해보자.
//
//    입력
//    첫째 줄에 이닝 수 N(2 ≤ N ≤ 50)이 주어진다. 둘째 줄부터 N개의 줄에는 각 선수가 각 이닝에서 얻는 결과가 1번 이닝부터 N번 이닝까지 순서대로 주어진다.
//    이닝에서 얻는 결과는 9개의 정수가 공백으로 구분되어져 있다. 각 결과가 의미하는 정수는 다음과 같다.
//
//    안타: 1
//    2루타: 2
//    3루타: 3
//    홈런: 4
//    아웃: 0
//    각 이닝에는 아웃을 기록하는 타자가 적어도 한 명 존재한다.
//
//    출력
//    아인타팀이 얻을 수 있는 최대 점수를 출력한다.

import java.util.*;

public class q2024091101 {

    static boolean[] go = new boolean[9];
    static int[] playerList = new int[9];

    static int[][] gRate;

    static int answer = -1;
    public static int solution(int N, int[][] rate){


        int M = rate[0].length;

        gRate = new int[N][9];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < 9; j++){
                gRate[i][j] = rate[i][j];
            }
        }

        // rate[][0] 의 순번은 4
        // 8선수들에 대한 모든 경우의 수를 확인
        go[0] = true;
        playerNumCalc(0);

        return answer;
    }


    public static void playerNumCalc(int cnt){
        if(cnt == 9){
            goalCalc(0,0, 1);
            return;
        }
        for(int i = 0; i < 9; i++){ // 선수들 리스트
            if(go[i]) continue; // 이미 타순에 들어간 선수는 패스
            else {
                if(cnt == 3) {
                    playerList[cnt] = 0; // 4번 타순에 0번 타자 넣기
                    playerNumCalc(cnt + 1);
                }
                else{
                    go[i] = true;
                    playerList[cnt] = i; // 타순에 i번 타자 넣기
                    playerNumCalc(cnt + 1);
                    go[i] = false;
                }
            }
        }
    }
    //int now_N = 0; // 현재 몇회인지
    public static void goalCalc(int now_N, int totalCnt, int lastNum){
        if(now_N == gRate.length) {
            answer = Math.max(totalCnt, answer);
            return;
        }
        // 타순대로 어떤 것을 행위를 했는지 확인하고, 0을 카운트해 0이 3개이면 다음 회로 넘어가게 하는 방식
        int zeroCnt = 0; // 아웃
        int num = lastNum; // 타순

        int[] base = new int[4]; // 베이스에 주자가 있는지 체크

        while( zeroCnt < 3 ){

            int playNum = playerList[num-1]; // num 번 타순의 타자가 몇번인지 확인

            int play = gRate[now_N][playNum]; // 등번호 playNum의 타자가 무슨 행위를 했는지

            if(play == 0) { // 아웃
                zeroCnt++; // 아웃카운트 ++
            }else if(play == 1){ // 1루타
                if(base[3] == 1) totalCnt++;

                // 1베이스씩 진루
                base[3] = base[2];
                base[2] = base[1];
                base[1] = 1;
            }else if(play == 2) { // 2루타
                if(base[3] == 1) totalCnt++;
                if(base[2] == 1) totalCnt++;

                base[3] = base[1];
                base[2] = 1;
                base[1] = 0;
            }else if(play == 3){ // 3루타
                if(base[3] == 1) totalCnt++;
                if(base[2] == 1) totalCnt++;
                if(base[1] == 1) totalCnt++;

                base[3] = 1;
                base[2] = 0;
                base[1] = 0;
            }else if(play == 4){ // 홈런
                totalCnt++;
                if(base[3] == 1) totalCnt++;
                if(base[2] == 1) totalCnt++;
                if(base[1] == 1) totalCnt++;

                base[3] = 0;
                base[2] = 0;
                base[1] = 0;
            }
            num++; // 타순 변경
            if(num == 10) num = 1; // 타순이 10번일 경우 1번 타순으로 돌아간다
        }

        goalCalc(now_N + 1, totalCnt, num);
    }
}


package org.Y2024.M06.D26;
//    문제
//    상담원으로 일하고 있는 백준이는 퇴사를 하려고 한다.
//
//    오늘부터 N+1일째 되는 날 퇴사를 하기 위해서, 남은 N일 동안 최대한 많은 상담을 하려고 한다.
//
//    백준이는 비서에게 최대한 많은 상담을 잡으라고 부탁을 했고, 비서는 하루에 하나씩 서로 다른 사람의 상담을 잡아놓았다.
//
//    각각의 상담은 상담을 완료하는데 걸리는 기간 Ti와 상담을 했을 때 받을 수 있는 금액 Pi로 이루어져 있다.
//
//    N = 7인 경우에 다음과 같은 상담 일정표를 보자.
//
//          1일	2일	3일	4일	5일	6일	7일
//    Ti	3	5	1	1	2	4	2
//    Pi	10	20	10	20	15	40	200
//    1일에 잡혀있는 상담은 총 3일이 걸리며, 상담했을 때 받을 수 있는 금액은 10이다. 5일에 잡혀있는 상담은 총 2일이 걸리며, 받을 수 있는 금액은 15이다.
//
//    상담을 하는데 필요한 기간은 1일보다 클 수 있기 때문에, 모든 상담을 할 수는 없다.
//    예를 들어서 1일에 상담을 하게 되면, 2일, 3일에 있는 상담은 할 수 없게 된다.
//    2일에 있는 상담을 하게 되면, 3, 4, 5, 6일에 잡혀있는 상담은 할 수 없다.
//
//    또한, N+1일째에는 회사에 없기 때문에, 6, 7일에 있는 상담을 할 수 없다.
//
//    퇴사 전에 할 수 있는 상담의 최대 이익은 1일, 4일, 5일에 있는 상담을 하는 것이며, 이때의 이익은 10+20+15=45이다.
//
//    상담을 적절히 했을 때, 백준이가 얻을 수 있는 최대 수익을 구하는 프로그램을 작성하시오.
//
//    입력
//    첫째 줄에 N (1 ≤ N ≤ 15)이 주어진다.
//
//    둘째 줄부터 N개의 줄에 Ti와 Pi가 공백으로 구분되어서 주어지며, 1일부터 N일까지 순서대로 주어진다. (1 ≤ Ti ≤ 5, 1 ≤ Pi ≤ 1,000)
//
//    출력
//    첫째 줄에 백준이가 얻을 수 있는 최대 이익을 출력한다.
        import java.io.*;
        import java.util.*;

public class q2024091102 {

    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][2];

        for(int i = 0; i < N; i++){
            String[] s = br.readLine().split(" ");

            map[i][0] = Integer.parseInt(s[0]);
            map[i][1] = Integer.parseInt(s[1]);
        }


        // i일에 상담을 하는지 안하는지 체크
        // 상담을 하면 다음 상담은 i + Ti일에 상담
        // 상담을 하지 않는다면 i + 1일에 상담

        // 상담을 할수 있는 기준은
        // i + Ti <= N - 1 일 경우
        calc(0, N, 0, map);

        System.out.println(max);
    }

    private static void calc(int i, int N, int sum, int[][] map){
        if(i > N - 1){
            return;
        }else{
            int Ti = map[i][0];
            int Pi = map[i][1];

            // 상담 진행 o
            if(i + Ti - 1 <= N - 1){
                max = Math.max(max, sum + Pi);
                calc(i + Ti, N, sum + Pi, map);
            }
            // 상담 진행 x
            calc(i + 1, N, sum, map);
        }
    }
}
