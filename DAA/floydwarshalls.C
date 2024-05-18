#include <stdio.h>
#define v 5
int parent[v][v];
int a[v][v] = {
        {0, 4, 7, 9, 8},
        {4, 0, 1, 1000, 1000},
        {7, 1, 0, 2, 1000},
        {9, 1000, 2, 0, 6},
        {8, 1000, 1000, 6, 0},
    };

void floyd_warshalls()
{
    for(int i = 0 ; i < 5; i++)
    {
        for(int j = 0; j <  5; j++)
        {
            if(a[i][j] != 1000 && a[i][j] !=0)
            {
                parent[i][j] = i;
            }
            else
                parent[i][j] = -1;
        }
    }

    for(int k = 0; k < 5 ; k++)
    {
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                if(a[i][j] > a[i][k] + a[k][j])
                {
                    a[i][j] = a[i][k] + a[k][j];
                    parent[i][j] = k;
                }
            }
        }
    }
    printf("All pairs shortest path\n");
    for(int i = 0 ; i < v ; i++)
    {
        for(int j = 0 ; j < v ; j++)
        {
            printf("%d ", a[i][j]);
        }
        printf("\n");
    }
     printf("Parents:\n");
     for(int i = 0 ; i < v ; i++)
    {
        for(int j = 0 ; j < v ; j++)
        {
            printf("%d ", parent[i][j]);
        }
        printf("\n");
    }
}

int main()
{
    floyd_warshalls();
    return 0;
}