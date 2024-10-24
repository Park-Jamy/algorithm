import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[][] map = new int[n][m];

        for(int i = 0; i < n; i++){
            String[] nStr = br.readLine().split("");

            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(nStr[j]);
            }
        }

        int answer = solution(n, m ,map);

        System.out.println((int)Math.pow(answer + 1, 2));
    }

    private static int solution(int n, int m, int[][] map){
        int answer = 0;

        // 첫 번째 꼭짓점이 되는 부분 확인
        // 한 변의 길이가 l 이라면 l에 따라 동일한 값이 있는지 확인 l 을 +1씩 늘려가면서 확인
        // n - 2 / m - 2 까지만 확인
        // l의 최댓값은 Math.min(n, m)

        int maxL = Math.min(n, m);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int x = i;
                int y = j;

                int data = map[x][y];

                int l = 0;

                for(int k = maxL; k > 0; k--){
                    if(x + k > n - 1 || y + k > m - 1) continue;

                    int chk1 = map[x][y + k];
                    int chk2 = map[x + k][y];
                    int chk3 = map[x + k][y + k];

                    if(data != chk1 || data != chk2 || data != chk3) continue;
                    else {
                        l = k;

                        answer = Math.max(answer, l);

                        break;
                    }
                }


            }
        }

        return answer;
    }
}

import java.io.*;
public class Main{
    public static void main(String args[]) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int count = Integer.parseInt(br.readLine());
            long d[] = new long[count+1];
            // d[n] = n자리 이친수.
            d[0] = 0;
            d[1] = 1;
            for (int i = 2; i <= count; i++){
                d[i] = d[i-1] + d[i-2];
            }
            System.out.println(d[count]);
    }
}
