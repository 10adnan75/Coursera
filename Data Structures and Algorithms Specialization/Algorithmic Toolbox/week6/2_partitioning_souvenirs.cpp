#include <iostream>
#include <vector>
#include <numeric>

using std::vector;

int isSubsetSum(vector<int> &a, int n, int sum, int sub) {
    if (sum == 0) {
        return 1;
    }
    if ((n == 0 && sum != 0) || (a[n - 1] > sub)) {
        return 0;
    }
    if (a[n - 1] > sum) {
        return isSubsetSum(a, n - 1, sum, sub);
    }
    return isSubsetSum(a, n - 1, sum, sub) || isSubsetSum(a, n - 1, sum - a[n - 1], sub);
}

int isSubsetSum3(vector<int> &a, int n, int sub) {
    bool arr[sub+1][n+1];
    for (int i = 0; i <= sub; i++) {
        for (int j = 0; j <= n; j++) {
            if (i == 0) {
                arr[i][j] = true;
            } else if (j == 0 && i != 0) {
                arr[i][j] = false;
            } else {
                arr[i][j] = arr[i][j - 1];
                if (i >= a[j - 1]) {
                    arr[i][j] = arr[i][j] || arr[i - a[j - 1]][j - 1];
                }
            }
        }
    }
    return arr[sub][n];
}

int partition3(vector<int> &A) {
    int k = 3, ans = 0, n = A.size();
    int sum = accumulate(A.begin(), A.end(), 0);
    if (n < k || sum % k != 0) {
        return 0;
    }
    int subset = sum / k;
    ans = isSubsetSum3(A, n, subset);
    return ans;
}

int main() {
    int n;
    std::cin >> n;
    vector<int> A(n);
    for (size_t i = 0; i < A.size(); ++i) {
        std::cin >> A[i];
    }
    std::cout << partition3(A) << '\n';
}
