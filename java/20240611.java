//이중우선순위큐
//        제출 내역
//        문제 설명
//        이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.
//
//        명령어	수신 탑(높이)
//        I 숫자	큐에 주어진 숫자를 삽입합니다.
//        D 1	큐에서 최댓값을 삭제합니다.
//        D -1	큐에서 최솟값을 삭제합니다.
//        이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.
//
//        제한사항
//        operations는 길이가 1 이상 1,000,000 이하인 문자열 배열입니다.
//        operations의 원소는 큐가 수행할 연산을 나타냅니다.
//        원소는 “명령어 데이터” 형식으로 주어집니다.- 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.
//        빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.
//        입출력 예
//        operations	return
//        ["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]	[0,0]
//        ["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]	[333, -45]

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        List<Integer> list = new LinkedList<>();
        answer[0] = 0;
        answer[1] = 0;


        for(String operation : operations){
            String[] str = operation.split(" ");
            // str[0] == 삽입, 삭제 여부 체크
            String s = str[0];

            // str[1] == 삽입 값 / 삭제 값 확인
            int num = Integer.parseInt(str[1]);

            if( s.equals("I") ){
                list.add(num);
                list.sort(Comparator.naturalOrder());
            }else{
                if(list.size() > 0){
                    if(num != 1){
                        list.remove(0);
                    }else{
                        list.remove(list.size() - 1);
                    }
                }
            }

        }

        if(list.size() > 0){
            answer[1] = list.get(0);
            answer[0] = list.get(list.size() - 1);
        }

        return answer;
    }
}