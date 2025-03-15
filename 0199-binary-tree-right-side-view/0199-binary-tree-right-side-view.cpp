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
    vector<int> rightSideView(TreeNode* root) {
        vector<int> result;
        if (root == nullptr) {
            return result;
        }

        deque<TreeNode*> queue;
        queue.push_back(root);

        while (!queue.empty()) {
            int level_length = queue.size();
            
            for (int i = 0; i < level_length; i++) {
                TreeNode* cur = queue.front();
                queue.pop_front();

                if (cur->left != nullptr) {
                    queue.push_back(cur->left);
                }
                if (cur->right != nullptr) {
                    queue.push_back(cur->right);
                }

                if (i == level_length - 1) {
                    result.push_back(cur->val);
                }                
            }
        }

        return result;
    }
};