package org.Y2024.M06.D26;

//완호가 관리하는 어떤 데이터베이스의 한 테이블은 모두 정수 타입인 컬럼들로 이루어져 있습니다. 테이블은 2차원 행렬로 표현할 수 있으며 열은 컬럼을 나타내고, 행은 튜플을 나타냅니다.
//첫 번째 컬럼은 기본키로서 모든 튜플에 대해 그 값이 중복되지 않도록 보장됩니다. 완호는 이 테이블에 대한 해시 함수를 다음과 같이 정의하였습니다.

//해시 함수는 col, row_begin, row_end을 입력으로 받습니다.
//테이블의 튜플을 col번째 컬럼의 값을 기준으로 오름차순 정렬을 하되, 만약 그 값이 동일하면 기본키인 첫 번째 컬럼의 값을 기준으로 내림차순 정렬합니다.
//정렬된 데이터에서 S_i를 i 번째 행의 튜플에 대해 각 컬럼의 값을 i 로 나눈 나머지들의 합으로 정의합니다.
//row_begin ≤ i ≤ row_end 인 모든 S_i를 누적하여 bitwise XOR 한 값을 해시 값으로서 반환합니다.

//테이블의 데이터 data와 해시 함수에 대한 입력 col, row_begin, row_end이 주어졌을 때 테이블의 해시 값을 return 하도록 solution 함수를 완성해주세요.



public class q2024072402 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        int data_row = data.length;
        int data_len = data[0].length;
        int[] S_i = new int[data_row];


        // col 기준 동일한 datalist에 대해서 키값 기준 내림차순 정렬
        for(int i = 0; i < data_row; i++){
            int[] now_data_list = data[i];
            int main_data = now_data_list[col-1];

            for(int j = i; j < data_row; j++){
                int[] chk_data_list = data[j];
                int main_chk_data = chk_data_list[col-1];

                if(main_data == main_chk_data){
                    if(now_data_list[0] < chk_data_list[0]){
                        data[i] = chk_data_list;
                        data[j] = now_data_list;

                        i = j;
                    }
                }
            }
        }
        // col 기준 오름차순 정렬
        for(int i = 0; i < data_row; i++){
            int[] now_data_list = data[i];
            int main_data = now_data_list[col-1];

            for(int j = i; j < data_row; j++){
                int[] chk_data_list = data[j];
                int main_chk_data = chk_data_list[col-1];

                if(main_data > main_chk_data){ // 현재 데이터가 다음 데이터 보다 클 경우 순서 변경
                    data[i] = chk_data_list;
                    data[j] = now_data_list;

                    i = j;
                }
            }
        }



        for(int i = 0; i < data_row; i++){
            for(int j = 0; j < data_len; j++){
                System.out.print(data[i][j]);
            }
            System.out.println(" ");
        }

        for(int i = 0; i < data_row; i++){
            int modNum = i + 1;


            for(int j = 0; j < data_len; j++){
                S_i[i] += data[i][j] % modNum;
            }
        }

        for(int i = row_begin - 1; i < row_end; i++){
            answer ^= S_i[i];
        }


        return answer;
    }
}

//import java.util.*;
//class Solution {
//    public int solution(int[][] data, int col, int row_begin, int row_end) {
//        List<int[]> list = new ArrayList<>(Arrays.asList(data));
//        list.sort((o1, o2) -> {
//            int idx = col - 1;
//            if (o1[idx] == o2[idx]) {
//                return o2[0] - o1[0];
//            }
//
//            return o1[idx] - o2[idx];
//        });
//
//        int result = 0;
//        for (int i = row_begin - 1; i <= row_end - 1; i++) {
//            int[] cur = list.get(i);
//            int num = 0;
//            for (int val : cur) {
//                num += val % (i + 1);
//            }
//
//            result ^= num;
//        }
//
//        return result;
//    }
//}

