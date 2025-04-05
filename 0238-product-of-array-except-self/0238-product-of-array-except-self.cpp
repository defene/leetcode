class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        // vector<int> prefixProduct(nums.size(), 1);
        // vector<int> suffixProduct(nums.size(), 1);
        // for (int i = 1; i < nums.size(); i++) {
        //     prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
        // }
        // for (int i = nums.size() - 2; i >= 0; i--) {
        //     suffixProduct[i] = suffixProduct[i + 1] * nums[i + 1];
        // }

        // vector<int> result(nums.size(), 1);
        // for (int i = 0; i < nums.size(); i++) {
        //     result[i] = prefixProduct[i] * suffixProduct[i];
        // }

        // return result;

        vector<int> result(nums.size(), 1);
        for (int i = 1; i < nums.size(); i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int R = 1;
        for (int i = nums.size() - 1; i >= 0; i--) {
            result[i] = result[i] * R;
            R *= nums[i];
        }

        return result;
    }
};