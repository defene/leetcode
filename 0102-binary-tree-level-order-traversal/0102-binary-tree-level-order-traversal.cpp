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
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> levels;
        if (root ==nullptr) {
            return levels;
        }

        deque<TreeNode*> queue;
        queue.push_back(root);

        int level = 0;
        while (!queue.empty()) {
            levels.push_back({});

            int level_length = queue.size();
            for (int i = 0; i < level_length; i++) {
                TreeNode* cur = queue.front();
                queue.pop_front();

                levels[level].push_back(cur->val);
                if (cur->left != nullptr) {
                    queue.push_back(cur->left);
                }
                if (cur->right != nullptr) {
                    queue.push_back(cur->right);
                }
            }

            level++;
        }

        return levels;
    } 
};