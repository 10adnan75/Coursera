#include <iostream>

int get_change(int m) {
    int n = 0;
    n += m / 10;
    n += (m % 10) / 5;
    n += ((m % 10) % 5);
    return n;
}

int main() {
    int m;
    std::cin >> m;
    std::cout << get_change(m) << '\n';
}
