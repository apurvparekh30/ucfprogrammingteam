// MCPC'15: Agglomerator
// Author: Per Austrin
#include <cassert>
#include <cstdio>
#include <cmath>

double sqr(double x) { return x*x; }

struct drop {
    double x, y, vx, vy, r;
    drop(double x=0, double y=0, double vx=0, double vy=0, double r=0): x(x), y(y), vx(vx), vy(vy), r(r) {}
    double hit_time(drop D) {
        double A = sqr(vx-D.vx) + sqr(vy-D.vy);
        double B = (vx-D.vx)*(x-D.x) + (vy-D.vy)*(y-D.y);
        double C = sqr(x-D.x) + sqr(y-D.y) - sqr(r+D.r);
        double disc = B*B-A*C;
        if (A < 1e-15) return 1e30;
        if (disc < -1e-15) return 1e30;
        assert(disc > 1e-9); // touching
        double t1 = (-B - sqrt(disc))/A, t2 = (-B + sqrt(disc))/A;
        assert(!(t1 > 0 ^ t2 > 0)); // stuck in the middle with you
        return t1 > 0 ? t1 : 1e30;
    }
    void move(double t) { x += t*vx; y += t*vy; }
    void join(drop D) {
        double a = sqr(r), b = sqr(D.r);
        x = (a*x + b*D.x)/(a+b);
        y = (a*y + b*D.y)/(a+b);
        vx = (a*vx + b*D.vx)/(a+b);
        vy = (a*vy + b*D.vy)/(a+b);
        r = sqrt(a+b);
    }
};


int main(void) {
    int N;
    drop D[200];
    scanf("%d", &N);
    for (int i = 0; i < N; ++i)
        scanf("%lf%lf%lf%lf%lf", &D[i].x, &D[i].y, &D[i].vx, &D[i].vy, &D[i].r);
    double last = 0;
    while (true) {
        double t = 1e30;
        int bi = -1, bj = -1;
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < i; ++j) {
                double s = D[i].hit_time(D[j]);
                if (s < t) {
                    t = s;
                    bi = i;
                    bj = j;
                }
            }
        if (t == 1e30) break;
        for (int i = 0; i < N; ++i)
            D[i].move(t);
        D[bj].join(D[bi]);
        //        printf("[%lf] merged %d %d. res %lf %lf %lf %lf %lf\n", t, bj, bi, D[bj].x, D[bj].y, D[bj].vx, D[bj].vy, D[bj].r);
        --N;
        last += t;
        for (int i = bi; i < N; ++i) D[i] = D[i+1];
    }
    printf("%d %.6lf\n", N, last);
    return 0;
}
