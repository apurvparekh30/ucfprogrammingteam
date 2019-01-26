// 2015 MCPC, Mosaic
// Michael Goldwasser
#include <iostream>
#include <vector>
using namespace std;

const int MAX_WIDTH = 36;
const int MAX_HEIGHT = 20;

int H,W;
string original[MAX_HEIGHT+2];
int grid[MAX_HEIGHT+2][MAX_WIDTH+2];      // shape of piece at particular cell

// To encode the choice of tile shapes, we use the following codes:
#define UNKNOWN 0 // a cell for which we have not yet decided on a shape
#define BLACK 1
#define WHITE 2
#define NW 3       // triangle with black right angle in Northwest corner
#define NE 4       // triangle with black right angle in Northeast corner
#define SE 5       // triangle with black right angle in Southeast corner
#define SW 6       // triangle with black right angle in Southwest corner

int getColor(int shape, int k) {   // 0=UNKNOWN, 1=BLACK, 2=WHITE
    if (shape < NW)
        return shape;
    else
        return 1 + (k+15-2*shape)%8/4;   // handles triangles
}

int makeQuad(int r, int c) {
    return grid[r][c] + grid[r][c+1] * 8 + grid[r+1][c+1] * 64 + grid[r+1][c] * 512;
}

int cycle[16];            // let's build cycle of colors around the quad center (twice)
bool isQuadLegal(int q) {
    cycle[0] = getColor(q % 8, 5);         // would be grid[r][c] SE corner
    cycle[1] = getColor(q % 8, 4);
    cycle[2] = getColor((q >> 3) % 8, 7);  // would be grid[r][c+1] SW corner
    cycle[3] = getColor((q >> 3) % 8, 6);
    cycle[4] = getColor((q >> 6) % 8, 1);  // would be grid[r+1][c+1] NW corner
    cycle[5] = getColor((q >> 6) % 8, 0);
    cycle[6] = getColor((q >> 9) % 8, 3);  // would be grid[r+1][c] NE corner
    cycle[7] = getColor((q >> 9) % 8, 2);
    for (int j=8; j<16; j++)
        cycle[j] = cycle[j-8];

    // Look for illegal (black, whites, black) pattern for white = {1,3,5,6,7}
    bool active(false);
    int wCount(0);
    for (int j=0; j<16; j++) {
        switch (cycle[j]) {
        case BLACK:
            if (active && (wCount % 2 == 1 || wCount == 6))
                return false;    // found odd white block
            active=true;
            wCount=0;
            break;
        case WHITE:
            wCount++;
            break;
        case UNKNOWN:
            active=false;
            break;
        }
    }

    return true;
}

bool isLegal[1<<12];      // isLegal[q] is true if q represents a legal quad

void precomputeLegalQuads() {
    for (int q=0; q < (1<<12); q++) {
        isLegal[q] = isQuadLegal(q);
    }
}

// After solving board, we will need to know how many triangles were used
int numTriangles() {
    int count=0;
    for (int r=1; r <= H; r++)
        for (int c=1; c <= W; c++) {
            if (grid[r][c] >= NW)       // i.e. triangle
                count += 1;
        }
    return count;
}

/* Following is purely for convenience when checking triangle neighbors */
int delta[][2] = { {0,1}, {0,-1}, {1,0}, {-1,0} };

bool legalBlack(int r, int c) {
    if (original[r][c] == '*') return true;   // unconstrained
    int tri(0), unknown(0);
    for (int d=0; d<4; d++) {
        int shape = grid[r+delta[d][0]][c+delta[d][1]];
        if (shape == UNKNOWN) unknown++;
        else if (shape >= NW) tri++;
    }
    int need = original[r][c] - '0';
    return (tri <= need && need <= tri+unknown);
}

void solve(int r, int c) {
    if (r == H+1 && c == W+1) {         // (unique) solution found
        cout << numTriangles() << endl;
    } else {
        if (grid[r][c] == BLACK) {
            if (c == W+1)
                solve(r+1,1);  // start next row
            else
                solve(r,c+1);  // continue in current row
        } else {
            for (int shape = WHITE; shape <= SW; shape++) {
                grid[r][c] = shape;
                // consider pruning if current configuration is problematic
                bool legal=true;
                legal = legal && isLegal[makeQuad(r-1,c-1)];
                legal = legal && isLegal[makeQuad(r-1,c)];
                legal = legal && isLegal[makeQuad(r,c-1)];
                legal = legal && isLegal[makeQuad(r,c)];
                for (int d=0; d<4; d++)
                    if (grid[r+delta[d][0]][c+delta[d][1]] == BLACK)
                        legal = legal && legalBlack(r+delta[d][0], c+delta[d][1]);
                if (legal)
                    solve(r,c+1);     // keep going
                grid[r][c] = UNKNOWN;
            }
        }
    }
}

int main(int argv, char** argc) {
    precomputeLegalQuads();

    cin >> W >> H;

    // read input, but pad with border of unconstrained blacks
    original[0] = string(2+W,'*');
    for (int j=1; j<=H; j++) {
        cin >> original[j];
        original[j] = '*' + original[j] + '*';
    }
    original[H+1] = string(2+W,'*');

    // create grid with buffer of unnumbered blacks around boundary
    for (int r=0; r < H+2; r++)
        for (int c=0; c < W+2; c++) {
            if (original[r][c] == '.')
                grid[r][c] = UNKNOWN;
            else
                grid[r][c] = BLACK;
        }

    solve(1,1);  // time to go to work!!!!
}
