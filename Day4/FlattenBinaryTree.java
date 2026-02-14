package Day4;

import java.util.*;
public class FlattenBinaryTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        TreeNode root = insert(s);
        flatten(root);
        // Print the flattened tree
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.right;
        }
    }

       
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public static TreeNode insert(String[] s) {
        if (s == null || s.length == 0 || s[0].equals("null")) return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < s.length) {
            TreeNode node = queue.poll();
            if (i < s.length && !s[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(s[i]));
                queue.offer(node.left);
            }
            i++;
            if(i>= s.length) break;
            if (i < s.length && !s[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(s[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
     }

    static void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode tempRight = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        current.right = tempRight;

    }
}
