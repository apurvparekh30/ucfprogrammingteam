// Original Author unknown

// Edited on 8/22/2018 by Arup Guha
// Edited to use standard input and process a single test case.

#include <stdio.h>

#define BOOT_ALREADY_USED (-1)

void  read_boots();

/* ************************************************************ */

int main(void)
{
    // Old School C declarations.
    int   left[100], right[100];
    int   data_set_count, k, boot_count, j, m, unmatched;

    // Read the two lists.
    scanf("%d", &boot_count);
    read_boots(left, boot_count);
    read_boots(right, boot_count);

    // Data is small enough to do this the straight forward way w/o data structs.
    unmatched = boot_count;
    for ( j = 0;  j < boot_count;  ++j ) {
        for ( m = 0;  m < boot_count;  ++m ) {
            if ( left[j] == right[m] ) {
                --unmatched;
                right[m] = BOOT_ALREADY_USED;
                break;
            }
        }
    }

    printf("%d\n", unmatched);
    return(0);

}/* end main */

/* ************************************************************ */

void read_boots(int boots[], int boot_count) {

    int j;

    for ( j = 0;  j < boot_count;  ++j )
        scanf("%d", &boots[j]);
}/* end read_boots */
