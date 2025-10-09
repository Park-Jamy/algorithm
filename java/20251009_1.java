import java.util.*;

class Solution {

    static int min = Integer.MAX_VALUE;

    static final int maps_size = 5;

    static int[] xx = {-1, 1, 0, 0};
    static int[] yy = {0, 0, -1, 1};

    // 실제 뚫려 있는 길
    static int[][] main_maps = new int[maps_size][maps_size];

    public int solution(int[][] main_maps) {

        int[][] walk_maps = new int[maps_size][maps_size];

        calc(main_maps, walk_maps);

        min = walk_maps[maps_size-1][maps_size-1];

        if(min == 0) return -1;

        return min;
    }

    private void calc(int[][] main_maps, int[][] walk_maps){

        Queue<int[]> q = new LinkedList<>();

        // 시작
        walk_maps[0][0] = 1;

        q.add(new int[]{0,0});

        while(!q.isEmpty()){

            int[] now = q.pop();
            int nx = now[0];
            int ny = now[1];

            for(int i = 0; i < 4; i++){
                int mx = nx + xx[i];
                int my = ny + yy[i];

                if(mx > maps_size-1 || mx < 0 ||
                        my > maps_size-1 || my < 0){
                    continue;
                }

                if(main_maps[mx][my] == 0){
                    continue;
                }

                if(walk_maps[mx][my] != 0){
                    continue;
                }

                walk_maps[mx][my] = walk_maps[nx][ny] + 1;

                q.add(new int[]{mx, my});
            }
        }
    }
