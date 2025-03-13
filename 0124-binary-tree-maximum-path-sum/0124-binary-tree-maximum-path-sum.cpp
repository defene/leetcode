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
private:
    int globalMax;

public:
    int maxPathSum(TreeNode* root) {
        globalMax = INT_MIN;
        pathSum(root);

        return globalMax;
    }

private:
    int pathSum(TreeNode* root) {
        if (root == NULL) {
            return 0;
        }

        int leftPathSum = pathSum(root->left);
        int rightPathSum = pathSum(root->right);

        if (root->left == NULL && root->right == NULL) {
            globalMax = max(root->val, globalMax);
            return root->val;
        }

        leftPathSum = (leftPathSum >= 0) ? leftPathSum : 0;
        rightPathSum = (rightPathSum >= 0) ? rightPathSum : 0;
        globalMax = max(leftPathSum + root->val + rightPathSum, globalMax);

        return max(leftPathSum, rightPathSum) + root->val;
    }
};