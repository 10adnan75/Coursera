#include <iostream>
#include <vector>

using std::vector;

int lcs3(vector<int> &a, vector<int> &b, vector<int> &c) {
    int m = a.size(), n = b.size(), z = c.size();
    int LCS[m + 1][n + 1][z + 1];  
    for (int i = 0; i <= m; i++) {
        for (int j = 0; j <= n; j++) {
            for (int k = 0; k <= z; k++) {
                if (i == 0 || j == 0 || k == 0) {
                    LCS[i][j][k] = 0;
                } else if (a[i - 1] == b[j - 1] && b[j - 1] == c[k-1]) {
                    LCS[i][j][k] = 1 + LCS[i - 1][j - 1][k-1];
                } else {
                    LCS[i][j][k] = std::max(std::max(LCS[i - 1][j][k], LCS[i][j - 1][k]), LCS[i][j][k - 1]);
                }
            }
        }
    }
    return LCS[m][n][z];
    // return std::min(std::min(a.size(), b.size()), c.size());
}

int main() {
    size_t an;
    std::cin >> an;
    vector<int> a(an);
    for (size_t i = 0; i < an; i++) {
        std::cin >> a[i];
    }
    size_t bn;
    std::cin >> bn;
    vector<int> b(bn);
    for (size_t i = 0; i < bn; i++) {
        std::cin >> b[i];
    }
    size_t cn;
    std::cin >> cn;
    vector<int> c(cn);
    for (size_t i = 0; i < cn; i++) {
        std::cin >> c[i];
    }
    std::cout << lcs3(a, b, c) << std::endl;
}
