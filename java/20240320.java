//피로도
//        제출 내역
//        문제 설명
//        XX게임에는 피로도 시스템(0 이상의 정수로 표현합니다)이 있으며, 일정 피로도를 사용해서 던전을 탐험할 수 있습니다.
//        이때, 각 던전마다 탐험을 시작하기 위해 필요한 "최소 필요 피로도"와 던전 탐험을 마쳤을 때 소모되는 "소모 피로도"가 있습니다.
//        "최소 필요 피로도"는 해당 던전을 탐험하기 위해 가지고 있어야 하는 최소한의 피로도를 나타내며, "소모 피로도"는 던전을 탐험한 후
//        소모되는 피로도를 나타냅니다. 예를 들어 "최소 필요 피로도"가 80, "소모 피로도"가 20인 던전을 탐험하기 위해서는 유저의
//        현재 남은 피로도는 80 이상 이어야 하며, 던전을 탐험한 후에는 피로도 20이 소모됩니다.
//
//        이 게임에는 하루에 한 번씩 탐험할 수 있는 던전이 여러개 있는데, 한 유저가 오늘 이 던전들을 최대한 많이 탐험하려 합니다.
//        유저의 현재 피로도 k와 각 던전별 "최소 필요 피로도", "소모 피로도"가 담긴 2차원 배열 dungeons 가 매개변수로 주어질 때,
//        유저가 탐험할수 있는 최대 던전 수를 return 하도록 solution 함수를 완성해주세요.
//
//        제한사항
//        k는 1 이상 5,000 이하인 자연수입니다.
//        dungeons의 세로(행) 길이(즉, 던전의 개수)는 1 이상 8 이하입니다.
//        dungeons의 가로(열) 길이는 2 입니다.
//        dungeons의 각 행은 각 던전의 ["최소 필요 피로도", "소모 피로도"] 입니다.
//        "최소 필요 피로도"는 항상 "소모 피로도"보다 크거나 같습니다.
//        "최소 필요 피로도"와 "소모 피로도"는 1 이상 1,000 이하인 자연수입니다.
//        서로 다른 던전의 ["최소 필요 피로도", "소모 피로도"]가 서로 같을 수 있습니다.
//        입출력 예
//        k	dungeons	result
//        80	[[80,20],[50,40],[30,10]]	3

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    static int Gcount = -1; // 최솟값
    static int[] chks;

    public int solution(int k, int[][] dungeons) {
        int dungeonsLen = dungeons.length;

        chks = new int[dungeonsLen];
        for(int chk : chks) chk = 0; // 던전 탐색 여부 탐색 X : 0 , 탐색 O : 1

        int count = 0;

        calc(dungeons, dungeonsLen, k, count);

        return Gcount;
    }

    public static void calc(int[][] dungeons, int dungeonsLen, int k, int count){
        for(int i = 0; i < dungeonsLen; i++){
            System.out.println(i + " chks[i] " + chks[i]);
            if(chks[i] == 0) { // 해당 던전을 탐색했는지 안했는지 확인
                if (k >= dungeons[i][0]) { // 던전의 최소 필요 피로도 보다 현재 피로도가 같거나 높으면
                    // 던전 탐색한 것으로 변경
                    chks[i] = 1;
                    calc(dungeons, dungeonsLen, k - dungeons[i][1], count+1);
                    chks[i] = 0;
                }
            }
            if( Gcount < count ) Gcount = count;
        }
    }
}


//의상
//        제출 내역
//        문제 설명
//        코니는 매일 다른 옷을 조합하여 입는것을 좋아합니다.
//
//        예를 들어 코니가 가진 옷이 아래와 같고, 오늘 코니가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나
//        동그란 안경 대신 검정 선글라스를 착용하거나 해야합니다.
//
//        종류	이름
//        얼굴	동그란 안경, 검정 선글라스
//        상의	파란색 티셔츠
//        하의	청바지
//        겉옷	긴 코트
//        코니는 각 종류별로 최대 1가지 의상만 착용할 수 있습니다. 예를 들어 위 예시의 경우 동그란 안경과 검정 선글라스를 동시에 착용할 수는 없습니다.
//        착용한 의상의 일부가 겹치더라도, 다른 의상이 겹치지 않거나, 혹은 의상을 추가로 더 착용한 경우에는 서로 다른 방법으로 옷을 착용한 것으로 계산합니다.
//        코니는 하루에 최소 한 개의 의상은 입습니다.
//        코니가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
//
//        제한사항
//        clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
//        코니가 가진 의상의 수는 1개 이상 30개 이하입니다.
//        같은 이름을 가진 의상은 존재하지 않습니다.
//        clothes의 모든 원소는 문자열로 이루어져 있습니다.
//        모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
//        입출력 예
//        clothes	return
//        [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]	5
//        [["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]	3

class Solution {

    public int solution(String[][] clothes) {
        int answer = 1;
        int clothesLen = clothes.length;
        Map<String, Integer> typeCount = new HashMap<String, Integer>();

        for(int i = 0; i < clothesLen; i++){
            typeCount.put(clothes[i][1], typeCount.getOrDefault(clothes[i][1], 0) + 1);
        }

        for(String key : typeCount.keySet()){
            answer *= (typeCount.get(key)+1);
        }

        return answer - 1;
    }
}