#include <stdio.h>
#include <string.h>
#include <math.h>
# define d 10
int val(char x)
{
    return (int)(x) - 96;
}
void RabinKarp(char *T, char *P)
{
    int m = strlen(T);
    int n = strlen(P);
    int q = 10;
    int h = ((int)pow(d,n-1))%q;
    int p = 0; 
    int t = 0;
    for(int i = 0 ; i < n ; i++) // hash value of the current window and pattern
    {
        p = (d*p + val(P[i])) % q;
        t = (d*t + val(T[i])) % q;
    }
    for(int i = 0; i <=m-n+1; i++)
    {
        if(p == t)
        {
            int count = 0; 
            for(int j = 0; j < n; j++)
            {
                if(P[j] == T[j+i])
                    count++;
            }
            if(count == n)
                printf("Pattern found at index %d", i);
        }
        if (i < m - n) //if we still havent reached the end of the text then you slide the window
        {
            t = (d*(t - val(T[i]*h)) + val(T[i+n]))%q;
        }
    }
}
int main()
{
    char T[] = "abacbabdcabd";
    char P[] = "bdc";
    RabinKarp(T,P);
}