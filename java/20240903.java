//수박수박수박수박수박수?
//        제출 내역
//        문제 설명
//        길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요. 예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.
//
//        제한 조건
//        n은 길이 10,000이하인 자연수입니다.

class Solution {
    public String solution(int n) {
        String answer = "";

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                sb.append("수");
            }else{
                sb.append("박");
            }
        }

        answer = sb.toString();

        return answer;
    }
}

//    이상한 문자 만들기
//        제출 내역
//        문제 설명
//        문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
//
//        제한 사항
//        문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
//        첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split("");

        int idx = 0;
        for(int i=0; i<str.length; i++) {
            if(str[i].equals(" ")) {
                idx = 0;
            } else if(idx % 2 == 0) {
                str[i] = str[i].toUpperCase();
                idx++;
            } else if(idx % 2 != 0) {
                str[i] = str[i].toLowerCase();
                idx++;
            }
            answer += str[i];
        }

        return answer;
    }
}