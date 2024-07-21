// 문제
//        돌 게임은 두 명이서 즐기는 재밌는 게임이다.
//
//        탁자 위에 돌 N개가 있다.
//        상근이와 창영이는 턴을 번갈아가면서 돌을 가져가며,
//        돌은 1개 또는 3개 가져갈 수 있다.
//        마지막 돌을 가져가는 사람이 게임을 이기게 된다.
//
//        두 사람이 완벽하게 게임을 했을 때, 이기는 사람을 구하는 프로그램을 작성하시오. 게임은 상근이가 먼저 시작한다.
//
//        입력
//        첫째 줄에 N이 주어진다. (1 ≤ N ≤ 1000)
//
//        출력
//        상근이가 게임을 이기면 SK를, 창영이가 게임을 이기면 CY을 출력한다.

import java.util.*;

public class Q20240721(){
    public static String solution(int N){
        String result = "";

        // n 으로 인해서 결과값이 정해짐
        // 한턴에 돌을 가지고 갈 수 있는 경우의 수 1,1 / 1,3 / 3,1/ 3,3
//        30 2 ,4, 6 짝수네
//        최소 공배수 문제인거 같은데 --> 2,4,6의 최소 공배수를 확인해서 나머지를 에 대해서 체크

//        30이라면 2로 나누면 끝나기 때문에
        if( N % 2 == 0 ){
            result = "CY";
        }else{
            result = "SK";
        }
        return result;
    }
}

import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {

        int[] answer = new int[(int) ((right-left)+1)];

        int index = 0;

        for(long i = left ; i<=right;i++){
            answer[index++] = (int) Math.max((i/n)+1 , i%n+1);
        }

        return answer;
    }
}

import java.util.*;

class Node{
    String skill_name = "";
    String skill_num = "";

    public Node(String skill_name, String skill_num){
        this.skill_name = skill_name;
        this.skill_num = skill_num;
    }
}


class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        String[] skills = skill.split("");
        Map<String, Integer> skill_map = new HashMap<>();

        for(int i = 0; i < skills.length; i++){
            skill_map.put(skills[i], i);
        }

        for(String skill_tree : skill_trees){
            String[] now_skill = skill_tree.split("");

            int skill_len = now_skill.length;

            List<String> skill_str = new ArrayList<>();

            for(int i = 0; i < skill_len; i++){
                boolean isExist = Arrays.stream(skills).anyMatch(now_skill[i]::equals);

                if(isExist){
                    skill_str.add(now_skill[i]);
                }
            }

            String[] result_skill = skill_str.stream().toArray(String[]::new);

            int chk_int = -1;
            boolean chk = true;
            for(int j = 0; j < result_skill.length; j++){

                int chk_skill = skill_map.get(result_skill[j]);

                if(j == 0 && chk_skill != 0){
                    chk = false;
                    break;
                }else{
                    if(chk_skill != chk_int+1){
                        chk = false;
                        break;
                    }else{
                        chk_int = chk_skill;
                    }
                }
            }
            System.out.println("   ");

            if(chk) answer++;
        }

        return answer;
    }
}