/**
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left 
subtree
 of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
**/

//recursive
class Solution {
    private Integer prev;

    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }

    public boolean inorder(TreeNode root) {
        if (root == null) return true;
        if (!inorder(root.left)) return false;
        if (prev != null && root.val <= prev) return false;
        prev = root.val;
        return inorder(root.right);
    }
}

//iteration
class Solution {

    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Integer prev = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && root.val <= prev) return false;

            prev = root.val;
            root = root.right;
        }
        return true;
    }
        
}
