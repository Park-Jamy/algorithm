//단속카메라
//        제출 내역
//        문제 설명
//        고속도로를 이동하는 모든 차량이 고속도로를 이용하면서 단속용 카메라를 한 번은 만나도록 카메라를 설치하려고 합니다.
//
//        고속도로를 이동하는 차량의 경로 routes가 매개변수로 주어질 때, 모든 차량이 한 번은 단속용 카메라를 만나도록 하려면 최소 몇 대의 카메라를 설치해야 하는지를 return 하도록 solution 함수를 완성하세요.
//
//        제한사항
//
//        차량의 대수는 1대 이상 10,000대 이하입니다.
//        routes에는 차량의 이동 경로가 포함되어 있으며 routes[i][0]에는 i번째 차량이 고속도로에 진입한 지점, routes[i][1]에는 i번째 차량이 고속도로에서 나간 지점이 적혀 있습니다.
//        차량의 진입/진출 지점에 카메라가 설치되어 있어도 카메라를 만난것으로 간주합니다.
//        차량의 진입 지점, 진출 지점은 -30,000 이상 30,000 이하입니다.
//        입출력 예
//
//        routes	return
//        [[-20,-15], [-14,-5], [-18,-13], [-5,-3]]	2
import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a,b) -> {
            return a[1] - b[1];
        });

        int max = routes[0][1];
        answer ++;
        for(int[] route : routes){
            if(max < route[0]) {
                max = route[1];
                answer++;
            }

        }

        return answer;
    }
}

//    숫자 게임
//    제출 내역
//    문제 설명
//    xx 회사의 2xN명의 사원들은 N명씩 두 팀으로 나눠 숫자 게임을 하려고 합니다. 두 개의 팀을 각각 A팀과 B팀이라고 하겠습니다. 숫자 게임의 규칙은 다음과 같습니다.
//
//        먼저 모든 사원이 무작위로 자연수를 하나씩 부여받습니다.
//        각 사원은 딱 한 번씩 경기를 합니다.
//        각 경기당 A팀에서 한 사원이, B팀에서 한 사원이 나와 서로의 수를 공개합니다. 그때 숫자가 큰 쪽이 승리하게 되고, 승리한 사원이 속한 팀은 승점을 1점 얻게 됩니다.
//        만약 숫자가 같다면 누구도 승점을 얻지 않습니다.
//        전체 사원들은 우선 무작위로 자연수를 하나씩 부여받았습니다. 그다음 A팀은 빠르게 출전순서를 정했고 자신들의 출전 순서를 B팀에게 공개해버렸습니다. B팀은 그것을 보고 자신들의 최종 승점을 가장 높이는 방법으로 팀원들의 출전 순서를 정했습니다. 이때의 B팀이 얻는 승점을 구해주세요.
//        A 팀원들이 부여받은 수가 출전 순서대로 나열되어있는 배열 A와 i번째 원소가 B팀의 i번 팀원이 부여받은 수를 의미하는 배열 B가 주어질 때, B 팀원들이 얻을 수 있는 최대 승점을 return 하도록 solution 함수를 완성해주세요.
//
//        제한사항
//        A와 B의 길이는 같습니다.
//        A와 B의 길이는 1 이상 100,000 이하입니다.
//        A와 B의 각 원소는 1 이상 1,000,000,000 이하의 자연수입니다.
//        입출력 예
//        A	B	result
//        [5,1,3,7]	[2,2,6,8]	3
//        [2,2,2,2]	[1,1,1,1]	0

import java.util.*;

class Solution {

    static int[] AA;
    static int[] BB;
    static int result = 0;

    public int solution(int[] A, int[] B) {
        int answer = -1;

        //각 사원은 한번씩 경기를 진행
        // N명씩 2팀
        // A 팀이 먼저 본인들의 순서를 정하고 공개
        // B 팀은 해당 것을 보고 순서 정해야 함
        int N = A.length;

        Arrays.sort(A);
        Arrays.sort(B);

        AA = A;
        BB = B;

        calc(0,0,N);

        return result;
    }

    public void calc(int Bcnt, int Acnt , int N){
        if(Bcnt == N) return;
        for(int i = Bcnt; i < N; i++){
            // A 의 Acnt 번째 순서에 B i번째와 비교해서 크면 result를 +1 해주고
            // 다음 A Acnt+1 순서 선수와 B i + 1 번쨰 부터 N 번째 선수 부터 비교해서 이기는 선수 있는지 확인
            if(AA[Acnt] < BB[i]) {
                result++;
                calc(i+1, Acnt+1, N);
                return;
            }
        }
        return;
    }
}