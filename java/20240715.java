import java.util.*;

public class Q2024071501 {
    public static int solution(int[] d, int budget){
        Arrays.sort(d);
        int result = 0;

        for(int m : d){

            if(result + m > budget){
                break;
            }else if(result + m == budget){
                result += m;
                break;
            }else{
                result += m;
            }
        }

        return result;
    }
}

//---

import java.util.*;

public class Q2024071502 {
    public static int[] solution(int[] progresses, int[] speeds){
        // progresses 프로그램 작업 진도
        // speeds 프로그램 작업 속도

        int[] result;

        // 프로그램 갯수
        int pro_len = progresses.length;

        // 결과값 저장
        List<Integer> li = new ArrayList<>();

        // 프로그램 종료까지 남은 일정 확인
        Queue<Integer> q = new LinkedList<>();

        int last_work_date = 0;
//        int ci = 0;
        for(int i = 0; i < pro_len; i++){
            // 남은 프로그램 mm
            int work = 100 - progresses[i];

            // 남은 일정 = 남은 프로그램 / 작업 속도
            // 올림 처리
            int work_date = (int)Math.ceil(work / speeds[i]);

            q.add(work_date);

//            // 이전 업무가 큐에 없을 때
//            if(q.isEmpty()){
//                // 만약 가장 최근 배포가 현재 배포해야 하는 일정보다 길거나 같으면 같이 배포 진행
//                if( last_work_date >= work_date ){
//                    ci++;
//                }else{ // 일정이 더 길다면 큐에 저장 후 나중에 배포
//                    ci++;
//                    li.add(ci);
//                    ci = 1;
//                    q.add(work_date);
//                }
//            }else{ // 배포가 마무리 됐는데 앞서 작업이 마무리가 되지 않았다면
//                last_work_date = q.poll();
//
//                if( last_work_date >= work_date ){
//                    ci++;
//                }else{ // 일정이 더 길다면 큐에 저장 후 나중에 배포
//                    li.add(ci);
//                    ci = 1;
//                    q.add(work_date);
//                }
//            }
        }

        // 먼저 시작한 업무 시간 별로 배포 진행
        // 뒤에 시작한 업무여도 앞에 업무가 남아 있으면 대기 후 앞 업무가 배포 할 때 함께 배포
        int ci = 0;
        while(!q.isEmpty()){
            // 현재 업무 배포 진행
            int now_work_date = q.poll();
            ci = 1;

            // 다음 업무가 마무리 되었다면 함께 배포
            while(!q.isEmpty()){
                int next_work_date = q.peek();

                if(now_work_date >= next_work_date){
                    q.poll();
                    ci++;
                }else{
                    break;
                }
            }

            li.add(ci);
        }

        result = li.stream()
                .mapToInt(i -> i)
                .toArray();

        return result;
    }
}
