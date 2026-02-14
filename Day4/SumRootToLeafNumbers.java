
import java.util.*;
import java.util.LinkedList;

public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        TreeNode root = insert(s);
        int sum = sumRootToLeaf(root);
        System.out.println("Sum of root to leaf numbers: " + sum);
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

    static int sumRootToLeaf(TreeNode root) {
        return sumHelper(root, 0);
    }

    static int sumHelper(TreeNode root, int currentSum) {
        if (root == null) return 0;
        currentSum = currentSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return currentSum;
        }
        return sumHelper(root.left, currentSum) + sumHelper(root.right, currentSum);    
    }

}
