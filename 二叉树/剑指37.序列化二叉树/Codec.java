// 剑指37. 序列化二叉树
// 审题：不限定序列化、反序列化逻辑！！！ 只需要序列化后反序列化结果一致即可，也就是说编码方式自定
// 思路分析：按照数组二叉树方式编码
// 按照先序编码

import java.util.LinkedList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    
}

public class Codec {
    // 法1： 按照数组二叉树编码（超内存）
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)    
            return "[]";
        int depth = depth(root);
        TreeNode[] nodes = new TreeNode[(int)Math.pow(2,depth) - 1];
        nodes[0] = root;
        // 遍历树，并把节点加入到数组中
        for(int i = 0; i < nodes.length / 2; i++){
            if(nodes[i] == null){
                continue;
            }
            if(nodes[i].left !=null){
                nodes[i*2+1] = nodes[i].left;
            }
            if(nodes[i].right!=null){
                nodes[i*2+2] = nodes[i].right;
            }
        }
        StringBuffer buffer  = new StringBuffer();
        buffer.append("[");
        for(int i = 0; i < nodes.length; i++){
            if(nodes[i] == null){
                buffer.append("null,");
            }else{
                buffer.append(Integer.toString(nodes[i].val)).append(",");
            }
        }
        buffer.deleteCharAt(buffer.length()-1);
        buffer.append("]");
        return buffer.toString();
    }
    public int depth(TreeNode node){
        if(node == null){
            return 0;
        }
        int l = depth(node.left) + 1;
        int r = depth(node.right) + 1;
        return Math.max(l,r);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]"))
            return null;
        String[] nodes = data.substring(1,data.length()-1).split(",");
        int n = nodes.length;
        TreeNode[] tree = new TreeNode[nodes.length];
        for(int i = n - 1;i >= 0; i--){
            // 重建node
            if(nodes[i].equals("null")){
                tree[i] = null;
                continue;
            }else{
                tree[i] = new TreeNode(Integer.parseInt(nodes[i]));
            }
            int l = i*2+1;
            int r = i*2+2;
            if(l < n){
                tree[i].left = tree[l];
            }
            if(r < n){
                tree[i].right = tree[r];
            }
        } 
        return tree[0];
    }

    // 法2，先序遍历编码
    public String serialize2(TreeNode root) {
        if(root == null){
            return "[]";        
        }
        StringBuffer buffer = new StringBuffer("[");
        dfs(root,buffer);
        buffer.deleteCharAt(buffer.length()-1);
        buffer.append("]");
        return buffer.toString();
    }
    public void dfs(TreeNode node, StringBuffer buffer){
        if(node == null){
            buffer.append("null,");
            return;
        }
        //
        buffer.append(Integer.toString(node.val)).append(",");
        dfs(node.left,buffer);
        dfs(node.right,buffer);
    }

    public TreeNode deserialize2(String data) {
        if(data == "[]")
            return null;
        String[] dataArray = data.substring(1,data.length()-1).split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
        return rdeserialize(dataList);
    }
  
    public TreeNode rdeserialize(List<String> dataList) {
        if (dataList.get(0).equals("null")) {
            dataList.remove(0);
            return null;
        }
  
        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = rdeserialize(dataList);
        root.right = rdeserialize(dataList);
    
        return root;
    }



}