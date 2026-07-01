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
    public boolean isSymmetric(TreeNode root) {
        return isMatch(root.right,root.left);
    }
    private boolean isMatch(TreeNode right , TreeNode left){
        if(right == null && left == null) return true;
        if(right == null || left == null)return false;
        if(right.val != left.val)return false;

        return isMatch(left.left,right.right) && isMatch(left.right, right.left);

    }
}