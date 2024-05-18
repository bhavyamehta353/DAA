public class kruskals {
    static int[] parent;

    public static int find(int u) {
        while (parent[u] != -1) {
            u = parent[u];
        }
        return u;
    }

    public static boolean uni(int i, int j) {
        int u = find(i);
        int v = find(j);
        if (u != v) {
            parent[v] = u;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        int graph[][] = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                        {4, 0, 8, 0, 0, 0, 0, 11, 0},
                        {0, 8, 0, 7, 0, 4, 0, 0, 2},
                        {0, 0, 7, 0, 9, 14, 0, 0, 0},
                        {0, 0, 0, 9, 0, 10, 0, 0, 0},
                        {0, 0, 4, 14, 10, 0, 2, 0, 0},
                        {0, 0, 0, 0, 0, 2, 0, 1, 6},
                        {8, 11, 0, 0, 0, 0, 1, 0, 7},
                        {0, 0, 2, 0, 0, 0, 6, 7, 0}};
        int n = 9, ne = 0, mincost = 0;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }

        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = graph[i][j];
                if (cost[i][j] == 0)
                    cost[i][j] = Integer.MAX_VALUE;
            }
        }

        while (ne < n - 1) {
            int min = Integer.MAX_VALUE;
            int a = -1, b = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (cost[i][j] < min) {
                        min = cost[i][j];
                        a = i;
                        b = j;
                    }
                }
            }
            if (uni(a, b)) {
                System.out.println(a + " - " + b);
                mincost += min;
                ne++;
            }
            cost[a][b] = cost[b][a] = Integer.MAX_VALUE;
        }
        System.out.println("Min Cost: " + mincost);
    }
}
