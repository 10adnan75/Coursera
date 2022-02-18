#include <iostream>
#include <cassert>

long long lcm_naive(int a, int b) {
  for (long l = 1; l <= (long long) a * b; ++l)
    if (l % a == 0 && l % b == 0)
      return l;

  return (long long) a * b;
}

long long gcd(long a, long b) {
    return b == 0 ? a : gcd(b, a % b);
}

long long lcm_fast(long long a, long long b) {
    return (a * b) / gcd(a, b);
}

void test_solution() {
    assert(lcm_fast(10, 2) == lcm_naive(10, 2));
    assert(lcm_fast(18, 12) == lcm_naive(18, 12));
    assert(lcm_fast(12, 4) == lcm_naive(12, 4));
    assert(lcm_fast(100, 22) == lcm_naive(100, 22));
    assert(lcm_fast(100, 35) == lcm_naive(100, 35));
}

int main() {
  long long a, b;
  std::cin >> a >> b;
  // std::cout << lcm_naive(a, b) << std::endl;
  // test_solution();
  std::cout << lcm_fast(a, b) << std::endl;
  return 0;
}
