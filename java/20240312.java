//JadenCase 문자열 만들기
//        제출 내역
//        문제 설명
//        JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다.
//        단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)
//        문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.
//
//        제한 조건
//        s는 길이 1 이상 200 이하인 문자열입니다.
//        s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있습니다.
//        숫자는 단어의 첫 문자로만 나옵니다.
//        숫자로만 이루어진 단어는 없습니다.
//        공백문자가 연속해서 나올 수 있습니다.

//        입출력 예
//        s	return
//        "3people unFollowed me"	"3people Unfollowed Me"
//        "for the last week"	"For The Last Week"

import java.util.Arrays;
import java.util.List;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] stringList = s.split(" "); // 공백기준으로 나누기

        int stringLen = stringList.length;

        for(int i = 0; i < stringLen; i++){
            String nowString = stringList[i];
            int nowLen = stringList[i].length();

            // 해당 스트링이 아무것도 없을 경우 공백만 저장
            if(nowLen == 0) answer += " ";
            else{
                answer += nowString.substring(0,1).toUpperCase();
                answer += nowString.substring(1,nowLen).toUpperCase();
                answer += " ";
            }

        }

        // 입력 받은 문자열의 맨 마지막이 " " 라면 바로 answer 반환
        if(s.substring(s.length()-1, s.length()).equals(" ")){
            return answer;
        }

        // 맨 마지막 " " 제거하고 answer 반환
        return answer.substring(0, answer.length()-1);

    }
}


//    피보나치 수
//    제출 내역
//    문제 설명
//    피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.
//
//        예를들어
//
//        F(2) = F(0) + F(1) = 0 + 1 = 1
//        F(3) = F(1) + F(2) = 1 + 1 = 2
//        F(4) = F(2) + F(3) = 1 + 2 = 3
//        F(5) = F(3) + F(4) = 2 + 3 = 5
//        와 같이 이어집니다.
//
//        2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.
//
//        제한 사항
//        n은 2 이상 100,000 이하인 자연수입니다.
//
//        입출력 예
//        n	return
//        3	2
//        5	5

class Solution {
    public int solution(int n) {
        int answer = 0;

        int one = 0;
        int two = 1;

        int count = 2;

        // F(0) = 0, F(1) = 1,  n = 2부터 시작
        while(true){
            answer = (one + two) % 1234567;

            one = two;
            two = answer;

            if( count == n ) break;
            count++;
        }

        int a = answer % 1234567;

        return a;
    }

}

//    영어 끝말잇기
//    제출 내역
//    문제 설명
//1부터 n까지 번호가 붙어있는 n명의 사람이 영어 끝말잇기를 하고 있습니다. 영어 끝말잇기는 다음과 같은 규칙으로 진행됩니다.
//
//        1번부터 번호 순서대로 한 사람씩 차례대로 단어를 말합니다.
//        마지막 사람이 단어를 말한 다음에는 다시 1번부터 시작합니다.
//        앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다.
//        이전에 등장했던 단어는 사용할 수 없습니다.
//        한 글자인 단어는 인정되지 않습니다.
//        다음은 3명이 끝말잇기를 하는 상황을 나타냅니다.
//
//        tank → kick → know → wheel → land → dream → mother → robot → tank
//
//        위 끝말잇기는 다음과 같이 진행됩니다.
//
//        1번 사람이 자신의 첫 번째 차례에 tank를 말합니다.
//        2번 사람이 자신의 첫 번째 차례에 kick을 말합니다.
//        3번 사람이 자신의 첫 번째 차례에 know를 말합니다.
//        1번 사람이 자신의 두 번째 차례에 wheel을 말합니다.
//        (계속 진행)
//        끝말잇기를 계속 진행해 나가다 보면, 3번 사람이 자신의 세 번째 차례에 말한 tank 라는 단어는 이전에 등장했던
//        단어이므로 탈락하게 됩니다.
//
//        사람의 수 n과 사람들이 순서대로 말한 단어 words 가 매개변수로 주어질 때,
//        가장 먼저 탈락하는 사람의 번호와 그 사람이 자신의 몇 번째 차례에 탈락하는지를 구해서
//        return 하도록 solution 함수를 완성해주세요.
//
//        제한 사항
//        끝말잇기에 참여하는 사람의 수 n은 2 이상 10 이하의 자연수입니다.
//        words는 끝말잇기에 사용한 단어들이 순서대로 들어있는 배열이며, 길이는 n 이상 100 이하입니다.
//        단어의 길이는 2 이상 50 이하입니다.
//        모든 단어는 알파벳 소문자로만 이루어져 있습니다.
//        끝말잇기에 사용되는 단어의 뜻(의미)은 신경 쓰지 않으셔도 됩니다.
//        정답은 [ 번호, 차례 ] 형태로 return 해주세요.
//        만약 주어진 단어들로 탈락자가 생기지 않는다면, [0, 0]을 return 해주세요.

