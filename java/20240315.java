//자연수 뒤집어 배열로 만들기
//        제출 내역
//        문제 설명
//        자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
//
//        제한 조건
//        n은 10,000,000,000이하인 자연수입니다.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(long n) {
//        String s = String.valueOf(n);
//        StringBuilder sb = new StringBuilder(s);
//        sb = sb.reverse();
//        String[] ss = sb.toString().split("");

        int[] answer = {};

        String[] s = (String.valueOf(n)).split("");
        int sLeng = s.length;

        for(int i = 0; i < sLeng; i++){
            answer[i] = Integer.valueOf(s[sLeng - 1 - i]);
        }

        return answer;
    }
}


//    직사각형 별찍기
//    제출 내역
//    문제 설명
//    이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.
//        별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해보세요.
//
//        제한 조건
//        n과 m은 각각 1000 이하인 자연수입니다.

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        String n = "";

        for(int i = 0; i < a; i++){
            n += "*"; // 가로줄 완성
        }

        for(int i = 0; i < b; i++){
            System.out.println(n);
        }
    }
}


//    숫자 문자열과 영단어
//        제출 내역
//        문제 설명
//        img1.png
//
//        네오와 프로도가 숫자놀이를 하고 있습니다. 네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면
//        프로도는 원래 숫자를 찾는 게임입니다.
//
//        다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.
//
//        1478 → "one4seveneight"
//        234567 → "23four5six7"
//        10203 → "1zerotwozero3"
//        이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다.
//        s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.
//
//        참고로 각 숫자에 대응되는 영단어는 다음 표와 같습니다.
//
//        숫자	영단어
//        0	zero
//        1	one
//        2	two
//        3	three
//        4	four
//        5	five
//        6	six
//        7	seven
//        8	eight
//        9	nine
//        제한사항
//        1 ≤ s의 길이 ≤ 50
//        s가 "zero" 또는 "0"으로 시작하는 경우는 주어지지 않습니다.
//        return 값이 1 이상 2,000,000,000 이하의 정수가 되는 올바른 입력만 s로 주어집니다.

class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder strAnswer = new StringBuilder();

        // 문자 체크 용 배열
        String[][] strNum = {
                {"zero" , "0"},
                {"one"  , "1"},
                {"two"  , "2"},
                {"three" , "3"},
                {"four" , "4"},
                {"five" , "5"},
                {"six"  , "6"},
                {"seven" , "7"},
                {"eight" , "8"},
                {"nine" , "9"}
        };

        // char 로 변경 후, 숫자이면 strAnswer에 추가 후 s에서 삭제
        // 문자이면 어떤 문자인지 체크
        // StringBuilder 사용해서 add 시킴

        StringBuilder sb = new StringBuilder();

        // 문제의 문자 길이
        int sLen = s.length();

        for(int i = 0; i < sLen; i++){
            String strNowChk = String.valueOf(s.charAt(i));
            if( s.charAt(i) - '0' <= 9 ) strAnswer.append(strNowChk); // 숫자일 경우 strAnswer에 더하기
            else { // 문자일 경우 sb에 넣어서 체크
                sb.append(strNowChk); // 체크할 문자
                for(int j = 0; j < 10; j++){
                    if((sb.toString()).equals(strNum[j][0]))  {
                        strAnswer.append(strNum[j][1]);
                        sb = new StringBuilder();
                    }
                }

            }
        }

        return Integer.parseInt(strAnswer.toString());
    }

//    String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
//        for(int i = 0; i < strArr.length; i++) {
//        s = s.replaceAll(strArr[i], Integer.toString(i));
//    }
//        return Integer.parseInt(s);
}


//    두 개 뽑아서 더하기
//    제출 내역
//    네트워크 연결 끊김
//        문제 설명
//        정수 배열 numbers가 주어집니다. numbers에서 서로 다른 인덱스에 있는
//        두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
//
//        제한사항
//        numbers의 길이는 2 이상 100 이하입니다.
//        numbers의 모든 수는 0 이상 100 이하입니다.
//        입출력 예
//        numbers	result
//        [2,1,3,4,1]	[2,3,4,5,6,7]
//        [5,0,2,7]	[2,5,7,9,12]

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer;
        List<Integer> li = new ArrayList<>();

        int numLen = numbers.length;

        for(int i = 0 ; i < numLen - 1; i++){
            int nowNum = numbers[i]; // 덧셈에 기준이 되는 수

            for(int j = i + 1; j < numLen; j++){
                int chkNum = nowNum + numbers[j]; // 덧셈된 후의 수

                //덧셈이 완료되었을 때 answer에 해당 수가 있는지 체크
                if( !li.contains(chkNum) ) li.add(chkNum);
            }
        }

        answer = new int[li.size()];

        for(int i = 0; i < li.size(); i++)
            answer[i] = li.get(i);

        Arrays.sort(answer);

        return answer;
    }
}


