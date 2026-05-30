/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root, sb);
        return sb.toString();
    }

    private void dfsSerialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("N,");
            return;
        }

        sb.append(node.val).append(",");
        dfsSerialize(node.left, sb);
        dfsSerialize(node.right, sb);
    }

    private int index;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        index = 0;
        return dfsDeserialize(values);
    }

    private TreeNode dfsDeserialize(String[] values) {
        if (index >= values.length || values[index].equals("N")) {
            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(values[index++]));

        node.left = dfsDeserialize(values);
        node.right = dfsDeserialize(values);

        return node;
    }
}