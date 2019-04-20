// MCPC'15: Agglomerator
// Author: Michael Goldwasser
#include <iostream>
#include <iomanip>
#include <cmath>
#include <set>
using namespace std;


#define TOLERANCE  // compute minimum tolerance for nearby times or collision testing
#define VERBOSE    // produce verbose summary of simulation

#define MAX_N 100
#define SEP_TIME 0.001     // minimum separation of event times
#define CLOSE_CALL 0.001   // minimum separation away from tangent collisions

#ifdef TOLERANCE
#define BIGEPS 1000000.0
double epsTime=BIGEPS;
double epsCollide=BIGEPS;
#endif

bool error(false);

struct Droplet {
    double x, y, vx, vy, r;
    Droplet() {}
    Droplet(double x, double y, double vx, double vy, double r)
        : x(x), y(y), vx(vx), vy(vy), r(r) { }

    void dump(ostream& out) {
        out << "{x=" << x << ", y=" << y << ", vx=" << vx << ", vy=" << vy << ", r=" << r << "}";
    }
};

struct Event {
    double t;
    int j;
    int k;
    bool collision;     // true if a collision; false if a miss
#ifdef TOLERANCE
    double tolerance;   // how close was separation to tangency
#endif

    Event(double t, int j, int k) : t(t), j(j), k(k), collision(false) { }
    bool operator<(const Event& other) const {
        return t < other.t;
    }

#ifdef VERBOSE
    void dump(ostream& out) {
        out << "[drops " << j << " and " << k << " will";
#ifdef TOLERANCE
        if (!collision) out << " NOT";
#endif        
        out << " collide at t=" << t << "]";
    }
#endif

};


Droplet drop[2*MAX_N];  // include room for future agglomerates
bool alive[2*MAX_N] = {0};


void advanceDroplet(int j, double dt) {
    if (alive[j]) {
        drop[j].x += dt * drop[j].vx;
        drop[j].y += dt * drop[j].vy;
    }
}

Droplet combineDrops(int j, int k) {
    double a1 = drop[j].r*drop[j].r;
    double a2 = drop[k].r*drop[k].r;
    double p = a1 / (a1+a2);
    Droplet result;
    result.r = sqrt(a1+a2);
    result.x = drop[j].x * p + drop[k].x * (1-p);
    result.y = drop[j].y * p + drop[k].y * (1-p);
    result.vx = drop[j].vx * p + drop[k].vx * (1-p);
    result.vy = drop[j].vy * p + drop[k].vy * (1-p);
    return result;
}

#ifdef TOLERANCE
// compute nearest approach to origin of line defined by (x,y) and (x+vx,y+vy)
double computeSeparation(double x, double y, double vx, double vy) {
    return abs((x+vx)*y - (y+vy)*x)/sqrt(vx*vx+vy*vy);
}
#endif

// return event representing upcoming collision between drop[j] and drop[k] relative to current time
// (of course, if time is negative, then this is not a future collision)
Event findCollision(int j, int k) {
    Event result(-10000, j, k);

    // let's assume that j is stationary blob with combined radius, and k is just point that moves
    double x = drop[k].x - drop[j].x;
    double y = drop[k].y - drop[j].y;
    double r = drop[k].r + drop[j].r;
    double vx = drop[k].vx - drop[j].vx;
    double vy = drop[k].vy - drop[j].vy;

    // so when (if ever) will point (x,y) reach radius r of origin, if moving with (vx,vy)
    // solve quadratic equation
    double a = vx*vx+vy*vy;

    if (a > 0) {

#ifdef TOLERANCE
        result.tolerance = abs(r - computeSeparation(x,y,vx,vy));
#endif

        double b = 2*(x*vx+y*vy);
        double c = x*x+y*y-r*r;
        double det = b*b - 4*a*c;

        if (det >= 0) {
            result.collision = true;
            double rootSmall = (-b - sqrt(det))/(2*a);
            double rootBig = (-b + sqrt(det))/(2*a);
            if (rootSmall > 0) {
                result.t = rootSmall;
            } else {
                result.t = rootBig;

                if (rootBig >= 0) {
                    // report error on cout so that such a case raises red flag
                    cout << "============================================================" << endl;
                    cout << "ERROR: two drops " << j << " and " << k << " are already colliding" << endl;
                    drop[j].dump(cout); cout << endl;
                    drop[k].dump(cout); cout << endl;
                    cout << "============================================================" << endl;
                    error = true;
                }
            }
        } else {
            result.t = -b / (2*a);     // pretend determinant was zero to approximate collision time on near miss
        }
    }

    return result;
}

