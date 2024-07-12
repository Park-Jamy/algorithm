import java.util.*;

public class 20240712{
    public static int solution(int[] n){
        // 발판 개수
        int n_len = n.length;

        int[] dp = new int[n_len];

        for(int i = 0; i < n_len; i++){
            if( i == 0 ) dp[i] = 0;
            else if( i == 1 ) dp[i] = Math.abs(n[i] - n[i-1]);
            else{
                int dp1 = dp[i-1] + Math.abs(n[i] - n[i-1]);
                int dp2 = dp[i-2] + Math.abs(n[i] - n[i-2]);

                dp[i] = Math.min(dp1, dp2);
            }
        }

        return dp[n_len-1];
    }
}


package org.Y2024.M06.D26;

import java.util.ArrayList;
import java.util.List;

public class Q2024071201 {
    public static int[] solution(int acount) {
        int[] coin = {100, 50, 10, 1};
        List<Integer> list_coin = new ArrayList<>();
        // 최소한의 화폐 수로 acount 가격 정리
        // 100, 50, 10, 1
        // 높은 값 부터 acount를 나눔
        // 몫 = 화폐 수
        // 나머지 = 다른 화폐로 확인

        for(int i = 0; i < coin.length; i++){
            int calc_coin = coin[i];

            // 만약 화폐 금액이 acount 보다 크다면 다음 화폐로 넘어감
            if(calc_coin > acount) continue;

            // 현재 화폐를 사용하는 갯수
            int num_coin = (int) acount / calc_coin;
            for(int j = 0; j < num_coin; j++){
                list_coin.add(calc_coin);
            }

            acount -= num_coin * calc_coin;
        }


        int[] result = list_coin.stream()
                .mapToInt(i -> i)
                .toArray();

        return result;
    }
}
