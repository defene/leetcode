class Solution {
public:
    int numSquares(int n) {
        vector<int> square_nums;
        for (int i = 1; i * i <= n; i++) {
            square_nums.push_back(i * i);
        }

        unordered_set<int> set;
        set.insert(n);

        int level = 0;
        while (!set.empty()) {
            level++;
            unordered_set<int> next_set;

            for (int ele : set) {
                for (int sqr : square_nums) {
                    if (ele == sqr) {
                        return level;
                    } else if (ele < sqr) {
                        break;
                    } else {
                        next_set.insert(ele - sqr);
                    }
                }
            }
            set = next_set;
        }

        return level;
    }
};