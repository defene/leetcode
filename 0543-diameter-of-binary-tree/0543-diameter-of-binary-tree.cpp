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
    int diameterOfBinaryTree(TreeNode* root) {
        int globalMax = 0;
        helper(root, globalMax);
        return globalMax - 1;
    }

private:
    int helper(TreeNode* root, int& globalMax) {
        if (root == nullptr) {
            return 0;
        }

        int left = helper(root->left, globalMax);
        int right = helper(root->right, globalMax);

        globalMax = max(left + right + 1, globalMax);
        return max(left, right) + 1;
    }
};