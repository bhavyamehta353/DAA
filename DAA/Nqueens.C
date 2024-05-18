#include <stdio.h>
#include <stdlib.h>
int x[4];
int place(int k, int i)
 {
     for(int j = 0 ; j < k; j++) // Iterate over previously placed queens in k-1 rows
     {
        if(x[j] == i || abs(x[j] - i) == abs(j-k)) // check for diagonal and queen already placed
            return 0;
     }
     return 1;
 }
void nQueens(int k, int n)
 {
     for(int i = 0; i < n ; i++)
     {
         if(place(k,i))
         {
            x[k] = i; // place queen in the kth row in ith column
            if(k == n - 1)
            {
                for(int v = 0; v < n; v++)
                    printf("%d ", x[v]);
                printf("\n");
            }
            else
                nQueens(k+1, n);
        }
     }
 }
int main()
{
    nQueens(0,4);
    return 0;
}