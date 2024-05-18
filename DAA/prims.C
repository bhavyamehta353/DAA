#include <stdio.h>
#include <limits.h>
#include <climits>
#define size 9

int graph[size][size] = {
    {0, 4, 0, 0, 0, 0, 0, 8, 0},
    {4, 0, 8, 0, 0, 0, 0, 11, 0},
    {0, 8, 0, 7, 0, 4, 0, 0, 2},
    {0, 0, 7, 0, 9, 14, 0, 0, 0},
    {0, 0, 0, 9, 0, 10, 0, 0, 0},
    {0, 0, 4, 14, 10, 0, 2, 0, 0},
    {0, 0, 0, 0, 0, 2, 0, 1, 6},
    {8, 11, 0, 0, 0, 0, 1, 0, 7},
    {0, 0, 2, 0, 0, 0, 6, 7, 0}
};

int findmin(int visited[] , int d[])
{
    int min_idx;
    int min = INT_MAX;
    for(int i =0 ;i < size ; i++)
    {
        if(!visited[i] && d[i] < min)
        {
            min = d[i];
            min_idx = i;
        }
    }
    return min_idx;
}


void prims()
{
    int visited[size];
    int d[size];
    int parent[size];
    for (int i = 0; i < size; i++)
    {
        visited[i] = 0;
        d[i] = INT_MAX;
    }
    d[0] = 0;
    parent[0] = -1;
    
    for(int i = 0; i < size; i++)
    {
        int min_index = findmin(visited, d);
        visited[min_index] = 1;
        for(int j =  0; j < size; j++)
        {
            if(graph[min_index][j] != 0 && !visited[j] && graph[min_index][j] < d[j])
            {
                d[j] = graph[min_index][j];
                parent[j] = min_index;
            }
        }
    }
    for(int i = 1; i < size; i++)
    {
        printf("\n%d - %d -> %d", parent[i] , i , d[i]);
    }
}

int main()
{
    prims();
    return 0;
}