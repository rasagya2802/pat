
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        TreeNode root = insert(s);
        System.out.print("Right side view: ");
        rightSideView(root);
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

    //with iteration
    public static void rightSideView(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) System.out.print(node.val + " ");
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
    }

    //with recursion 
    public static void rightSideViewRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSideViewHelper(root, result, 0);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    private static void rightSideViewHelper(TreeNode root, List<Integer> result, int depth) {
        if (root == null) return;
        if (depth == result.size()) {
            result.add(root.val);
        }
        rightSideViewHelper(root.right, result, depth + 1);
        rightSideViewHelper(root.left, result, depth + 1);
    }


}
