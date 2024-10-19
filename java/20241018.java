import java.io.*;
import java.util.*;

class Point{
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}


public class Main {
    private static int[] mx = {2, 1, -2, -1, 2, 1, -2, -1};
    private static int[] my = {-1, -2, -1, -2, 1, 2, 1, 2};



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();

        int solNum = Integer.parseInt(br.readLine());

        for(int i = 0; i < solNum; i++){
            int l = Integer.parseInt(br.readLine());

            boolean[][] visited = new boolean[l][l];
            int[][] map = new int[l][l];

            String[] startStr = br.readLine().split(" ");
            String[] endStr = br.readLine().split(" ");

            int startX = Integer.parseInt(startStr[0]);
            int startY = Integer.parseInt(startStr[1]);

            int endX = Integer.parseInt(endStr[0]);
            int endY = Integer.parseInt(endStr[1]);


            Queue<Point> q = new LinkedList<>();

            q.add(new Point(startX, startY));
            visited[startX][startY] = true;

            while(!q.isEmpty()){
                Point nowXY = q.poll();

                int x = nowXY.x;
                int y = nowXY.y;

                if(x == endX && y == endY) {
                    break;
                }

                for(int j = 0; j < 8; j++){
                    int nx = x + mx[j];
                    int ny = y + my[j];

                    if(nx < 0 || nx > l - 1 || ny < 0 || ny > l - 1) continue;

                    if(visited[nx][ny]) continue;

                    visited[nx][ny] = true;

                    map[nx][ny] = map[x][y] + 1;
                    q.add(new Point(nx, ny));
                }
            }

            sb.append(map[endX][endY]).append("\n");
        }
        System.out.println(sb);
    }
}