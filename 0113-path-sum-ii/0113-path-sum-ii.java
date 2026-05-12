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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
     List<List<Integer>> result = new ArrayList<>();
     dfs(root,targetSum,new ArrayList<>(),result);
     return result;   
    }
    private void dfs(TreeNode root, int targetSum, List<Integer>path,List<List<Integer>>result){
        //base case
        if(root == null){
            return ;
        }
        //adding root 
        path.add(root.val);

        //checking target val
        if(root.left == null && root.right == null && targetSum == root.val){
            result.add(new ArrayList<>(path));
        }
        //recusion of sub tree left or right
        dfs(root.left,targetSum - root.val,path,result);
        dfs(root.right,targetSum - root.val,path,result);
        //backtrack
        path.remove(path.size()-1);
    }
}