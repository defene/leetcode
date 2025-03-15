/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int pathSum(TreeNode* root, int targetSum) {
        int result = 0;
        unordered_map<long long, int> prefixSum;
        helper(root, (long long)targetSum, result, prefixSum, 0LL);
        return result;
    }

private:
    void helper(TreeNode* root, long long targetSum, int& result, unordered_map<long long, int>& prefixSum, long long currSum) {
        if (root == nullptr) {
            return;
        }

        currSum += root->val;
        if (currSum == targetSum) {
            result++;
        }

        result += prefixSum[currSum - targetSum];
        
        prefixSum[currSum]++;
        helper(root->left, targetSum, result, prefixSum, currSum);
        helper(root->right, targetSum, result, prefixSum, currSum);
        prefixSum[currSum]--;
    }
};