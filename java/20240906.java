package org.Y2024.M06.D26;


//우리는 사람의 덩치를 키와 몸무게, 이 두 개의 값으로 표현하여 그 등수를 매겨보려고 한다.
// 어떤 사람의 몸무게가 x kg이고 키가 y cm라면 이 사람의 덩치는 (x, y)로 표시된다.
// 두 사람 A 와 B의 덩치가 각각 (x, y), (p, q)라고 할 때 x > p 그리고 y > q 이라면 우리는 A의 덩치가 B의 덩치보다 "더 크다"고 말한다.
// 예를 들어 어떤 A, B 두 사람의 덩치가 각각 (56, 177), (45, 165) 라고 한다면 A의 덩치가 B보다 큰 셈이 된다.
// 그런데 서로 다른 덩치끼리 크기를 정할 수 없는 경우도 있다. 예를 들어 두 사람 C와 D의 덩치가 각각 (45, 181), (55, 173)이라면 몸무게는 D가 C보다 더 무겁고,
// 키는 C가 더 크므로, "덩치"로만 볼 때 C와 D는 누구도 상대방보다 더 크다고 말할 수 없다.
//
//N명의 집단에서 각 사람의 덩치 등수는 자신보다 더 "큰 덩치"의 사람의 수로 정해진다. 만일 자신보다 더 큰 덩치의 사람이 k명이라면 그 사람의 덩치 등수는 k+1이 된다. 이렇게 등수를 결정하면 같은 덩치 등수를 가진 사람은 여러 명도 가능하다. 아래는 5명으로 이루어진 집단에서 각 사람의 덩치와 그 등수가 표시된 표이다.
//
//이름	(몸무게, 키)	덩치 등수
//A	(55, 185)	2
//B	(58, 183)	2
//C	(88, 186)	1
//D	(60, 175)	2
//E	(46, 155)	5
//위 표에서 C보다 더 큰 덩치의 사람이 없으므로 C는 1등이 된다. 그리고 A, B, D 각각의 덩치보다 큰 사람은 C뿐이므로 이들은 모두 2등이 된다.
// 그리고 E보다 큰 덩치는 A, B, C, D 이렇게 4명이므로 E의 덩치는 5등이 된다. 위 경우에 3등과 4등은 존재하지 않는다.
// 여러분은 학생 N명의 몸무게와 키가 담긴 입력을 읽어서 각 사람의 덩치 등수를 계산하여 출력해야 한다.
//
//입력
//첫 줄에는 전체 사람의 수 N이 주어진다. 그리고 이어지는 N개의 줄에는 각 사람의 몸무게와 키를 나타내는 양의 정수 x와 y가 하나의 공백을 두고 각각 나타난다.
//
//출력
//여러분은 입력에 나열된 사람의 덩치 등수를 구해서 그 순서대로 첫 줄에 출력해야 한다. 단, 각 덩치 등수는 공백문자로 분리되어야 한다.
//
//제한
//2 ≤ N ≤ 50
//10 ≤ x, y ≤ 200


import java.util.*;

public class q20240906 {
    public static int[] solution(int N, int[][] list){
        int[] answer;

        // 사람 인원 수
        int num = list.length;
        answer = new int[num];
        // 사람 인원 만큼
        Map<Integer, Integer> m = new HashMap<>();

        // 초기화
        for(int i = 0; i < num; i++){
            m.put(i, 5);
        }

        // 비교
        for(int i = 0; i < num - 1; i++){

            int p = i; // 비교 할 사람 번호
            int w = list[p][0]; // 몸무게
            int h = list[p][1]; // 키

            for(int j = i + 1; j < num; j++){

                int jw = list[j][0]; // 몸무게
                int jh = list[j][1]; // 키

                // 덩치가 클 경우, 등수 내려가기
                if(!(w < jw && h < jh)){
                    m.put(p, m.get(p) - 1);
                }

                if(!(w > jw && h > jh)){
                    m.put(j, m.get(j) - 1);
                }
            }
        }

        for(int i = 0; i < num; i++){
            answer[i] = m.get(i);
        }



        return answer;
    }
}

