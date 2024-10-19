// 백준 20125
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[][] ckman = new String[N][N];
        int[] heart = new int[2];
        heart[0] = -1;

        // 쿠키맨 초기화
        for(int i = 0; i < N; i++){
            String[] nowman = br.readLine().split("");

            for(int j = 0; j < N; j++){
                ckman[i][j] = nowman[j];

                if(heart[0] == -1 && ckman[i][j].equals("*")){
                    heart[0] = i + 1;
                    heart[1] = j;
                }
            }
        }

        int[] result = new int[5];

//        왼팔
        int startx = heart[0];
        int starty = heart[1];

        while(true){
            starty--;
            if(starty < 0) break;
            if(ckman[startx][starty].equals("*")) result[0]++;
            else break;
        }

//        오른팔
        startx = heart[0];
        starty = heart[1];
        while(true){
            starty++;
            if(starty > N - 1) break;
            if(ckman[startx][starty].equals("*")) result[1]++;
            else break;
        }

//        몸
        startx = heart[0];
        starty = heart[1];

        int[] tails = new int[2];

        while(true){
            startx++;
            if(startx > N - 1) {
                tails[0] = startx - 1;
                tails[1] = starty;
                break;
            }
            if(ckman[startx][starty].equals("*")) result[2]++;
            else {
                tails[0] = startx - 1;
                tails[1] = starty;
                break;
            }
        }
//        왼다리
        startx = tails[0];
        starty = tails[1] - 1;

        while(true){
            startx++;
            if(startx > N - 1) break;
            if(ckman[startx][starty].equals("*")) result[3]++;
            else break;
        }
//        오른다리
        startx = tails[0];
        starty = tails[1] + 1;

        while(true){
            startx++;
            if(startx > N - 1) break;
            if(ckman[startx][starty].equals("*")) result[4]++;
            else break;
        }


        System.out.println((heart[0]+1) + " " + (heart[1]+1));
        for(int i = 0; i < 5; i++){
            System.out.print(result[i] + " ");
        }
    }
}

// 21921 블로그

import java.io.*;
import java.util.*;

public class Main {

    private static int max = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NX = br.readLine().split(" ");

        int N = Integer.parseInt(NX[0]);
        int X = Integer.parseInt(NX[1]);

        int answer = 1;
        int[] visitedCnt = new int[N];

        String[] str = br.readLine().split(" ");

        for(int i = 0; i < N; i++){
            visitedCnt[i] = Integer.parseInt(str[i]);
        }

        int result = 0 ;

        // result 초기화
        for(int i = 0; i < X; i++) result += visitedCnt[i];
        max = result;

        for(int i = X; i < N; i++){
            result = result + visitedCnt[i] - visitedCnt[i - X];

            if(max == result) answer++;
            else if(max < result) {
                answer = 1;
                max = result;
            }
        }


        if(max == 0){
            System.out.println("SAD");
        }else {
            System.out.println(max);
            System.out.println(answer);
        }
    }
}
/*
public class Main {

    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NX = br.readLine().split(" ");

        int N = Integer.parseInt(NX[0]);
        int X = Integer.parseInt(NX[1]);

        int answer = 0;
        int[] visitedCnt = new int[N];

        String[] str = br.readLine().split(" ");

        for(int i = 0; i < N; i++){
            visitedCnt[i] = Integer.parseInt(str[i]);
        }



        for(int i = 0; i < N - X + 1; i++){
            int[] copy = Arrays.copyOfRange(visitedCnt, i, i + X);

            int result = 0 ;

            result = Arrays.stream(copy).sum();

            if(max == result) answer++;
            else if(max < result) {
                answer = 1;
                max = result;
            }
        }
        if(max == 0){
            System.out.println("SAD");
        }else {
            System.out.println(max);
            System.out.println(answer);
        }
    }
}
*/
