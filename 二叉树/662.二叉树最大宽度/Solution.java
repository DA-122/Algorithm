 // BFS «Û…Ó∂»
public class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int max =0;
        Deque<Pair<TreeNode,Integer>> queue = new ArrayDeque<>();
        queue.offer(new Pair(root,1));
        while(!queue.isEmpty()){
            int left = queue.peekFirst().getValue();
            int right = queue.peekLast().getValue();
            max = Math.max(right - left+ 1,max);

            int size = queue.size();
            for(int i = 0; i < size; i++){
                Pair<TreeNode,Integer> pair = queue.poll();
                TreeNode node = pair.getKey();
                int index = pair.getValue();
                if(node.left != null){
                    queue.offer(new Pair(node.left, index*2-1));
                }
                if(node.right != null){
                    queue.offer(new Pair(node.right, index*2));
                }
            }
        }
        return max;
    }
}