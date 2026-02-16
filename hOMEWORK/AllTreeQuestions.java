package hOMEWORK;
import java.util.*;

// Definition for Binary Tree / BST node
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

// Definition for Generic Tree node
class GNode {
    int val;
    ArrayList<GNode> children = new ArrayList<>();
    GNode(int val) {
        this.val = val;
    }
}

public class AllTreeQuestions {

    // Q1: Check if Binary Tree is BST
    public boolean isBST(TreeNode root) {
        return isBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isBSTUtil(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return isBSTUtil(root.left, min, root.val) &&
               isBSTUtil(root.right, root.val, max);
    }

    // Q2: Convert Binary Tree to BST
    ArrayList<Integer> list = new ArrayList<>();
    int idx = 0;

    public void binaryToBST(TreeNode root) {
        list.clear();
        idx = 0;
        storeInorder(root);
        Collections.sort(list);
        fillInorder(root);
    }

    private void storeInorder(TreeNode root) {
        if (root == null) return;
        storeInorder(root.left);
        list.add(root.val);
        storeInorder(root.right);
    }

    private void fillInorder(TreeNode root) {
        if (root == null) return;
        fillInorder(root.left);
        root.val = list.get(idx++);
        fillInorder(root.right);
    }

    // Q3: Sum of all nodes in BST / Binary Tree
    public int sumOfTree(TreeNode root) {
        if (root == null) return 0;
        return root.val + sumOfTree(root.left) + sumOfTree(root.right);
    }

    // Q4: Find Maximum value in BST
    public int maxValueBST(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    // Q5: Find Second Largest value in BST
    public int secondLargest(TreeNode root) {
        TreeNode curr = root;
        TreeNode parent = null;

        while (curr.right != null) {
            parent = curr;
            curr = curr.right;
        }

        if (curr.left != null) {
            curr = curr.left;
            while (curr.right != null) {
                curr = curr.right;
            }
            return curr.val;
        }

        return parent.val;
    }

    // Q6: Update Second Occurrence of a value in BST
    // (duplicates assumed on RIGHT side)
    int count = 0;

    public void updateSecondOccurrence(TreeNode root, int target, int newVal) {
        count = 0;
        updateUtil(root, target, newVal);
    }

    private void updateUtil(TreeNode root, int target, int newVal) {
        if (root == null) return;

        updateUtil(root.left, target, newVal);

        if (root.val == target) {
            count++;
            if (count == 2) {
                root.val = newVal;
                return;
            }
        }

        updateUtil(root.right, target, newVal);
    }

    // Q7: Generic Tree DFS Traversal
    public void dfsGenericTree(GNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        for (GNode child : root.children) {
            dfsGenericTree(child);
        }
    }
}
