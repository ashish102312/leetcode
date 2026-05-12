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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //checking is root is null
        if(root == null){
            return false;
        }

        //leaf node
        if(root.left == null && root.right == null){
            return targetSum == root.val;
        }
        //remaing 
        int remaining = targetSum - root.val;

        //checking subtres
        return hasPathSum(root.left,remaining) || hasPathSum(root.right,remaining);
    }
}