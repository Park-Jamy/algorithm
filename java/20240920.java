import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static boolean[] check;
    static int[][] board;
    static StringTokenizer st;

    static int MIN_RESULT = Integer.MAX_VALUE;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        check = new boolean[N+1];
        board = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 1);
        System.out.println(MIN_RESULT);
    }

    static void combination(int dep, int start) {
        if(dep == N/2) {
            MIN_RESULT = Math.min(MIN_RESULT, getResult());
            return;
        }

        for(int i=start; i<=N; i++) {

            check[i] = true;
            combination(dep+1, i+1);
            check[i] = false;
        }
    }

    static int getResult() {
        int start = 0;
        int link = 0;

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(i == j) continue;

                if(check[i] && check[j]) start += board[i][j];
                if(!check[i] && !check[j]) link += board[i][j];
            }
        }
        return Math.abs(start - link);
    }
}

// import java.io.*;

// public class Main {

//     private static int[][] Sij;
//     private static int N;
//     private static boolean[] chk;

//     private static int min = Integer.MAX_VALUE;

//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         N = Integer.parseInt(br.readLine());


//         Sij = new int[N][N];
//         chk = new boolean[N];

//         for(int i = 0; i < N; i++){
//             String[] si = br.readLine().split(" ");
//             for(int j = 0; j < N; j++){
//                 Sij[i][j] = Integer.parseInt(si[j]);
//             }
//         }

//         splitTeam(N/2);

//         System.out.println(min);
//     }

//     // 2개의 팀으로 나누는 부분
//     private static void splitTeam(int n){
//         if(min == 0) return;
//         // n: 각 팀별 인원
//         if(n == 0){ // 두 팀의 차이 확인
//             int result = calc();

//             min = Math.min(min, result);
//             return;
//         }else {
//             for (int i = 0; i < N; i++) {
//                 if (chk[i]) continue; // i 순번이 들어가 있는지 체크
//                 chk[i] = true;

//                 splitTeam(n - 1);

//                 chk[i] = false;
//             }
//         }
//     }

//     // 나눈 팀 내에 능력치 구하기
//     // 2명씩 선택해 값 합치기
//     private static int calc(){
//         int n = N / 2;

//         int result = 0;

//         for(int i = 0; i < N - 1; i++){
            
//             for(int j = i + 1; j < N; j++) {
//                 if (chk[i] == true && chk[j] == true){
//                     result += Sij[i][j];
//                     result += Sij[j][i];
//                 }
                
//                 if(chk[i] == false && chk[j] == false) {
//                     result -= Sij[i][j];
//                     result -= Sij[j][i];   
//                 }
//             }
//         }

//         return result;
//     }
// }
