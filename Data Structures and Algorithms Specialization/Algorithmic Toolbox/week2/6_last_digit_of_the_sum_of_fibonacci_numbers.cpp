#include <iostream>

int fibonacci_sum_naive(long long n) {
    if (n <= 1)
        return n;

    long long previous = 0;
    long long current  = 1;
    long long sum      = 1;

    for (long long i = 0; i < n - 1; ++i) {
        long long tmp_previous = previous;
        previous = current;
        current = tmp_previous + current;
        sum += current;
    }

    return sum % 10;
}

long long period(long long mod) {
    long long a = 0, b = 1, c = a + b;
    for (int i=0; i<mod*mod; i++) {
        c = (a + b) % mod;
        a = b;
        b = c;
        if (a == 0 && b == 1) {
            return i + 1;
        }
    }
    return 0;
}

int fibonacci_sum(long long n, long long m) {
    long long remainder = n % period(m);
    long long first = 0, second = 1, result = remainder;
    for (int i=1; i<remainder; i++) {
        result = (first + second) % m;
        first = second;
        second = result;
    }
    return result % m;
}

long long fibonacci_sum_fast(long long n) {
    int a = fibonacci_sum(n+2, 10);
    int b = fibonacci_sum(2, 10);
    if (a >= b) {
        return a - b;
    }
    return 10 + a - b;
}

int main() {
    long long n = 0;
    std::cin >> n;
    // std::cout << fibonacci_sum_naive(n);
    std::cout << fibonacci_sum_fast(n);
}
