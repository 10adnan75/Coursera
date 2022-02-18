#include <iostream>

long long get_fibonacci_huge_naive(long long n, long long m) {
    if (n <= 1)
        return n;

    long long previous = 0;
    long long current  = 1;

    for (long long i = 0; i < n - 1; ++i) {
        long long tmp_previous = previous;
        previous = current;
        current = tmp_previous + current;
    }

    return current % m;
}

long long pisano_period(long long m) {
    for (long long i=0, a=0, b=1, c; i<m*m; i++) {
        c = (a + b) % m;
        a = b;
        b = c;
        if (a == 0 && b == 1) {
            return i + 1;
        }
    }
    return 0;
}

long long fibonacci(long long n, long long mod) {
    if (n <= 1) {
        return n;
    }
    long long fib[n];
    fib[0] = 0;
    fib[1] = 1;
    for (int i=2; i<=n; i++) {
        fib[i] = (fib[i-1] + fib[i-2]) % mod;
    }
    return fib[n] % mod;
}

long long get_fibonacci_huge_fast(long long n, long long m) {
    n = n % pisano_period(m);
    return fibonacci(n, m);
}

int main() {
    long long n, m;
    std::cin >> n >> m;
    // std::cout << get_fibonacci_huge_naive(n, m) << '\n';
    std::cout << get_fibonacci_huge_fast(n, m) << '\n';
}
