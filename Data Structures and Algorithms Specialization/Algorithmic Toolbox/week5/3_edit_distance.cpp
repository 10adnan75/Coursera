#include <iostream>
#include <string>

using std::string;
using std::min;

int edit_distance(const string &str1, const string &str2) {
    int s1 = str1.length(), s2 = str2.length();
    int dp[s1 + 1][s2 + 1]; 
    for (int i = 0; i <= s1; i++) {
        for (int j = 0; j <= s2; j++) {
            if (i == 0) {
                dp[i][j] = j;
            } else if (j == 0) {
                dp[i][j] = i;
            } else if (str1[i - 1] == str2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1];
            } else {
                dp[i][j] = 1 + min(min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
            }
        }
    }
    return dp[s1][s2];
}

int main() {
    string str1;
    string str2;
    std::cin >> str1 >> str2;
    std::cout << edit_distance(str1, str2) << std::endl;
    return 0;
}
