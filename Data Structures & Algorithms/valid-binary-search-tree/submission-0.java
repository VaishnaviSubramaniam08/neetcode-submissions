class Solution {

    public boolean isValidBST(TreeNode root) {

        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    public boolean validate(TreeNode node, long min, long max){

        // Empty tree is valid
        if(node == null){
            return true;
        }

        // Current node must be inside range
        if(node.val <= min || node.val >= max){
            return false;
        }

        // Check left subtree
        boolean left = validate(node.left, min, node.val);

        // Check right subtree
        boolean right = validate(node.right, node.val, max);

        return left && right;
    }
}