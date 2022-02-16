#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

long long max_pair_prod(vector<int>& arr) {
    int max_idx1 = -1, max_idx2 = -1, N = arr.size();
    for (int i=0; i<N; i++) {
        if ((max_idx1 == -1) || (arr[i] > arr[max_idx1])) {
            max_idx1 = i;
        }
    }
    for (int j=0; j<N; j++) {
        if ((j != max_idx1) && ((max_idx2 == -1) || (arr[j] > arr[max_idx2]))) {
            max_idx2 = j;
        }
    }
    // cout << max_idx1 << ' ' << max_idx2 << '\n';
    return (long long) arr[max_idx1] * arr[max_idx2];
}

int main() {
    int n; cin >> n;
    vector<int> numbers(n);
    for (int i=0; i<n; i++) cin >> numbers[i];
    cout << max_pair_prod(numbers) << "\n";
    return 0;
}