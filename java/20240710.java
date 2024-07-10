package org.Y2024.M06.D26;

import java.util.Stack;

public class q20240710 {
    public static String[] Solution(String[] s) {
        String[] st = new String[s.length];
        // 주어지는 String 값 안에서 110 값이 있는지 확인 -> subString 사용
        // subString(a, a+3) a값 올려가면서 110 있는지 체크
        // 마지막 0 뒤에 붙인다.
        // 110제외 하고 모든 값을 stack에 넣는다.
        // 110이 없어질때 까지 반복한다.

        Stack<Character> ss;
        String str;
        for(int a = 0; a < s.length; a++){
            str = s[a];
            int sLen = str.length();
            ss = new Stack<>();

            for(int i = 0; i <= sLen - 3; i++){ // subString(a, a+3) a값 올려가면서 110 있는지 체크
                String subStr = str.substring(i, i+3);

                StringBuffer sb = new StringBuffer();

                if(subStr.equals("110")){
                    for(int j = 0; j < sLen; j++){ // 110제외 하고 모든 값을 stack에 넣는다.
                        if(i > j || j > i + 3){
                            ss.push(str.charAt(j));
                        }
                    }

                    boolean chk = false;
                    while(!ss.isEmpty()){ // 마지막 0 뒤에 붙인다.
                        char c = ss.pop();
                        if(c == '0'){
                            sb.append("011");
                            chk = true;
                        }
                        sb.append(c);
                    }

                    if(!chk) sb.append("011"); // 0이 없을 경우 맨 앞에 붙임

                    sb.reverse();

                    str = sb.toString();

                    break;
                }
            }

            st[a] = str;
        }

        return st;
    }
}


//

package org.Y2024.M06.D26;

public class q202407101 {

    static boolean[][] chk;
    static int[] result;

    public static int[] Solution(int[][] arr) {
        result = new int[2];

        int arrlen = arr.length;

        dp(0,0,arrlen, arr);

        return result;
    }

    private static void dp(int x, int y, int size, int[][] arr){
        if(check(x, y, size, arr)){
            result[arr[x][y]]++;
            return;
        }

        dp(x, y, size/2, arr);
        dp(x, y + size/2, size/2, arr);
        dp(x + size/2, y, size/2, arr);
        dp(x + size/2, y + size/2, size/2, arr);
    }

    private static boolean check(int x, int y, int size, int[][] arr){
        int num = arr[x][y];

        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(num != arr[i][j]) return false;
            }
        }

        return true;
    }
}
