package com.xask00.lc.tree;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for {@link BTreeLCA} covering typical and edge cases.
 */
public class BTreeLCATest {

	private BTreeLCA lca = new BTreeLCA();

	@Test
	public void testSameNodeReturnsNode() {
		BTreeLCA.TreeNode root = new BTreeLCA.TreeNode(1);
		BTreeLCA.TreeNode res = lca.lowestCommonAncestor(root, root, root);
		assertSame("When both nodes are the same instance, result should be that node", root, res);
	}

	@Test
	public void testOneNodeAncestorOfOther() {
		// root(3)
		BTreeLCA.TreeNode root = new BTreeLCA.TreeNode(3);
		BTreeLCA.TreeNode p = new BTreeLCA.TreeNode(5);
		BTreeLCA.TreeNode q = new BTreeLCA.TreeNode(1);
		root.left = p;
		root.right = q;

		// p is ancestor of its own child
		BTreeLCA.TreeNode child = new BTreeLCA.TreeNode(6);
		p.left = child;

		BTreeLCA.TreeNode res = lca.lowestCommonAncestor(root, p, child);
		assertSame("Ancestor node should be returned when one node is ancestor of the other", p, res);
	}

	@Test
	public void testLowestCommonAncestorDifferentSubtrees() {
		// Build a tree used in examples: [3,5,1,6,2,0,8,null,null,7,4]
		BTreeLCA.TreeNode n3 = new BTreeLCA.TreeNode(3);
		BTreeLCA.TreeNode n5 = new BTreeLCA.TreeNode(5);
		BTreeLCA.TreeNode n1 = new BTreeLCA.TreeNode(1);
		BTreeLCA.TreeNode n6 = new BTreeLCA.TreeNode(6);
		BTreeLCA.TreeNode n2 = new BTreeLCA.TreeNode(2);
		BTreeLCA.TreeNode n0 = new BTreeLCA.TreeNode(0);
		BTreeLCA.TreeNode n8 = new BTreeLCA.TreeNode(8);
		BTreeLCA.TreeNode n7 = new BTreeLCA.TreeNode(7);
		BTreeLCA.TreeNode n4 = new BTreeLCA.TreeNode(4);

		n3.left = n5; n3.right = n1;
		n5.left = n6; n5.right = n2;
		n2.left = n7; n2.right = n4;
		n1.left = n0; n1.right = n8;

		// LCA of 5 and 1 is 3
		BTreeLCA.TreeNode res1 = lca.lowestCommonAncestor(n3, n5, n1);
		assertSame(n3, res1);

		// LCA of 6 and 4 is 5
		BTreeLCA.TreeNode res2 = lca.lowestCommonAncestor(n3, n6, n4);
		assertSame(n5, res2);
	}

	@Test
	public void testSingleNodeTreeWithMissingNode() {
		BTreeLCA.TreeNode root = new BTreeLCA.TreeNode(10);
		BTreeLCA.TreeNode missing = new BTreeLCA.TreeNode(99);

		// missing is not part of the tree; if both nodes missing -> null
		BTreeLCA.TreeNode resBothMissing = lca.lowestCommonAncestor(null, missing, missing);
		assertNull("LCA should be null when tree is null", resBothMissing);

		// When one node is in tree and the other is not, method returns the found node (per implementation)
		BTreeLCA.TreeNode resOneMissing = lca.lowestCommonAncestor(root, root, missing);
		assertSame("If one node present and the other is not, the present node should be returned", root, resOneMissing);
	}

	@Test
	public void testBothNodesNotPresent() {
		BTreeLCA.TreeNode root = new BTreeLCA.TreeNode(1);
		BTreeLCA.TreeNode a = new BTreeLCA.TreeNode(2);
		BTreeLCA.TreeNode b = new BTreeLCA.TreeNode(3);

		// a and b are not attached to root, so result should be null
		BTreeLCA.TreeNode res = lca.lowestCommonAncestor(root, a, b);
		assertNull("LCA should be null when neither node is present in the tree", res);
	}

}
