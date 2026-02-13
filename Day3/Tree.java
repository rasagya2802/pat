package Day3;
import java.util.*;

public class Tree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        TreeNode root = insert(s);
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();
        System.out.print("Postorder: ");
        postorder(root);
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

     static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    static void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

}
