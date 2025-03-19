class Solution {
public:
    int numSquares(int n) {
        vector<int> square_nums;
        for (int i = 1; i * i <= n; ++i) {
            square_nums.push_back(i * i);
        }

        queue<int> q;
        unordered_set<int> visited;

        q.push(n);
        visited.insert(n);
        
        int level = 0;

        while (!q.empty()) {
            level++;
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int cur = q.front(); q.pop();
                for (int sq : square_nums) {
                    if (cur == sq)
                        return level;
                    if (cur < sq)
                        break;
                    int next = cur - sq;
                    if (!visited.count(next)) {
                        q.push(next);
                        visited.insert(next);
                    }
                }
            }
        }
        return level;
    }
};