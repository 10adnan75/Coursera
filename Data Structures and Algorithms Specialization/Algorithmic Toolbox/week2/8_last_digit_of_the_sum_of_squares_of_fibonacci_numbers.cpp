#include <iostream>

int fibonacci_sum_squares_naive(long long n) {
    if (n <= 1)
        return n;

    long long previous = 0;
    long long current  = 1;
    long long sum      = 1;

    for (long long i = 0; i < n - 1; ++i) {
        long long tmp_previous = previous;
        previous = current;
        current = tmp_previous + current;
        sum += current * current;
    }

    return sum % 10;
}

long long period(long long m) {
    long long a = 0, b = 1, c = a + b;
    for (int i=0; i<m*m; i++) {
        c = (a + b) % m;
        a = b;
        b = c;
        if (a == 0 && b == 1) {
            return i + 1;
        }
    }
    return 0;
}

int fibonacci_sum_squares_fast(long long n, long long m) {
    long long remainder = n % period(m);
    long long first = 0, second = 1, res = remainder;
    for (int i=1; i<remainder; i++) {
        res = (first + second) % m;
        first = second;
        second = res;
    }
    return res % m;
}

int main() {
    long long n = 0;
    std::cin >> n;
    // std::cout << fibonacci_sum_squares_naive(n);
    std::cout << fibonacci_sum_squares_fast(n+1, 10) * fibonacci_sum_squares_fast(n, 10) % 10;
}
