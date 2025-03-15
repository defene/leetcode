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
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        unordered_map<int, int> inorderIndexMap;
        for (int i = 0; i < inorder.size(); i++) {
            inorderIndexMap[inorder[i]] = i;
        }

        int preorderIndex = 0;
        return helper(preorder, preorderIndex, inorderIndexMap, 0, inorder.size() - 1);
    }

private:
    TreeNode* helper(vector<int>& preorder, int& preorderIndex, 
                     unordered_map<int, int>& inorderIndexMap, int inLeft, int inRight) {
        if (inRight < inLeft) {
            return nullptr;
        }

        TreeNode* cur = new TreeNode(preorder[preorderIndex++]);
        cur->left = helper(preorder, preorderIndex, inorderIndexMap, inLeft, inorderIndexMap[cur->val] - 1);
        cur->right = helper(preorder, preorderIndex, inorderIndexMap, inorderIndexMap[cur->val] + 1, inRight);

        return cur;     
    }
};