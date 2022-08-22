package algorithm.bfs;


import java.util.Scanner;

class Node {
    public int row;
    public int col;

    public Node(int row, int col){
        this.row = row;
        this.col = col;
    }

    public static Node of(int row, int col){
        return new Node(row, col);
    }

    public boolean equal(Node other){
        return this.row == other.row && this.col == other.col;
    }
}

class Queue {
    final static int MAX = 1000;

    private Node values[] = new Node[MAX];
    private int front = 0;
    private int rear = -1;

    public boolean isEmpty() {
        return rear < front;
    }

    public void push(Node val) {
        values[++rear] = val;
    }

    public Node pop() {
        return values[front++];
    }

    public Node peek() {
        return values[front];
    }

    public void reset() {
        front = 0;
        rear = -1;
    }
}

public class Problem1 {
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};
    static int visited[][];
    static int map[][];
    static int n;

    final static int LAND = 1;
    final static int WALL = 0;
    final static int PRINCESS = 2;
    final static int MAX = 1000000;


    public static void reset(int arr[][], int length) {
        for (int r = 0; r < length; r++) {
            for (int c = 0; c < length; c++) {
                arr[r][c] = MAX;
            }
        }
    }

    public static int bfs(Node start, Node finish) {
        Queue queue = new Queue();
        visited[start.row][start.col] = 0;
        queue.push(start);

        while (!queue.isEmpty()) {
            Node cur = queue.pop();

            for (int i = 0; i < 4; i++) {
                Node nextNode = Node.of(cur.row + dr[i], cur.col + dc[i]);
                if (nextNode.row < 0 || nextNode.col >= n || nextNode.row < 0 || nextNode.col >= n) {
                    continue;
                }

                if (visited[nextNode.row][nextNode.col] > visited[cur.row][cur.col] + 1) {
                    visited[nextNode.row][nextNode.col] = visited[cur.row][cur.col] + 1;

                    if (nextNode.equal(finish)) {
                        return visited[nextNode.row][nextNode.col];
                    }
                    if(map[nextNode.row][nextNode.col] == LAND){
                        queue.push(nextNode);
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++) {
            n = sc.nextInt();
            map = new int[n][n];
            visited = new int[n][n];

            int princessRow = 0, princessCol = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                    if (map[i][j] == PRINCESS) {
                        princessRow = i;
                        princessCol = j;
                    }
                }
            }

            reset(visited, n);
            int gap1 = bfs(Node.of(0, 0), Node.of(princessRow, princessCol));
            int gap2 = 0;
            if (gap1 > 0) {
                reset(visited, n);
                gap2 = bfs(Node.of(princessRow, princessCol), Node.of(n -1, n-1));
            }

            // Print answer
            if (gap1 > 0 && gap2 > 0) {
                int res = gap1 + gap2;
                System.out.println("#" + t + " " + res);
            } else {
                System.out.println("#" + t + " " + "-1");
            }
        }
    }

}
