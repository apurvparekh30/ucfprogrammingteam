/*
*
*	Author: Alfredo Zellek 	
*	
* 	Composition Solution
*	
*	We can view this problem as a graph problem where f(A) = B is a directed edge from A to B.
*	Looking at it this way, we notice that the input will always yield some number of disjoint cycles.
*	But are we always guaranteed to get cycles? yes! because the function f is bijective from the set 
* 	{1, 2, ... n} to itself what we have is a permutation of the integers, such a mapping always has cycles.
*	Then, the problem boils down to finding the smallest m, such that no matter where node in the graph we 
* 	start at, after going to the next node m times, we will get back to the node we started at. 
*	So to find the smallest m, we need to find the lengths of all the disjoint cycles and find their least 
*	common multiple.
*
Kip's note: how about this? "We want to find the cycle with the smallest number of edges (m), starting on any graph node."
*/

#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

//const int N = 1e6;       // generates warning
const int N = 100000;      // KRI
int n, a[N], seen[N];
vector<int>lens;

// nonrecursive gcd, since __gcd does not exist in the Microsoft C++ implementation.

int gcd(int a, int b)  {  
	int c = a % b;  
	while(c != 0)  {    
		a = b;    
		b = c;    
		c = a % b;  
	}  
	return b;
}

int main()
{
	int T;
	cin >> T;
	while(T--)
	{
		lens.clear();
		for(int i = 0; i < N; i++)
			seen[i] = 0;

		cin >> n; 

		for(int i = 0; i < n; i++)
		{
			int x, y; 
			cin >> x >> y; 
			a[x] = y;
		}

		for(int i = 1; i <= n; i++) 
		{
			if(!seen[i])
			{
				int size = 1;
				seen[i] = 1;
				int ptr = a[i]; 
				while(ptr != i)
				{
					seen[ptr] = 1;
					ptr = a[ptr];
					size++;
				}
				lens.push_back(size);
			}
		}
	
		int lcm = lens[0];
		int lenSize = lens.size();
		for(int i = 1; i < lenSize; i++)
			lcm = lcm * (lens[i] / gcd(lcm, lens[i]));  // KRI
			//lcm = lcm * (lens[i] / __gcd(lcm, lens[i]));

		cout << lcm << endl;
	}
}
