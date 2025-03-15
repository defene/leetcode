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
        unordered_map<int, int> inorderIndex;
        for (int i = 0; i < inorder.size(); i++) {
            inorderIndex[inorder[i]] = i;
        }
        int preIndex = 0;
        return helper(preorder, inorder, preIndex, 0, inorder.size() - 1, inorderIndex);
    }
    
private:
    TreeNode* helper(vector<int>& preorder, vector<int>& inorder, int& preIndex,
                     int inLeft, int inRight, unordered_map<int, int>& inorderIndex) {
        if (inLeft > inRight) {
            return nullptr;
        }
        
        TreeNode* root = new TreeNode(preorder[preIndex]);
        int index = inorderIndex[root->val];
        preIndex++; 

        root->left = helper(preorder, inorder, preIndex, inLeft, index - 1, inorderIndex);
        root->right = helper(preorder, inorder, preIndex, index + 1, inRight, inorderIndex);
        
        return root;
    }
};