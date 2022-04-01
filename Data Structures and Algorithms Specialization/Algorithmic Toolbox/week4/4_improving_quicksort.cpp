#include <iostream>
#include <vector>
#include <cstdlib>
#include <utility>

using std::vector;
using std::swap;
using std::pair;
using std::make_pair;

pair<int, int> partition3(vector<int> &a, int l, int r) {
  int x = a[l];
  int j = l;
  int k = r;
  for (int i = l + 1; i <= r; i++) {
    if (a[i] < x) {
      j++;
      swap(a[i], a[j]);
    }
  }
  swap(a[l], a[j]);
  for (int i = r - 1; i >= j - 1; i--) {
    if (a[i] > x) {
      k--;
      swap(a[i], a[k]);
    }
  }
  swap(a[r], a[k]);
  return make_pair(j, k);
}

void randomized_quick_sort(vector<int> &a, int l, int r) {
  if (l >= r) {
    return;
  }
  int k = l + rand() % (r - l + 1);
  swap(a[l], a[k]);
  pair<int, int> j_k = partition3(a, l, r);
  randomized_quick_sort(a, l, j_k.first-1);
  randomized_quick_sort(a, j_k.second, r);
}

int main() {
  int n;
  std::cin >> n;
  vector<int> a(n);
  for (size_t i = 0; i < a.size(); ++i) {
    std::cin >> a[i];
  }
  randomized_quick_sort(a, 0, a.size() - 1);
  for (size_t i = 0; i < a.size(); ++i) {
    std::cout << a[i] << ' ';
  }
}