/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return helper(preorder, 0, preorder.length - 1, map, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> inorder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        
        TreeNode cur = new TreeNode(preorder[preLeft]);

        int newInLeft = inorder.get(cur.val);
        int leftSubtreeSize = newInLeft - inLeft;

        cur.left = helper(preorder, preLeft + 1, preLeft + leftSubtreeSize, inorder, inLeft, newInLeft - 1);
        cur.right = helper(preorder, preLeft + leftSubtreeSize + 1, preRight, inorder, newInLeft + 1, inRight);

        return cur;
    }
}