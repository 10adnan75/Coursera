#include <iostream>
#include <vector>
using std::vector;

long long get_fibonacci_partial_sum_naive(long long from, long long to) {
    long long sum = 0;

    long long current = 0;
    long long next  = 1;

    for (long long i = 0; i <= to; ++i) {
        if (i >= from) {
            sum += current;
        }

        long long new_current = next;
        next = next + current;
        current = new_current;
    }

    return sum % 10;
}

long long last_digit_fibonacci_sum(long long n) {
    long long curr = 0;
    for (long long idx=2, first=0, second=1; idx <= n; idx++) {
        curr = (first + second) % 60;
        first = second;
        second = curr;
    }
    return curr - 1;
}

long long fibonacci(long long n) {
    if (n == -1) {
        return 0;
    } else if (n <= 1) {
        return n;
    }
    long long rem = n % 60;
    if (rem == 0) {
        return 0;
    }
    return last_digit_fibonacci_sum(rem + 2) % 10;
}

long long get_fibonacci_partial_sum_fast(long long from, long long to) {
    long long result = 10 + fibonacci(to) - fibonacci(from - 1);
    return result % 10;
}

int main() {
    long long from, to;
    std::cin >> from >> to;
    // std::cout << get_fibonacci_partial_sum_naive(from, to) << '\n';
    std::cout << get_fibonacci_partial_sum_fast(from, to) << '\n';
}
