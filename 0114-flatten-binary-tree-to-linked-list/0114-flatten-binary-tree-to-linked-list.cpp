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
    void flatten(TreeNode* root) {
        helper(root);
    }

private:
    TreeNode* helper(TreeNode* root) {
        if (root == nullptr) {
            return nullptr;
        }

        if (root->left == nullptr && root->right == nullptr) {
            return root;
        }

        TreeNode* leftTail = helper(root->left);
        TreeNode* rightTail = helper(root->right);

        if (leftTail != nullptr) {
            leftTail->right = root->right;
            root->right = root->left;
            root->left = nullptr;
        }

        return rightTail == nullptr ? leftTail : rightTail;
    }
};