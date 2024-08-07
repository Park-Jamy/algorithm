package org.Y2024.M06.D26;
//문제
//        계단 오르기 게임은 계단 아래 시작점부터 계단 꼭대기에 위치한 도착점까지 가는 게임이다. <그림 1>과 같이 각각의 계단에는 일정한 점수가 쓰여 있는데 계단을 밟으면 그 계단에 쓰여 있는 점수를 얻게 된다.
//
//
//
//<그림 1>
//
//        예를 들어 <그림 2>와 같이 시작점에서부터 첫 번째, 두 번째, 네 번째, 여섯 번째 계단을 밟아 도착점에 도달하면 총 점수는 10 + 20 + 25 + 20 = 75점이 된다.
//
//
//
//<그림 2>
//
//        계단 오르는 데는 다음과 같은 규칙이 있다.
//
//        계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
//        연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
//        마지막 도착 계단은 반드시 밟아야 한다.
//        따라서 첫 번째 계단을 밟고 이어 두 번째 계단이나, 세 번째 계단으로 오를 수 있다. 하지만, 첫 번째 계단을 밟고 이어 네 번째 계단으로 올라가거나, 첫 번째, 두 번째, 세 번째 계단을 연속해서 모두 밟을 수는 없다.
//
//        각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.
//
//        입력
//        입력의 첫째 줄에 계단의 개수가 주어진다.
//
//        둘째 줄부터 한 줄에 하나씩 제일 아래에 놓인 계단부터 순서대로 각 계단에 쓰여 있는 점수가 주어진다. 계단의 개수는 300이하의 자연수이고, 계단에 쓰여 있는 점수는 10,000이하의 자연수이다.
//
//        출력
//        첫째 줄에 계단 오르기 게임에서 얻을 수 있는 총 점수의 최댓값을 출력한다.
public class q2024080201 {
    public static int solution(int N, int[] step){
        int result  = 0;

        // dp[i] = Math.max(dp[i-1], dp[i-2])(연속해서 3계단 올라가는 방식) 연속된 3개의 발판을 밟는 경우는 제외

        int[] dp = new int[N];

        dp[0] = 10;
        dp[1] = 30;

//        이전에 선택된 dp가 i-1이라면 지금 선택되어야 하는 dp는 i-2 -> 무조껀
//        이전에 선택된 dp가 i-2 라면 지금 선택되어야 하는 dp는 i-1, i-2 중 최댓값 선택

        // my solution
//        int cntStep = 1;
//        for(int i = 2; i < N; i++){
//            if(cntStep == 1){
//                dp[i] = dp[i-2] + step[i];
//                cntStep = 2;
//            }else{
//                if(dp[i-1] > dp[i-2]){
//                    dp[i] = dp[i-1] + step[i];
//                    cntStep = 1;
//                }else{
//                    dp[i] = dp[i-2] + step[i];
//                    cntStep = 2;
//                }
//            }
//        }

//        basic solution
        dp[2] = Math.max(step[1], step[0]) + step[2];
        for(int i = 3; i < N; i++){
            dp[i] = Math.max(dp[i-3] + step[i-1], dp[i-2]) + step[i];
        }

        result = dp[N-1];

        return result;
    }
}

package org.Y2024.M06.D26;
//        문제
//        다솜이는 0과 1로만 이루어진 문자열 S를 가지고 있다. 다솜이는 이 문자열 S에 있는 모든 숫자를 전부 같게 만들려고 한다. 다솜이가 할 수 있는 행동은 S에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집는 것이다. 뒤집는 것은 1을 0으로, 0을 1로 바꾸는 것을 의미한다.
//
//        예를 들어 S=0001100 일 때,
//
//        전체를 뒤집으면 1110011이 된다.
//        4번째 문자부터 5번째 문자까지 뒤집으면 1111111이 되어서 2번 만에 모두 같은 숫자로 만들 수 있다.
//        하지만, 처음부터 4번째 문자부터 5번째 문자까지 문자를 뒤집으면 한 번에 0000000이 되어서 1번 만에 모두 같은 숫자로 만들 수 있다.
//
//        문자열 S가 주어졌을 때, 다솜이가 해야하는 행동의 최소 횟수를 출력하시오.
//
//        입력
//        첫째 줄에 문자열 S가 주어진다. S의 길이는 100만보다 작다.
//
//        출력
//        첫째 줄에 다솜이가 해야하는 행동의 최소 횟수를 출력한다.
public class q2024080202 {
    public static int solution(String oneZerostr){
        int result = 0;



        int ozLen = oneZerostr.length();

        String[] oz = oneZerostr.split("");

        int[] oneZero = new int[ozLen];

        for(int i = 0; i < ozLen; i++){
            oneZero[i] = Integer.parseInt(oz[i]);
        }


        int one = 0;
        int zero = 0;

        int lastCnt = oneZero[0] == 0 ? 0 : 1;
        if(lastCnt == 0) zero++;
        else one++;

        for(int i = 1; i < ozLen; i++){
            int nowCnt = oneZero[i];

            if( lastCnt == nowCnt ) continue;
            else{
                if(nowCnt == 1) one++;
                else zero++;

                lastCnt = nowCnt;
            }
        }

        result = one <= zero ? one : zero;

        return result;
    }
}

