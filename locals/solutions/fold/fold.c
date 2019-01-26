/*
   UCF 2012 (Fall) Local Programming Contest
   Problem: fold
   Original Author Unknown

   Edited by Arup Guha on 8/22/2018 to do standard input and
   process a single input case for the 2018 Fall UCF Practice Contest
*/

#include <stdio.h>
#include <stdlib.h>

/* ************************************************************ */

int main(void) {

    // Old School C declarations all at the top!
    int   data_set_count, k, side1, side2, fold_count, j;

    // Read the input.
    scanf("%d %d %d", &side1, &side2, &fold_count);

    // Time to do some folding!
    for ( j = 1;  j <= fold_count;  ++j ) {

        // Just use int division to fold the appropriate side.
        if ( side1 > side2 )
            side1 /= 2;
        else
            side2 /= 2;
    }

    // Output the final dimensions printing the larger one first.
    if ( side1 > side2 )
        printf("%d %d\n\n", side1, side2);
    else
        printf("%d %d\n\n", side2, side1);

    return(0);

}/* end main */

/* ************************************************************ */

