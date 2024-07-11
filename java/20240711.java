package org.Y2024.M06.D26;

import java.util.*;
public class q2024071101 {
    static boolean[] check;//방문 배열
    static HashSet<String> set;//경우의 수를 담기위한 HashSet
    public static int solution(String[] userid, String[] banid) {
        check = new boolean[userid.length];
        set = new HashSet<String>();

        //정규식표현을 위해 '*'를 '.'로 바꾼다.
        //정규식표현에서 '.'은 해당 위치의 모든 문자를 대변한다.
        for(int i=0; i<banid.length; i++)
            banid[i] = banid[i].replace('*', '.');

        back(0,"",banid,userid);//조합

        return set.size();
    }

    public static void back(int depth, String res, String[] banid, String[] userid) {
        if(depth==banid.length) {//불량유저id 개수만큼 조합이 만들질때 종료
            //조합된 아아디 배열에 담고 정렬
            String[] arr = res.split(" ");
            Arrays.sort(arr);

            String str="";
            for(String s:arr) str+=s;//정렬된 id들을 하나의 문자열로 추가
            set.add(str);//중복되는 경우의수는 HashSet로 하나만 남음.

            return;
        }

        for(int i=0; i<userid.length; i++) {//유저id 조합
            //이미 쓴 유저id or 불량 id중 '.'을 제오하고 유저id랑 다른 부분이 있으면 탐색안함.
            if(check[i] || !userid[i].matches(banid[depth])) continue;
            check[i]=true;
            back(depth+1,userid[i]+" "+res,banid,userid);
            check[i]=false;
        }
    }

}


package org.Y2024.M06.D26;

public class q2024071102 {
    public static int solution(int n, int k){

        int answer = 0;

        // 10진수 n을 k 진수로 변경하는 방법
        String tans_n = Integer.toString(n, k);

        // 0을 기준으로 나눔
        String[] s = tans_n.split("0");

        int s_len = s.length;

        for(int i = 0; i < s_len; i++){
            if(!s[i].equals("")) {
                //s[i]가 소수인지 여부 체크
                long sn = Long.parseLong(s[i]);

                if (calc(sn)) answer++;
            }
        }

        return answer;
    }

    private static boolean calc(long n){
        long calc_n = n;

        if(calc_n == 1) return false;

        for(int i = 2; i <= n/2; i++){
            if(calc_n % i == 0) return false;
        }

        return true;
    }
}

package org.Y2024.M06.D26;

        import java.util.*;

public class q2024071103 {

    static class XY{
        int x;
        int y;

        public XY(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static int[] solution(String[][] places){

        int places_len = places.length;
        int place_len = places[0].length;
        // 결과값 초기화
        int[] result = new int[places_len];
        for(int i = 0; i < places_len; i++){
            result[i] = 1;
        }

        Queue<XY> qm = new LinkedList<>();

        //String을 검색하면서 P가 있는지 확인하고 P가 있다면 해당 값을 Queue에 저장
        for(int i = 0; i < places_len; i++){

            String[] s = places[i];

            int s_len = s.length;

            // P 있는지 확인 후 큐에 저장
            for(int j = 0; j < s_len; j++){
                for(int k = 0; k < s_len; k++){
                    if(s[j].charAt(k) == 'P'){
                        qm.add(new XY(j,k));
                    }
                }
            }

            while(qm.size() != 0){
                // 비교해야 하는 기준 P 값의 XY 값
                XY now = qm.poll();

                // 내부 값들과 비교
                for (XY element : qm) {
                    int memhathon = Math.abs(now.x - element.x) + Math.abs(now.y - element.y);
                    if(memhathon < 2) result[i] = 0;
                }
            }
        }

        return result;
    }

}