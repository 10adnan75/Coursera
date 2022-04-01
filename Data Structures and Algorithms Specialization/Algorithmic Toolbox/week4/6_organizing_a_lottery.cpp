#include <iostream>
#include <vector>
#include <algorithm>
#include <map>

using std::vector;

vector<int> fast_count_segments(vector<std::pair<int, char>> v, vector<int> points) {
  int n = v.size(), m = points.size();
  std::map<int, int> c;
  vector<int> cnt(m);
  int count = 0;
  for (int i = 0; i < n; i++) {  
    if (v[i].second == '0') { 
      count++;
    } else if (v[i].second == '2') {
      count--;
    } else if (v[i].second == '1') { 
      c[v[i].first] = count;
    }
  }
  for (int i = 0; i < m; i++) {
    cnt[i] = c[points[i]];
  }
  return cnt;
}

vector<int> naive_count_segments(vector<int> starts, vector<int> ends, vector<int> points) {
  vector<int> cnt(points.size());
  for (size_t i = 0; i < points.size(); i++) {
    for (size_t j = 0; j < starts.size(); j++) {
      cnt[i] += starts[j] <= points[i] && points[i] <= ends[j];
    }
  }
  return cnt;
}

int main() {
  int n, m;
  std::cin >> n >> m;
  vector<int> starts(n), ends(n);
  std::vector<std::pair<int, char>> v;
  for (size_t i = 0; i < starts.size(); i++) {
    std::cin >> starts[i] >> ends[i];
    v.push_back(std::make_pair(starts[i], '0'));
    v.push_back(std::make_pair(ends[i], '2'));
  }
  vector<int> points(m);
  for (size_t i = 0; i < points.size(); i++) {
    std::cin >> points[i];
    v.push_back(std::make_pair(points[i], '1'));
  }
  //use fast_count_segments
  sort(v.begin(), v.end());
  vector<int> cnt = fast_count_segments(v, points);
  for (size_t i = 0; i < cnt.size(); i++) {
    std::cout << cnt[i] << ' ';
  }
}
