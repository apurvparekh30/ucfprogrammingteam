#include <stdio.h>

#define BOOT_ALREADY_USED (-1)

FILE  *in_fptr, *fopen();

/* ************************************************************ */

int main(void)
{
   int   left[100], right[100];
   int   data_set_count, k, boot_count, j, m, unmatched;
   void  read_boots();

   if ( (in_fptr = fopen("boots.in", "r")) == NULL )
     {
      printf("*** can't open input file *** \n");
      exit();
     }

   fscanf(in_fptr, "%d", &data_set_count);

   for ( k = 1;  k <= data_set_count;  ++k )
     {
      fscanf(in_fptr, "%d", &boot_count);
      read_boots(left, boot_count);
      read_boots(right, boot_count);

      unmatched = boot_count;
      for ( j = 0;  j < boot_count;  ++j )
         for ( m = 0;  m < boot_count;  ++m )
            if ( left[j] == right[m] )
              {
               --unmatched;
               right[m] = BOOT_ALREADY_USED;
               break;
              }

      printf("Data set #%d = %d\n\n", k, unmatched);

     }/* end for ( k = 1;  k <= data_set_count;  ++k ) */

   if ( fclose(in_fptr) == EOF )
     {
      printf("*** can't close input file *** \n");
      exit();
     }

   return(0);

}/* end main */

/* ************************************************************ */

void read_boots(int boots[], int boot_count)
{
   int j;

   for ( j = 0;  j < boot_count;  ++j )
      fscanf(in_fptr, "%d", &boots[j]);

}/* end read_boots */
