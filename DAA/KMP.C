#include <stdio.h>
#include <string.h>
void ComputePrefix(int pi[], int m, char *P)
{
    pi[0] = 0;
    int k = 0;
    for(int i = 1; i < m; i++)
    {
        while(k > 0 && P[k] != P[i])
            k = pi[k - 1];
        if(P[k] == P[i])
            k++;
        pi[i] =k;
    }
}
void KMP(char *P, char *T)
{
    int m = strlen(P);
    int n = strlen(T);
    int pi[m];
    ComputePrefix(pi,m,P);
    int k = 0;
    for(int i = 0; i < n; i++)
    {
        while(k > 0 && P[k] != T[i])
            k = pi[k-1];
        if(P[k] == T[i])
            k++;
        if(k == m)
        {
            printf("Pattern found after %d shifts\n", i - m + 1);
            k = pi[k-1];
        }
    }
}
int main()
{
    char T[] = "abcabacabd";
    char P[] = "cab";
    KMP(P,T);
    return 0;
}