class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        deque<int> monoQueue;
        vector<int> result;

        for (int i = 0; i < k; i++) {
            while (!monoQueue.empty() && nums[i] >= nums[monoQueue.back()]) {
                monoQueue.pop_back();
            }
            monoQueue.push_back(i);
        }
        result.push_back(nums[monoQueue.front()]);

        
        for (int i = k; i < nums.size(); i++) {
            if (monoQueue.front() == i - k) {
                monoQueue.pop_front();
            }

            while (!monoQueue.empty() && nums[i] >= nums[monoQueue.back()]) {
                monoQueue.pop_back();
            }

            monoQueue.push_back(i);
            result.push_back(nums[monoQueue.front()]);
        }

        return result;
    }
};