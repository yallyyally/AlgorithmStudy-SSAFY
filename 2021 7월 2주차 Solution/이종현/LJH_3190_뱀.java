import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.*;

public class boj_3190_뱀 {

    static int N;
    static int[][] map;
    static HashMap<Integer, String> dirMap;
    static int[] dx = { 0, 1, 0, -1 }; // 우하좌상
    static int[] dy = { 1, 0, -1, 0 };
    static int result;

    public static void main(String args[]) throws IOException, NumberFormatException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            map[row][col] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        dirMap = new HashMap<>();

        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            dirMap.put(time, dir);
        }

        Iterator<Integer> iterator = dirMap.keySet().iterator();
        while (iterator.hasNext()) {
            int key = iterator.next();
            String value = dirMap.get(key);
            // System.out.println(key + " " + value);
            // Boolean bl = dirMap.containsKey(3);
            // System.out.println(bl);
        }
        // for (int i = 0; i <= N; i++) {
        // for (int j = 0; j <= N; j++) {
        // System.out.printf("%3d", map[i][j]);
        // }
        // System.out.println();
        // }

        result = 0;
        bfs();
        System.out.println(result);

    }

    static void bfs() {

        int nowX = 1;
        int nowY = 1;
        int nowDir = 0;
        int nowTime = 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 1));

        while (true) {

            nowTime++;
            nowX += dx[nowDir];
            nowY += dy[nowDir];

            if (nowX <= 0 || nowX > N || nowY <= 0 || nowY > N || map[nowX][nowY] == 2) {
                result = nowTime;
                break;
            }

            if (map[nowX][nowY] == 0) {
                Node node = queue.poll();
                map[node.x][node.y] = 0;
            }
            queue.add(new Node(nowX, nowY));
            map[nowX][nowY] = 2;

            if (dirMap.containsKey(nowTime)) {
                String dir = dirMap.remove(nowTime);
                // System.out.println(dir);
                if (dir.equals("L")) {
                    nowDir = nowDir == 0 ? 3 : nowDir - 1;
                } else if (dir.equals("D")) {
                    nowDir = (nowDir + 1) % 4;
                }
            }

            // for (int i = 0; i <= N; i++) {
            // for (int j = 0; j <= N; j++) {
            // System.out.printf("%3d", map[i][j]);
            // }
            // System.out.println();
            // }
            // System.out.println("--------");

        }

    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