package org.Y2024.M06.D26;
//        우리는 사람의 덩치를 키와 몸무게, 이 두 개의 값으로 표현하여 그 등수를 매겨보려고 한다.
//        어떤 사람의 몸무게가 x kg이고 키가 y cm라면 이 사람의 덩치는 (x, y)로 표시된다.
//        두 사람 A 와 B의 덩치가 각각 (x, y), (p, q)라고 할 때 x > p 그리고 y > q 이라면 우리는 A의 덩치가 B의 덩치보다 "더 크다"고 말한다.
//        예를 들어 어떤 A, B 두 사람의 덩치가 각각 (56, 177), (45, 165) 라고 한다면 A의 덩치가 B보다 큰 셈이 된다. 그런데 서로 다른 덩치끼리 크기를 정할 수 없는 경우도 있다.
//        예를 들어 두 사람 C와 D의 덩치가 각각 (45, 181), (55, 173)이라면 몸무게는 D가 C보다 더 무겁고, 키는 C가 더 크므로, "덩치"로만 볼 때 C와 D는 누구도 상대방보다 더 크다고 말할 수 없다.
//
//        N명의 집단에서 각 사람의 덩치 등수는 자신보다 더 "큰 덩치"의 사람의 수로 정해진다. 만일 자신보다 더 큰 덩치의 사람이 k명이라면 그 사람의 덩치 등수는 k+1이 된다.
//        이렇게 등수를 결정하면 같은 덩치 등수를 가진 사람은 여러 명도 가능하다. 아래는 5명으로 이루어진 집단에서 각 사람의 덩치와 그 등수가 표시된 표이다.
//
//        이름	(몸무게, 키)	덩치 등수
//        A	(55, 185)	2
//        B	(58, 183)	2
//        C	(88, 186)	1
//        D	(60, 175)	2
//        E	(46, 155)	5
//        위 표에서 C보다 더 큰 덩치의 사람이 없으므로 C는 1등이 된다. 그리고 A, B, D 각각의 덩치보다 큰 사람은 C뿐이므로 이들은 모두 2등이 된다. 그리고 E보다 큰 덩치는 A, B, C, D 이렇게 4명이므로 E의 덩치는 5등이 된다. 위 경우에 3등과 4등은 존재하지 않는다. 여러분은 학생 N명의 몸무게와 키가 담긴 입력을 읽어서 각 사람의 덩치 등수를 계산하여 출력해야 한다.
//
//        입력
//        첫 줄에는 전체 사람의 수 N이 주어진다. 그리고 이어지는 N개의 줄에는 각 사람의 몸무게와 키를 나타내는 양의 정수 x와 y가 하나의 공백을 두고 각각 나타난다.
//
//        출력
//        여러분은 입력에 나열된 사람의 덩치 등수를 구해서 그 순서대로 첫 줄에 출력해야 한다. 단, 각 덩치 등수는 공백문자로 분리되어야 한다.


public class q2024080203 {
    public static int[] solution(int[][] human){
        int n = human.length;
        int[][] humanRank  = new int[n][2];

        for(int i = 0; i < n; i++){
            humanRank[i][0] = i;
            humanRank[i][1] = 1;
        }

        for(int i = 0; i < n - 1; i++){
            int w = human[i][0];
            int h = human[i][1];

            for(int j = i + 1; j < n; j++){
                int cw = human[j][0];
                int ch = human[j][1];

                if( w > cw && h > ch ) humanRank[j][1]++;
                else if( w < cw && h < ch ) humanRank[i][1]++;
            }
        }

        int[] result = new int[n];

        for(int i = 0; i < n; i++){
            result[i] = humanRank[i][1];
        }

        return result;
    }
}
