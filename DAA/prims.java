import java.util.*;
public class prims
{
    public static int findmin(int d[], int visited[], int size)
    {
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for(int i = 0 ; i < size ; i++)
        {
            if(visited[i] == 0 && d[i] < min)
            {
                min = d[i];
                min_index = i;
            }
        }
        return min_index;
    }
    public static void primsMST(int graph[][])
    {
        int vertex = graph.length;
        int visited[] = new int[vertex];
        int dist[] = new int[vertex];
        int parent[] = new int[vertex];
        Arrays.fill(visited, 0);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        parent[0] = -1;
        int totalcost = 0;
        for(int i = 0 ; i < vertex ; i++)
        {
            int min_index = findmin(dist,visited, vertex);
            visited[min_index] = 1;
            totalcost += dist[min_index];
            for(int j = 0 ; j < vertex ; j++)
            {
                if(graph[min_index][j]!=0 && visited[j]==0 && dist[j] > graph[min_index][j])
                {
                    dist[j] = graph[min_index][j];
                    parent[j] = min_index;
                }
            }
        }
        System.out.println("Edge \tWeight");
        for (int i = 1; i < vertex; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
        System.out.println("Total cost of MST: " + totalcost);
    }
    public static void main(String[] args)
    {
        int graph[][] =     {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                            {4, 0, 8, 0, 0, 0, 0, 11, 0},
                            {0, 8, 0, 7, 0, 4, 0, 0, 2},
                            {0, 0, 7, 0, 9, 14, 0, 0, 0},
                            {0, 0, 0, 9, 0, 10, 0, 0, 0},
                            {0, 0, 4, 14, 10, 0, 2, 0, 0},
                            {0, 0, 0, 0, 0, 2, 0, 1, 6},
                            {8, 11, 0, 0, 0, 0, 1, 0, 7},
                            {0, 0, 2, 0, 0, 0, 6, 7, 0}};
        primsMST(graph);
    }
}