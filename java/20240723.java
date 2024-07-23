package org.Y2024.M06.D26;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

class StartEnd{
    Date start;
    Date end;

    public StartEnd(Date start, Date end){
        this.start = start;
        this.end = end;
    }
}
public class q2024072401 {
    public static int solution(String[][] book_time) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("HH:DD");
        int answer = 0;

        // book_time[0]이 작은 순으로 정렬
        Map<String, String> timeMap2 = new TreeMap<>();

        Queue<StartEnd> st = new LinkedList<>();

        for(String[] book : book_time){
            timeMap2.put(book[0],book[1]);
        }

        int max = 0;
        for(Map.Entry<String, String> e : timeMap2.entrySet()){

            Date now_start_time = format.parse(e.getKey());
            Date now_end_time = format.parse(e.getValue());

            if(st.isEmpty()) {st.add(new StartEnd(now_start_time, now_end_time));} // 스택 안에가 비어 있다면 시작
            else {
                for(int i = 0; i < st.size(); i++){
                    StartEnd se = st.poll(); // 이전 예약 시간 가지고 옴

                    Date last_end_time = se.end; // 이전 예약 시간에서 끝나는 시간 가지고 옴

                    int diff = (int)(now_start_time.getTime() - last_end_time.getTime()) / ( 1000 * 60 ); // 현재 시작 시간과 이전 종료 시간과의 차이 확인

                    if(diff < 10) { // 현재 시작시간과 이전 종료시간의 차이가 10분 이하라면 방 추가
                        st.add(new StartEnd(se.start, se.end));
                    }else{ // 이전 종료시간이 끝나고 청소시간(10분) 도 지난 상태라면

                    }
                }
                st.add(new StartEnd(now_start_time, now_end_time));

                if(st.size() > max) max = st.size();
            }
        }



        return max;
    }
}

package org.Y2024.M06.D26;

        import java.util.*;


public class q2024072302 {
    public static String solution(String X, String Y) {
        Map<String, Integer> xMap = new HashMap<>();
        Map<String, Integer> yMap = new HashMap<>();

        List<String> list = new ArrayList<>();

        for(String key: X.split("")) {
            xMap.put(key, xMap.getOrDefault(key, 0)+1);
        }

        for(String key: Y.split("")) {
            yMap.put(key, yMap.getOrDefault(key, 0)+1);
        }

        for(String key: xMap.keySet()) {
            if(!yMap.containsKey(key)) continue;

            int length = Math.min(xMap.get(key), yMap.get(key));
            for(int i = 0; i < length; i++) {
                list.add(key);
            }
        }

        Collections.sort(list, Collections.reverseOrder());

        String answer = "";

        for(int i = 0; i < list.size(); i++){
            answer += list.get(i);
        }

        if(answer.isEmpty()) return "-1";
        if(answer.replaceAll("0", "").isEmpty()) return "0";
        return answer;
    }
}

package org.Y2024.M06.D26;

        import java.util.*;

public class q2024072303 {
    public static int solution(int[] ingredient) {
        int answer = 0;

        int len = ingredient.length;
        List<Integer> li = new ArrayList<>();

        for(int i = 0; i < len; i++){
            li.add(ingredient[i]);
        }


        int i = 0;
        while(true){
            if( i >= len - 3 ){
                break;
            }
            if(li.get(i) == 1 && li.get(i+1) == 2
                    && li.get(i+2) == 3 && li.get(i+3) == 1){
                answer++;
                li.remove(i);
                li.remove(i);
                li.remove(i);
                li.remove(i);

                len -= 4;

                i = 0;

                continue;
            }
            i++;
        }

        return answer;
    }
}

package org.Y2024.M06.D26;

        import java.util.*;

class Node{
    int x, y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class q2024072304 {
    static String[][] maps_2nd;
    static int result = 99999;

    static int[] xx = {-1, 1, 0, 0};
    static int[] yy = {0, 0, -1, 1};



    public static int solution(String[] maps) {
        int answer = 0;

        int h = maps.length;
        int r = maps[0].length();

        maps_2nd = new String[h][r];
        Node startMap = null, endMap = null, leverMap = null;

        for(int i = 0; i < h; i++){
            String[] mapStr = maps[i].split("");

            for(int j = 0; j < r; j++){
                maps_2nd[i][j] = mapStr[j];

                if(mapStr[j].equals("S")) startMap = new Node(i,j);
                else if(mapStr[j].equals("L")) leverMap = new Node(i,j);
                else if(mapStr[j].equals("E")) endMap = new Node(i,j);
            }
        }

        int startToLever = bfs(startMap, leverMap, h, r);
        int leverToEnd = bfs(leverMap, endMap, h, r);

        if(startToLever == -1 || leverToEnd == -1){
            answer = -1;
        }else{
            answer = startToLever + leverToEnd;
        }

        return answer;
    }

    public static int bfs(Node start, Node end, int h, int r){
        ArrayDeque<Node> dlist = new ArrayDeque<>();

        dlist.add(start);

        int[][] d = new int[h][r];
        d[start.y][start.x] = 1;


        while(!dlist.isEmpty()){
            Node nowNode = dlist.poll();

            for(int i = 0; i < 4; i++){
                int nextX = nowNode.x + xx[i];
                int nextY = nowNode.y + yy[i];


                if( nextX < 0 || nextX >= r || nextY < 0 || nextY >= h)
                    continue;

                if(d[nextY][nextX] > 0)
                    continue;

                if(maps_2nd[nextY][nextX].equals("X"))
                    continue;

                d[nextY][nextX] = d[nowNode.y][nowNode.x] + 1;

                dlist.add(new Node(nextX, nextY));

                if(nextX == end.x && nextY == end.y){
                    return d[nextY][nextX] - 1;
                }
            }
        }

        return -1;
    }
}
