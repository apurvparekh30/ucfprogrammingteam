/*  Hidden Password, MCPC 2015
    C++ Solution by Michael Goldwasser
*/

#include <iostream>
#include <string>
using namespace std;


bool valid(const string& password, const string& message) {
    size_t pos=0;
    for (int j=0; j < password.size(); j++) {
        pos = message.find_first_of(password.substr(j), pos);

        //--------------- debug code ---------------
        cerr << "Search for " << password[j] << " resulted in pos " << pos;
        if (pos == string::npos)
            cerr << " (end of string)" << endl;
        else
            cerr << " (found " << message[pos] << ")" << endl;
        //------------------------------------------

        if (pos == string::npos || message[pos] != password[j])
            return false;
        pos++;  // start search at next location
    }
    return true;
}

int main() {
    string password, message;
    cin >> password >> message;
    cout << (valid(password,message) ? "PASS" : "FAIL") << endl;
}
