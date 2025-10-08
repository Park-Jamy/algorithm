import java.util.*;

class Solution {

    static List<String> list = new ArrayList<String>();
    static List<String> wordList = List.of("A", "E", "I", "O", "U");

    int finalLen = 0;
    int wordLen = 0;

    public int solution(String word) {
        int answer = 0;

        finalLen = word.length();

        wordLen = wordList.size();

        calc(0, "");

        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(word)){
                answer = i;
                break;
            }
        }

        return answer;
    }

    private void calc(int len, String w){
        list.add(w);

        if(wordLen == len){
            return;
        }

        for(int i = 0; i < wordLen; i++){
            calc(len + 1, w + wordList.get(i));
        }
    }
}

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<String, Integer> fuInt = new HashMap<String, Integer>();

        int len = tangerine.length;

        for(int i = 0; i < len; i++){
            fuInt.put(String.valueOf(tangerine[i]), fuInt.getOrDefault(String.valueOf(tangerine[i]), 0) + 1);
        }

        List<String> listKeySet = new ArrayList<>(fuInt.keySet());

        Collections.sort(listKeySet, (value1, value2) -> (fuInt.get(value2).compareTo(fuInt.get(value1))));

        for(String str : listKeySet){
            k -= fuInt.get(str);

            answer += 1;

            if(k <= 0)
                break;
        }

        return answer;
    }
}