//[1차] 다트 게임
//        제출 내역
//        문제 설명
//        다트 게임
//        카카오톡에 뜬 네 번째 별! 심심할 땐? 카카오톡 게임별~
//
//        Game Star
//
//        카카오톡 게임별의 하반기 신규 서비스로 다트 게임을 출시하기로 했다. 다트 게임은 다트판에 다트를 세 차례 던져 그 점수의 합계로 실력을
//        겨루는 게임으로, 모두가 간단히 즐길 수 있다.
//        갓 입사한 무지는 코딩 실력을 인정받아 게임의 핵심 부분인 점수 계산 로직을 맡게 되었다. 다트 게임의 점수 계산 로직은 아래와 같다.
//
//        다트 게임은 총 3번의 기회로 구성된다.
//        각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
//        점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서
//        1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
//        옵션으로 스타상(*) , 아차상(#)이 존재하며
//        스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다.
//        아차상(#) 당첨 시 해당 점수는 마이너스된다.
//        스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
//        스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
//        스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
//        Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
//        스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
//        0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.
//
//        입력 형식
//        "점수|보너스|[옵션]"으로 이루어진 문자열 3세트.
//        예) 1S2D*3T
//
//        점수는 0에서 10 사이의 정수이다.
//        보너스는 S, D, T 중 하나이다.
//        옵선은 *이나 # 중 하나이며, 없을 수도 있다.

//        출력 형식
//        3번의 기회에서 얻은 점수 합계에 해당하는 정수값을 출력한다.
//        예) 37
//
//        입출력 예제
//        예제	dartResult	answer	설명
//        1	1S2D*3T	    37	11 * 2 +    22 * 2 + 33
//        2	1D2S#10S	9	12 +        21 * (-1) + 101
//        3	1D2S0T	    3	12 +        21 + 03
//        4	1S*2T*3S	23	11 * 2 * 2 + 23 * 2 + 31
//        5	1D#2S*3S	5	12 * (-1) * 2 + 21 * 2 + 31
//        6	1T2D3D#	    -4	13 + 22 + 32 * (-1)
//        7	1D2S3T*	    59	12 + 21 * 2 + 33 * 2


class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        double[] calc = new double[10];

        // 베열을 통해서 우선적으로 계산해 놓은 다음 다음 차례 데이터에서 영향도가 있을 경우 변경
        // S, D, T 에 대한 조건 추가
        // *, #에 대한 조건 추가
        int calcCnt = 0;

        // s,d,t 를 기준으로 앞뒤에 숫자와 옵션을 체크
        for( int i = 1; i < dartResult.length(); i++ ){
            char nowChar = dartResult.charAt(i);

            if( nowChar == 'S' ){
                // i-1은 숫자 - 숫자가 0이면 i-2까지 체크
                // i+1은 옵션 (만약 숫자면  continue)
                int nowNum = dartResult.charAt(i-1) - '0';

                // 숫자 데이터 넣기
                calc[calcCnt] = nowNum;
                if( i >= 2 && dartResult.charAt(i-2) == '1' ) {// 10인 경우
                    calc[calcCnt] = 10;
                }

                if( i+1 != dartResult.length() ) {
                    char nowOption = dartResult.charAt(i + 1);
                    // 옵션 체크
                    if (nowOption == '*') {
                        calc[calcCnt] = calc[calcCnt] * 2;
                        if (calcCnt > 0) {
                            calc[calcCnt - 1] = calc[calcCnt - 1] * 2;
                        }
                    } else if (nowOption == '#') {
                        calc[calcCnt] = -calc[calcCnt];
                    }
                }

                // 다음 수 투구 확인을 위해 1++
                calcCnt += 1;
            } else if( nowChar == 'D' ) {

                // i-1은 숫자 - 숫자가 0이면 i-2까지 체크
                // i+1은 옵션 (만약 숫자면  continue)
                int nowNum = dartResult.charAt(i-1) - '0';

                // 숫자 데이터 넣기
                calc[calcCnt] = Math.pow(nowNum, 2);
                if( i >= 2 && dartResult.charAt(i-2) == '1' ) {// 10인 경우
                    calc[calcCnt] = Math.pow(10, 2);
                }

                // 옵션 체크
                if( i+1 != dartResult.length() ) {
                    char nowOption = dartResult.charAt(i + 1);
                    if (nowOption == '*') {
                        calc[calcCnt] = calc[calcCnt] * 2;
                        if (calcCnt > 0) {
                            calc[calcCnt - 1] = calc[calcCnt - 1] * 2;
                        }
                    } else if (nowOption == '#') {
                        calc[calcCnt] = -calc[calcCnt];
                    }
                }

                // 다음 수 투구 확인을 위해 1++
                calcCnt += 1;
            } else if( nowChar == 'T' ){
                // i-1은 숫자 - 숫자가 0이면 i-2까지 체크
                // i+1은 옵션 (만약 숫자면  continue)
                int nowNum = dartResult.charAt(i-1) - '0';

                // 숫자 데이터 넣기
                calc[calcCnt] = Math.pow(nowNum, 3);
                if( i >= 2 && dartResult.charAt(i-2) == '1' ) {// 10인 경우
                    calc[calcCnt] = Math.pow(10, 3);
                }

                // 옵션 체크
                if( i+1 != dartResult.length() ) {
                    char nowOption = dartResult.charAt(i + 1);
                    if (nowOption == '*') {
                        calc[calcCnt] = calc[calcCnt] * 2;
                        if (calcCnt > 0) {
                            calc[calcCnt - 1] = calc[calcCnt - 1] * 2;
                        }
                    } else if (nowOption == '#') {
                        calc[calcCnt] = -calc[calcCnt];
                    }
                }

                // 다음 수 투구 확인을 위해 1++
                calcCnt += 1;
            }
        }

        answer = (int)calc[0] + (int)calc[1] +(int)calc[2];

        return answer;

    }
}