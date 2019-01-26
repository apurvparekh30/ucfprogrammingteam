/*  MCPC 2015: Line Them Up
    C++ Solution by James Feher
*/

#include <iostream>
#include <cstring>
using namespace std;

bool DEBUG = false;      // Make sure to set to false on submission

int main() {   

  int N, i;
  bool increasing, decreasing;

  string people[20];
  string largest, smallest;

  cin >> N;             // Get the number of people in the group

  // get each person
  for (i=0; i<N; i++) {
    cin >> people[i];
  }

  increasing = decreasing = true;
  // process the list of people 
  for (i=0; i<N-1; i++) {
    DEBUG && cout << "i: " << i << " people[i]: " << people[i] << " people[i+1]: " << people[i+1] <<endl;
    if (people[i].compare(people[i+1]) > 0) {
      DEBUG && cout << "s: " << i << " people[i]: " << people[i] << " people[i+1]: " << people[i+1] <<endl;
      //smallest = people[i];
      increasing = false;
    }
    if (people[i].compare(people[i+1]) < 0) {
      DEBUG && cout << "l: " << i << " people[i]: " << people[i] << " people[i+1]: " << people[i+1] <<endl;
      //largest = people[i];
      decreasing = false;
    }
  }

  if (increasing == true && decreasing == false) {
    cout << "INCREASING\n";
  } else if (increasing == false && decreasing == true) {
    cout << "DECREASING\n";
  } else {
    cout << "NEITHER\n";
  }

  return 0;
} // end main
