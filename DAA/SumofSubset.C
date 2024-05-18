#include <stdio.h>
int items = 6;
int w[6] = {5,10,12,13,15,18};
int m = 30;
int x[6] = {0};

void SumofSubset(int s, int k, int r)
{
    x[k] = 1;
    if(s + w[k] == m)
    {
        for(int i = 0; i < items; i++)
            printf("%d ",x[i]);
        printf("\n");
    }
    else if(s + w[k] + w[k+1] <=m && k + 1 < items)
        SumofSubset(s + w[k], k + 1 , r - w[k]);
    x[k] = 0;
    if(s + r - w[k] >=m && s + w[k] <= m && k+1 < items)
        SumofSubset(s, k + 1, r - w[k]);
}

int main()
{
    SumofSubset(0,0,73);
    return 0;
}