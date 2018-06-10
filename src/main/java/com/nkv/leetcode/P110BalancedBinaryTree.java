package com.nkv.leetcode;

public class P110BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root != null) {
            if (Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1) {
                return isBalanced(root.left) && isBalanced(root.right);
            } else {
                return false;
            }
        }
        return true;
    }

    private int getHeight(TreeNode root) {
        int h = 0;
        if (root != null) {
            int lh = getHeight(root.left);
            int rh = getHeight(root.right);
            h = (lh > rh) ? lh + 1 : rh + 1;
        }
        return h;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            this.val = x;
        }
    }
}
