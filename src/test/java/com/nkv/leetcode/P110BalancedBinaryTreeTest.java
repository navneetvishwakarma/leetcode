package com.nkv.leetcode;

public class P110BalancedBinaryTreeTest {

    public static void main (String [] args) {

        P110BalancedBinaryTree solution = new P110BalancedBinaryTree();

        P110BalancedBinaryTree.TreeNode root = solution.new TreeNode(1);
        P110BalancedBinaryTree.TreeNode n1 = solution. new TreeNode(2);
        P110BalancedBinaryTree.TreeNode n2 = solution. new TreeNode(2);
        P110BalancedBinaryTree.TreeNode n3 = solution. new TreeNode(3);
        P110BalancedBinaryTree.TreeNode n4 = solution. new TreeNode(3);
        P110BalancedBinaryTree.TreeNode n5 = solution. new TreeNode(4);
        P110BalancedBinaryTree.TreeNode n6 = solution. new TreeNode(5);

        root.left = n1;
        root.right = n2;

        n1.left = n3;
        n1.right = n4;

        n3.left = n5;
        n3.right = n6;

        System.out.println(solution.isBalanced(root));

    }

}
