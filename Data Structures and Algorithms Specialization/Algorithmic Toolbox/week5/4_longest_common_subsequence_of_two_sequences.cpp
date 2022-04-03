#include <iostream>
#include <vector>
#include <algorithm>

using std::vector;

int lcs2(vector<int> &a, vector<int> &b) {
    int sequence[a.size() + 1][b.size() + 1];
    int index = 0;
    while (index <= a.size()) {
        sequence[index][0] = 0;
        index++;
    }
    index = 1;
    while (index <= b.size()) {
        sequence[0][index] = 0;
        index++;
    }
    for (size_t i = 1; i <= a.size(); i++) {
        for (size_t j = 1; j <= b.size(); j++) {
            if (a.at(i - 1) == b.at(j - 1)) {
                sequence[i][j] = 1 + sequence[i - 1][j - 1];
            } else {
                sequence[i][j] = std::max(sequence[i - 1][j], sequence[i][j - 1]);
            }
        }
    }
    return sequence[a.size()][b.size()];
}

int main() {
    size_t n;
    std::cin >> n;
    vector<int> a(n);
    for (size_t i = 0; i < n; i++) {
        std::cin >> a[i];
    }

    size_t m;
    std::cin >> m;
    vector<int> b(m);
    for (size_t i = 0; i < m; i++) {
        std::cin >> b[i];
    }

    std::cout << lcs2(a, b) << std::endl;
}
