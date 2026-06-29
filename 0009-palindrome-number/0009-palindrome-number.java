class TreeNode{
    int val;
    TreeNode left, right;

    TreeNode(int val){
        this.val=val;
    }
}

class Solution{
    TreeNode root = null;

    //insert digit to preserve order
    TreeNode insert(TreeNode root, int val){
        if(root == null){
            return new TreeNode(val);
        }

        root.right = insert(root.right,val);
        return root;
    }

    String inorder(TreeNode root){
        if(root==null)
            return " ";

        return inorder(root.left) + root.val + inorder(root.right);
        
    }

        String reverseInorder(TreeNode root){
            if(root == null)
                return " ";

            return reverseInorder(root.right) + root.val + reverseInorder(root.left);
        }

        public boolean isPalindrome(int x){
            if(x<0)
                return false;
            
            String num = String.valueOf(x);
            for(char ch: num.toCharArray()){
                root=insert(root,ch - '0');
            }

            String forward = inorder(root);
            String backward = reverseInorder(root);
            return forward.equals(backward);
        }
    
}