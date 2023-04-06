import java.util.HashMap;
import java.util.Map;

class Solution {    
    static Map<TreeNode,Integer> f = new HashMap<TreeNode,Integer>();
    static Map<TreeNode,Integer> g = new HashMap<TreeNode,Integer>();
    public static int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root,0),g.getOrDefault(root,0));
    }

    public static void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        f.put(node,node.val+g.getOrDefault(node.left,0)+g.getOrDefault(node.right, 0));
        g.put(node,Math.max(f.getOrDefault(node.left,0),g.getOrDefault(node.left,0))
        +Math.max(f.getOrDefault(node.right,0),g.getOrDefault(node.right,0)));
 
    }

    public static int rob2(TreeNode root) {
        int result[] = dfs2(root);
        return Math.max(result[0],result[1]);
    }
    public static int[] dfs2(TreeNode node) {
        if (node == null) {
            return new int[]{0,0};
        }
        int[] l = dfs2(node.left);
        int[] r = dfs2(node.right);
        int selected = node.val + l[1]+r[1];
        int notSelected = Math.max(l[0],l[1]) + Math.max(r[0],r[1]);
        return new int[]{selected,notSelected};
    }
    public static void main(String[] args){
        Integer[] tree = {3,2,3,null ,3,null,1};
        TreeNode root = arrayToTreeRecursion(tree, 0);
        System.out.println(rob(root));
    }
    // µÝ¹é´´½¨¶þ²æÊ÷
    public static TreeNode arrayToTreeRecursion(Integer[] array, int index){
        if(index > array.length-1){
            return null;
        }
        if(array[index] == null){
            return null;
        }
        TreeNode node  = new TreeNode(array[index]);
        node.left = arrayToTreeRecursion(array, index*2+1);
        node.right = arrayToTreeRecursion(array, index*2+2);
        return node;
    }
}