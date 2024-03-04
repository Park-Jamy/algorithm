//코드 처리하기
//제출 내역
//문제 설명
//문자열 code가 주어집니다.
//code를 앞에서부터 읽으면서 만약 문자가 "1"이면 mode를 바꿉니다. mode에 따라 code를 읽어가면서 문자열 ret을 만들어냅니다.
//
//mode는 0과 1이 있으며, idx를 0 부터 code의 길이 - 1 까지 1씩 키워나가면서 code[idx]의 값에 따라 다음과 같이 행동합니다.
//
//mode가 0일 때
//code[idx]가 "1"이 아니면 idx가 짝수일 때만 ret의 맨 뒤에 code[idx]를 추가합니다.
//code[idx]가 "1"이면 mode를 0에서 1로 바꿉니다.
//mode가 1일 때
//code[idx]가 "1"이 아니면 idx가 홀수일 때만 ret의 맨 뒤에 code[idx]를 추가합니다.
//code[idx]가 "1"이면 mode를 1에서 0으로 바꿉니다.
//문자열 code를 통해 만들어진 문자열 ret를 return 하는 solution 함수를 완성해 주세요.
//
//단, 시작할 때 mode는 0이며, return 하려는 ret가 만약 빈 문자열이라면 대신 "EMPTY"를 return 합니다.
//
//제한사항
//1 ≤ code의 길이 ≤ 100,000
//code는 알파벳 소문자 또는 "1"로 이루어진 문자열입니다.

class Solution {
    public String solution(String code) {
        String answer = "";
        int mode = 0;
        
        for(int idx = 0; idx < code.length(); idx++){
            String codeChk = String.valueOf(code.charAt(idx));
            
            if(codeChk.equals("1")) mode = mode == 0 ? 1 : 0;
            else {
                if(mode == 0){
                    if(idx % 2 == 0) answer += codeChk;
                }else{
                    if(idx % 2 != 0) answer += codeChk;
                }
            }
        }
        
        return answer.equals("") ? "EMPTY" : answer;
        if(answer.equals("")){
            return "EMPTY";
        }else{
            return answer;   
        }
    }
}

// 좋은 답변 -- mode 가 나머지 값으로 생각하고 진행 
class Solution {
    public String solution(String code) {
        StringBuilder answer = new StringBuilder();
        int mode = 0;
        for (int i = 0; i < code.length(); i++) {
            char current = code.charAt(i);
            if (current == '1') {
                mode = mode == 0 ? 1 : 0;
                continue;
            }

            if (i % 2 == mode) {
                answer.append(current);
            }
        }
        return answer.length() == 0 ? "EMPTY" : answer.toString();
    }
}


//등차수열의 특정한 항만 더하기
//제출 내역
//문제 설명
//두 정수 a, d와 길이가 n인 boolean 배열 included가 주어집니다. 첫째항이 a, 공차가 d인 등차수열에서 included[i]가 i + 1항을 의미할 때, 이 등차수열의 1항부터 n항까지 included가 true인 항들만 더한 값을 return 하는 solution 함수를 작성해 주세요.
//
//제한사항
//1 ≤ a ≤ 100
//1 ≤ d ≤ 100
//1 ≤ included의 길이 ≤ 100
//included에는 true가 적어도 하나 존재합니다.

class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        int n = included.length;
        
        for(int i = 0; i < n; i++){
            int add = a + d*i;
            if(included[i]) answer += add;
        }
        
        return answer;
    }
}


//주사위 게임 2
//제출 내역
//문제 설명
//1부터 6까지 숫자가 적힌 주사위가 세 개 있습니다. 세 주사위를 굴렸을 때 나온 숫자를 각각 a, b, c라고 했을 때 얻는 점수는 다음과 같습니다.
//
//세 숫자가 모두 다르다면 a + b + c 점을 얻습니다.
//세 숫자 중 어느 두 숫자는 같고 나머지 다른 숫자는 다르다면 (a + b + c) × (a2 + b2 + c2 )점을 얻습니다.
//세 숫자가 모두 같다면 (a + b + c) × (a2 + b2 + c2 ) × (a3 + b3 + c3 )점을 얻습니다.
//세 정수 a, b, c가 매개변수로 주어질 때, 얻는 점수를 return 하는 solution 함수를 작성해 주세요.
//
//제한사항
//a, b, c는 1이상 6이하의 정수입니다.

// 좋은 답변-pow 함수를 통해서 몇 제곱하는지 확인
class Solution {
    public int solution(int a, int b, int c) {
        int answer = 1;
        int count = 1;
        
        if( a == b || b == c || c == a) count++;
        if( a == b && b == c) count++;
        
        for(int i = 1; i <= count; i++){
            answer *= pow(a,i) + pow(b,i) + pow(c,i);
        }
        
        return answer;
    }
    
    private int pow(int base, int count){
        if(count == 0) return 1;
        else return base*pow(base, count-1);
    }
}

//         int answer = 0;
        
//         int count = 0;
        
//         if(a == b) count ++;
//         if(c == b) count ++;
//         if(c == a) count ++;
        
//         if(count == 0) answer = a + b + c;
//         else if(count == 1) answer = (a + b + c) * (a*a + b*b + c*c);
//         else answer = (a + b + c) * (a*a + b*b + c*c) * (a*a*a + b*b*b + c*c*c);
            
//         return answer;


//원소들의 곱과 합
//제출 내역
//문제 설명
//정수가 담긴 리스트 num_list가 주어질 때, 모든 원소들의 곱이 모든 원소들의 합의 제곱보다 작으면 1을 크면 0을 return하도록 solution 함수를 완성해주세요.
//
//제한사항
//2 ≤ num_list의 길이 ≤ 10
//1 ≤ num_list의 원소 ≤ 9

class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int numSum2 = 0;
        int nuMulti = 1;
        
        for(int i = 0; i < num_list.length; i++){
            numSum2 += num_list[i];
            nuMulti *= num_list[i];
        }
        
        if( (numSum2*numSum2) < nuMulti ) answer = 0;
        else answer = 1;
        
        return answer;
    }
}


//이어 붙인 수
//제출 내역
//문제 설명
//정수가 담긴 리스트 num_list가 주어집니다. num_list의 홀수만 순서대로 이어 붙인 수와 짝수만 순서대로 이어 붙인 수의 합을 return하도록 solution 함수를 완성해주세요.
//
//제한사항
//2 ≤ num_list의 길이 ≤ 10
//1 ≤ num_list의 원소 ≤ 9
//num_list에는 적어도 한 개씩의 짝수와 홀수가 있습니다.

class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int listLen = num_list.length;
        String odd = "";
        String even = "";
        
        
        for(int i = 0; i < listLen; i++){
            if(num_list[i] % 2 == 0) // 짝수
                even += num_list[i];
            else //홀수
                odd += num_list[i];
        }
        
        
        return Integer.valueOf(odd) + Integer.valueOf(even);
    }
}