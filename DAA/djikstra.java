import java.util.*;
public class djikstra {
    public static int min(int d[], int visited[])
    {
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for(int i = 0 ; i < 9 ; i++)
        {
            if(visited[i] == 0 && d[i] < min)
            {
                min = d[i];
                min_index = i;
            }
        }
        return min_index;
    }
    public static void Djikstra(int graph[][])
    {
        int visited[] = new int[9];
        int dist[] = new int[9];
        int parent[] = new int[9];
        Arrays.fill(visited, 0);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        parent[0] = -1;

        for(int i = 0; i < 9 ; i++)
        {
            int min_index = min(dist, visited);
            visited[min_index] = 1;
            for(int j = 0; j < 9 ; j++)
            {
                if(graph[min_index][j] != 0 && visited[j] == 0  &&  dist[j] > dist[min_index] + graph[min_index][j])
                {
                    dist[j] = dist[min_index] + graph[min_index][j];
                    parent[j] = min_index;
                }
            }    
        }
        System.out.println("Edge \tWeight");
        for (int i = 1; i < 9; i++) 
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
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
        Djikstra(graph);
    }
}