//        입출력 예
//        n	words	result
//        3	["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"]	[3,3]
//        5	["hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"]	[0,0]
//        2	["hello", "one", "even", "never", "now", "world", "draw"]	[1,3]

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        //List<String> wordList = Arrays.asList(words);

        // 1. 걸린게 있는지 없는지 체크
        // 1-1. 이전 데이터(리스트)에서 확인하여 있는 경우에 체크
        // 1-2. i-1 데이터마지막 글자와 i번째 첫글자가 동일한지 확인
        // 2. n으로 나눈 수에 대해서 번호가 몇번인지 확인
        // 2-1. 이전 데이터 확인해 나머지가 n인 건이 몇건인지 확인

        for(int i = 1; i < words.length; i++) {

            // 1-1
            List<String> wordList = Arrays.asList(Arrays.copyOfRange(words, 0, i)); // 과거 단어 list
            String nowWord = words[i]; // 현재 단어

            // 1-2
            char end = words[i-1].charAt(words[i-1].length() - 1);
            char start = words[i].charAt(0);

            // 현재 단어가 이전에 나왔는지 체크
            if (wordList.contains(nowWord) || end == start ) { // 나왔다면
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;

                break;
            }

            if(i == words.length) {
                answer[0] = 0;
                answer[1] = 0;
            }
        }

        return answer;
    }
}


//    N개의 최소공배수
//    제출 내역
//    문제 설명
//    두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다.
//    예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중
//    공통이 되는 가장 작은 숫자가 됩니다. n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수,
//    solution을 완성해 주세요.
//
//        제한 사항
//        arr은 길이 1이상, 15이하인 배열입니다.
//        arr의 원소는 100 이하인 자연수입니다.
//
//        입출력 예
//        arr	result
//        [2,6,8,14]	168
//        [1,2,3]	6

class Solution {
    public int solution(int[] arr) {
        int answer = 0;

        // 2개의 수를 비교해가며 최소 공배수 추출
        // 추출된 최소 공배수와 다음 입력값에 대해서 최소 공배수 추출
        // 반복

        // 최소 공배수 추출
        // 1. 작은 값 순서로 sort
        // 2. a *( 1, 2 ,3, 4, 5, i) % b == 0 인 경우인 i 값 추출
        // 3. i와 리스트의 다음 값의 최소 공배수 추출
        // 반복
        Arrays.sort(arr);

        int a = 0;
        int b = 0;

        int minMulti = 0;

        for(int j = 0; j < arr.length-1; j++){

            if( j == 0 ){
                a = arr[j];
                b = arr[j+1];
            }
            else {
                if( minMulti > arr[j+1] ) {
                    a = arr[j + 1];
                    b = minMulti;
                }
                else if (minMulti < arr[j+1]){
                    a = minMulti;
                    b = arr[j + 1];
                }
                else {
                    continue;
                }
            }

            for(int i = 1; i <= 10000000; i++){
                int now = a * i;

                if(now % b == 0){
                    minMulti = now;
                    break;
                }
            }
        }

        return minMulti;
    }
}