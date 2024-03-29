package fmt.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<>();

        if (root == null) return wrapList;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size(); // ps
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode cur = queue.poll();
                subList.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }

    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelHelper(res, root, 0);
        return res;
    }

    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<>()); // add new []
        }
        res.get(height).add(root.val); // preorder here. actually in pre post all works
        levelHelper(res, root.left, height + 1);
        levelHelper(res, root.right, height + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);

        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(3);

        BinaryTreeLevelOrderTraversal level = new BinaryTreeLevelOrderTraversal();
        System.out.println(level.levelOrderBFS(root));
        System.out.println(level.levelOrderDFS(root));

    }

}
