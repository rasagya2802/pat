package Day4;

import java.util.*;
import java.util.LinkedList;

public class TreeZigZag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        TreeNode root = insert(s);
        zigzag(root);
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

    static void zigzag(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) level.add(node.val);
                else level.add(0, node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            leftToRight = !leftToRight;
            System.out.print(level + " ");
        }

    }

}