int main() {
    int N;
    cin >> N;
    for (int j=0; j < N; j++) {
        cin >> drop[j].x >> drop[j].y >> drop[j].vx >> drop[j].vy >> drop[j].r;
        alive[j] = true;

#ifdef VERBOSE
        cerr << "original " << j << ": ";  drop[j].dump(cerr); cerr << endl;
#endif
    }

    double time(0);  // current time
    multiset<Event> future;
    for (int j=0; j < N; j++)
        for (int k=0; k < j; k++) {
            Event e = findCollision(j,k);
#ifdef TOLERANCE
            if (true) {             // put ALL (pseudo)events in the queue
#else
            if (e.collision && e.t > 0) {
#endif
                e.t += time;
                future.insert(e);
#ifdef VERBOSE
                e.dump(cerr); cerr << endl;
#endif
            }
        }

    while (!future.empty()) {
        multiset<Event>::iterator it = future.begin();
        Event e = *it;
        future.erase(it);

#ifdef TOLERANCE
        if (alive[e.j] && alive[e.k] && e.t >= time)
            epsCollide = min(epsCollide, e.tolerance);
#endif

        if (e.collision && e.t >= time && alive[e.j] && alive[e.k]) {
#ifdef TOLERANCE
            epsTime = min(epsTime, e.t-time);
#endif
            // move all droplets forward for new simulation period
            double dt = e.t - time;
            time = e.t;
            for (int i=0; i < N; i++)
                advanceDroplet(i, dt);

            // combine j and k into new drop[N]
            alive[e.j] = alive[e.k] = false;
            alive[N] = true;
            drop[N] = combineDrops(e.j, e.k);

#ifdef VERBOSE
            cerr << "At time " << time << ", combining drops:" << endl;
            cerr << "  " << e.j << ": ";  drop[e.j].dump(cerr); cerr << endl;
            cerr << "  " << e.k << ": ";  drop[e.k].dump(cerr); cerr << endl;
            cerr << "  to form new " << N << ": "; drop[N].dump(cerr); cerr << endl;
#endif

            for (int j=0; j < N; j++) {
                if (alive[j]) {
                    Event e = findCollision(j,N);

#ifdef TOLERANCE
		    epsCollide = min(epsCollide, abs(drop[j].r+drop[N].r -
						     sqrt((drop[j].x-drop[N].x)*(drop[j].x-drop[N].x) +
							  (drop[j].y-drop[N].y)*(drop[j].y-drop[N].y))));

                    if (true) {             // put ALL (pseudo)events in the queue
#else
                    if (e.collision && e.t > 0) {
#endif
                        e.t += time;
                        future.insert(e);
#ifdef VERBOSE
                        e.dump(cerr); cerr << endl;
#endif
                    }
                }
            }
            N++;  // account for one new droplet
        }
#ifdef VERBOSE
        else {
            cerr << "At time " << time << 
            cerr << " removing defunct event from queue: "; e.dump(cerr); cerr << endl;
        }
#endif
    }

    int count(0);
    for (int j=0; j < N; j++)
        if (alive[j]) count++;
    cout << count << " " << setprecision(9) << time << endl;
    if (error)
        cout << "ERROR has occurred" << endl;

#ifdef TOLERANCE
    if (epsTime != BIGEPS)
        cerr << "Minimum event separation: " << fixed << setprecision(20) << epsTime << endl;
    cerr << "Minimum collision tolerance: " << fixed << setprecision(20) << epsCollide << endl;
    
    if (epsTime < SEP_TIME) cout << "Minimum separation of event times violated" << endl;
    if (epsCollide < CLOSE_CALL) cout << "Minimum separation of drops violated" << endl;
#endif
}
