import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {

        int number_len = numbers.length;

        int[] answer = new int[number_len];
        Arrays.fill(answer, -1);

        Stack<Integer> stack = new Stack<>();

        // 첫 번째 number 인덱스 stack에 push
        stack.push(0);

        // 두 번째 원소부터 numbers 탐색
        for (int i = 1; i < numbers.length; i++) {
            // 스택이 비어있지 않으면서 현재 스택이 바라보고 있는 값보다 number의 값이 크면 뒤에 있는 큰 수 해당
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                // 뒤에 있는 큰 수에 해당하는 모든 값 pop
                answer[stack.pop()] = numbers[i];
            }
            // 현재 인덱스 push
            stack.push(i);
        }
        return answer;
    }
}