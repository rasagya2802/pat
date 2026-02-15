// package Day5_P2;

//leetcode 700
//leetcode 653
//leetcode 530
//leetcode 230
import java.util.*;
public class BST {

    static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
            int val = sc.nextInt();
            root = insert(root, val);
        }
        System.out.print("Inorder Traversal: ");
        inorder(root);
        System.out.print("\nPreorder Traversal: ");
        preorder(root);
        System.out.print("\nPostorder Traversal: ");
        postorder(root);

    }
    static TreeNode root;
    static TreeNode insert(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(val < root.val) root.left = insert(root.left, val);
        else if(val > root.val) root.right = insert(root.right, val);
        return root;
    }

    static void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    static void preorder(TreeNode root) {
        if(root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    static void postorder(TreeNode root) {
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }
}
