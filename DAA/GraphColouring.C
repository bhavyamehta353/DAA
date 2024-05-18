#include <stdio.h>
#define n 5
#define m 3
int graph[n][n]={{0,1,1,0,1},
                {1,0,1,0,1},
                {1,1,0,1,0},
                {0,0,1,0,1},
                {0,1,0,1,0}};
int x[n] = {0};
void NextValue(int k)
{
    while(1)
    {
        x[k] = (x[k]+1) % (m+1);
        if(x[k] == 0)
            return;
        int count = 0;
        for(int j = 0; j < n ; j++)
        {
            if(graph[k][j]!=0 && x[k] == x[j])
                break;
            count++;
        }
        if(count == n)
            return;
    }
}

void GraphColouring(int k)
{
    while(1)
    {
        NextValue(k);
        if(x[k] == 0)
            return;
        if(k == n - 1)
        {
            for(int i = 0; i < n; i++)
            {
                printf("%c:%d ",65+i, x[i] );
            }
            printf("\n");
        }
        else
            GraphColouring(k+1);
    }
}
int main()
{
    GraphColouring(0);
}