import java.util.*;
public class TreeDiameter {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String[] s = sc.nextLine().split(" ");
            TreeNode root = insert(s);
            int diameter = treeDiameter(root);
            System.out.println("Diameter of the tree: " + diameter);
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

     static int treeDiameter(TreeNode root) {
         int[] diameter = new int[1];
         depth(root, diameter);
         return diameter[0];
     }

     static int depth(TreeNode root, int[] diameter) {
         if (root == null) return -1;
         int leftDepth = depth(root.left, diameter);
         int rightDepth = depth(root.right, diameter);
         diameter[0] = Math.max(diameter[0], leftDepth + rightDepth + 2);
         return Math.max(leftDepth, rightDepth) + 1;
     }
}
