// ����99: �ؽ�����������
// ��������������������ҳ��������������ڵ㣬�����ڵ�ֵ����
public class Solution{
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else{
                TreeNode node = stack.pop();
                list.add(node);
                cur = node.right;
            }
        }
        int index1 = -1 , index2 = -1;
        for(int i = 0; i < list.size() - 1; i++){
            if(list.get(i).val > list.get(i+1).val){
                index2 = i + 1;
                if(index1 == -1){
                    index1 = i;
                }else{
                    break;
                }
            }
        }
        int temp = list.get(index1).val;
        list.get(index1).val =  list.get(index2).val;
        list.get(index2).val = temp;
    }
}