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
    int ans = 0;
    int[] solve(TreeNode root){
        if(root == null)return new int[]{0,0};
        int[] left = solve(root.left);
        int[] right = solve(root.right);
        
        int sum = root.val+left[0]+right[0];
        int cnt = left[1]+right[1]+1;

        if(root.val == sum/cnt)ans++;
        
        return new int[]{sum,cnt};
    }
    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return ans;
    }
}