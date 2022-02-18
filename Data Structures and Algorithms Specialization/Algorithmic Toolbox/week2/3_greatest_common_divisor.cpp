#include <iostream>
# include <cassert>

int gcd_naive(int a, int b) {
  int current_gcd = 1;
  for (int d = 2; d <= a && d <= b; d++) {
    if (a % d == 0 && b % d == 0) {
      if (d > current_gcd) {
        current_gcd = d;
      }
    }
  }
  return current_gcd;
}

long long gcd_fast(long long a, long long b) {
    if (b == 0) {
        return a;
    }
    return gcd_fast(b, a % b);

    // return b == 0 ? a : gcd_fast(b, a % b);
}

void test_solution() {
    assert(gcd_fast(8, 3) == gcd_naive(8, 3));
    assert(gcd_fast(14, 10) == gcd_naive(14, 10));
    assert(gcd_fast(12, 8) == gcd_naive(12, 8));
    assert(gcd_fast(24, 18) == gcd_naive(24, 18));
    assert(gcd_fast(10, 4) == gcd_naive(10, 4));
    assert(gcd_fast(6, 4) == gcd_naive(6, 4));
    assert(gcd_fast(18, 12) == gcd_naive(18, 12));
    assert(gcd_fast(9, 4) == gcd_naive(9, 4));
    assert(gcd_fast(7, 3) == gcd_naive(7, 3));
    assert(gcd_fast(8, 5) == gcd_naive(8, 5));
}

int main() {
  long long a, b;
  std::cin >> a >> b;
  // std::cout << gcd_naive(a, b) << std::endl;
  // test_solution();
  std::cout << gcd_fast(a, b) << std::endl;
  return 0;
}
