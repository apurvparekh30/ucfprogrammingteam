/*  Hidden Password, MCPC 2015
    C++ Solution by James Feher
*/

#include <iostream>
#include <cstring>
using namespace std;

string testPass(string, string);

int main() {   

  string pass, testphrase;

  cin  >> pass >> testphrase;             // Get the password and testphrase

  cout << testPass(pass, testphrase) << endl;

  return 0;
} // end main


string testPass(string p, string pf) {
// input p is the password and pf is the pass phrase to check
// return PASS or FAIL
  string retval = "FAIL";
  int i, j;

  // character from password in the given position, -1 not taken
  int position[40];  
  for (i=0; i<40; i++) 
    position[i] = -1;
  // number of times this letter has occured in the password so far
  int letter  [26] = {0};

  // find each letter in the passphrase 
  bool found = true;
  for (i=0; i<p.length() && found; i++) {
    found = false;
    for (j=0; j<pf.length() && !found; j++) {
      // match and not spot not taken, need for duplicate chars
      if (p[i] == pf[j] && position[j] < 0) {
        found = true;
        position[j] = i;	// record the letter in that position
        letter[int(p[i] - 'A')]++;
      }
    }
  }

  // finished and found all of the letters in password, if not it is a fail
  // now see if they came in the right order
  if (found) { 
    bool inOrder = true;
    int char2Check = 0;
    for (i=0; i<pf.length(); i++) {
      // found a letter from password
      if (position[i] >= 0) {
        if (position[i] == char2Check) {
          char2Check++;		// now look for next one
        // but it is out of order 
        } else {
          inOrder = false;
        }
      }
    }
    
    retval = (inOrder) ? "PASS" : "FAIL";
  } 

  return retval;        
} // end testPass
