//콜라츠 수열 만들기
//모든 자연수 x에 대해서 현재 값이 x이면 x가 짝수일 때는 2로 나누고, x가 홀수일 때는 3 * x + 1로 바꾸는 계산을 계속해서 반복하면 언젠가는 반드시 x가 1이 되는지 묻는 문제를 콜라츠 문제라고 부릅니다.
//그리고 위 과정에서 거쳐간 모든 수를 기록한 수열을 콜라츠 수열이라고 부릅니다.
//계산 결과 1,000 보다 작거나 같은 수에 대해서는 전부 언젠가 1에 도달한다는 것이 알려져 있습니다.
//임의의 1,000 보다 작거나 같은 양의 정수 n이 주어질 때 초기값이 n인 콜라츠 수열을 return 하는 solution 함수를 완성해 주세요.
//제약조건 1 ≤ n ≤ 1,000

import java.util.*;

class Solution {
    
    private List<Integer> sol = new ArrayList<Integer>();
    public int[] solution(int n) {
        int[] answer;
        
        solu(n);
        
        answer = new int[sol.size()];
        
        for(int i = 0; i < sol.size(); i++){
            answer[i] = sol.get(i);
        }
        
        return answer;
    }
    
    public int solu(int num){
        sol.add(num);
        if(num == 1) return 1;
        else {
            if(num % 2 == 0) return solu(num / 2);
            else return solu(3 * num + 1);
        }
    }


// 배열 만들기 4
// 정수 배열 arr가 주어집니다. arr를 이용해 새로운 배열 stk를 만드려고 합니다.
// 변수 i를 만들어 초기값을 0으로 설정한 후 i가 arr의 길이보다 작으면 다음 작업을 반복합니다.
// 만약 stk가 빈 배열이라면 arr[i]를 stk에 추가하고 i에 1을 더합니다.
// stk에 원소가 있고, stk의 마지막 원소가 arr[i]보다 작으면 arr[i]를 stk의 뒤에 추가하고 i에 1을 더합니다.
// stk에 원소가 있는데 stk의 마지막 원소가 arr[i]보다 크거나 같으면 stk의 마지막 원소를 stk에서 제거합니다.
// 위 작업을 마친 후 만들어진 stk를 return 하는 solution 함수를 완성해 주세요.
// 제한조건: 
//   1 ≤ arr의 길이 ≤ 100,000
//   1 ≤ arr의 원소 ≤ 100,000

import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        
        int[] result;
        
        for(int i = 0; i < arr.length; i++){
            while(true){
                if(stk.size() == 0) {
                    stk.push(arr[i]);
                    break;
                }
                else{
                    int now = stk.peek();
                    if(now < arr[i]) {
                        stk.push(arr[i]);
                        break;
                    }else {
                        stk.pop();
                    }
                }

            }
        }
        
        result = new int[stk.size()];
        
        for(int i = stk.size()-1; i > -1; i--){
            
            result[i] = stk.pop();
        }
        
        return result;
    }
}

// import java.util.*;

// class Solution {
//     public Stack<Integer> solution(int[] arr) {
//         Stack<Integer> stack = new Stack<>();
//         int i = 0;

//         while (i < arr.length) {
//             if (stack.empty() || stack.peek() < arr[i]) {
//                 stack.push(arr[i]);
//                 i++;
//             } else if (stack.peek() >= arr[i]) {
//                 stack.pop();
//             }
//         }
//         return stack;
//     }
// }
