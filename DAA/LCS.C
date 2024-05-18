#include <stdio.h>
#include <string.h>
char b[100][100];
int c[100][100];

void printlcs(char *X, int i , int j)
{
    if(i == 0 || j == 0)
        return;
    if(b[i][j] == 'd')
    {
        printlcs(X,i-1, j-1);
        printf("%c ", X[i-1]);
    }
    else if(b[i][j] == 'u')
        printlcs(X, i-1, j);
    else
        printlcs(X,i,j-1);
}

void LCS(char *X, char *Y)
{
    int m = strlen(X);
    int n = strlen(Y);
    for(int i = 0; i <=m; i++)
    {
        for(int j = 0; j <= n; j++)
        {
            if(i == 0 || j == 0)
                c[i][j] = 0;
        }
    }
    for(int i = 1; i <= m ; i++)
    {
        for(int j = 1; j<=n ; j++)
        {
            if(X[i-1] == Y[j-1])
            {
                c[i][j] = c[i-1][j-1] + 1;
                b[i][j] = 'd';
            }
            else if (c[i-1][j] > c[i][j-1])
            {
                c[i][j] = c[i-1][j];
                b[i][j] = 'u';
            }
            else
            {
                c[i][j] = c[i][j-1];
                b[i][j] = 'l';
            }
        }
    }
     printlcs(X,m,n);
}

int main()
{
    char X[]= "PROGRAMMING";
    char Y[] = "GAMING";
    LCS(X,Y);
}