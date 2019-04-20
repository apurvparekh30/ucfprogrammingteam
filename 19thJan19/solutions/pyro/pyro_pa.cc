// MCPC'15: Pyro Tubes
// Author: Per Austrin
#include <cstdio>
#include <cstring>

#define NUMT 18
#define MAX_N 250000

int has[1+MAX_N], L;
int Has(int L) { return L <= MAX_N && has[L]; }

int main(void) {
    memset(has, 0, sizeof(has));
    while (scanf("%d", &L) == 1 && L != -1) has[L] = true;
    for (int L = 1; L <= MAX_N; ++L) {
        if (!Has(L)) continue;
        int C = 0;
        for (int b = 0; b < NUMT; ++b)
            if (!(L & (1<<b))) {
                if (Has(L ^ (1<<b))) ++C;
                for (int c = 0; c < b; ++c)
                    if (Has(L ^ (1<<b) ^ (1<<c))) ++C;
            }
        printf("%d:%d\n", L, C);
    }
    return 0;
}