package org.Y2024.M06.D26;
//문제
//우주 탐사선 ana호는 어떤 행성계를 탐사하기 위해 발사된다. 모든 행성을 탐사하는데 걸리는 최소 시간을 계산하려 한다.
// 입력으로는 ana호가 탐색할 행성의 개수와 ana호가 발사되는 행성의 위치와 ana호가 행성 간 이동을 하는데 걸리는 시간이 2차원 행렬로 주어진다.
// 행성의 위치는 0부터 시작하여 0은 행렬에서 0번째 인덱스에 해당하는 행성을 의미한다.
// 2차원 행렬에서 i, j 번 요소는 i 번째 행성에서 j 번째 행성에 도달하는데 걸리는 시간을 나타낸다. i와 j가 같을 때는 항상 0이 주어진다.
// 모든 행성을 탐사하는데 걸리는 최소 시간을 계산하여라.
//
//탐사 후 다시 시작 행성으로 돌아올 필요는 없으며 이미 방문한 행성도 중복해서 갈 수 있다.
//
//입력
//첫 번째 줄에는 행성의 개수 N과 ana호가 발사되는 행성의 위치 K가 주어진다. (2 ≤ N ≤ 10, 0 ≤ K < N)
//
//다음 N 줄에 걸쳐 각 행성 간 이동 시간 Tij 가 N 개 씩 띄어쓰기로 구분되어 주어진다. (0 ≤ Tij  ≤ 1000)
//
//출력
//모든 행성을 탐사하기 위한 최소 시간을 출력한다.


public class q2024090602 {

    private static boolean[] visited;
    private static int min = Integer.MAX_VALUE;

    public static int solution(int N, int K, int[][] times){

        // 방문 여부 초기화
        visited = new boolean[N];

        // 출발하는 행성 방문 여부 체크
        visited[K] = true;

        for (int k = 0; k < N; k++) {
            for (int j = 0; j < N; j++) {
                for (int i = 0; i < N; i++) {
                    if (times[i][k] + times[k][j] < times[i][j]) {
                        times[i][j] = times[i][k] + times[k][j];
                    }
                }
            }
        }

        dfs(0, K, 0,N, times);

        return min;
    }

    public static void dfs(int level , int start, int sum,int n, int[][] times) {
        if(level == n-1) {
            min = Math.min(min, sum);
            return ;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(level+1,i,sum+times[start][i],n, times);
                visited[i] = false;
            }
        }
    }

//    private static void calc(int P, int Cnt, int sum, int N, int[][] times){
//        if (chk(N)) {
//            if(sum < min) min = sum;
//            return;
//        }
//
//        for(int i = 0; i < N; i++){
//            if(i == P) continue;
//            // 방문을 했으면 넘어가기
//            visited[i] = true;
//            // 방문을 하지 않았다면 방문하기
//            calc(i, Cnt + 1, sum + times[P][i], N, times);
//
//            visited[i] = false;
//        }
//    }
//
//    public static boolean chk(int N){
//        for(int i = 0; i < N; i++){
//            if(!visited[i]) return false;
//        }
//        return true;
//    }
}

package org.Y2024.M06.D26;

//N장의 카드가 있다. 각각의 카드는 차례로 1부터 N까지의 번호가 붙어 있으며, 1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 순서대로 카드가 놓여 있다.
//
//이제 다음과 같은 동작을 카드가 한 장 남을 때까지 반복하게 된다. 우선, 제일 위에 있는 카드를 바닥에 버린다.
// 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
//
//예를 들어 N=4인 경우를 생각해 보자. 카드는 제일 위에서부터 1234 의 순서로 놓여있다. 1을 버리면 234가 남는다.
// 여기서 2를 제일 아래로 옮기면 342가 된다. 3을 버리면 42가 되고, 4를 밑으로 옮기면 24가 된다. 마지막으로 2를 버리고 나면, 남는 카드는 4가 된다.
//
//N이 주어졌을 때, 제일 마지막에 남게 되는 카드를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 정수 N(1 ≤ N ≤ 500,000)이 주어진다.
//
//출력
//첫째 줄에 남게 되는 카드의 번호를 출력한다.

        import java.util.*;
public class q2024090601 {
    public static int solution(int N){
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i < N + 1; i++){
            q.add(i);
        }

        boolean chk = true;
        while(!(q.size() == 1)){
            int now = q.poll();
            if(!chk) {
                q.add(now);
                chk = true;
            }else{
                chk = false;
            }

        }

        return q.poll();
    }
}
