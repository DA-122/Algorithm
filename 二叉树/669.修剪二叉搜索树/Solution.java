// ����669. �޼�����������
// ��Ŀ��������������������ĸ��ڵ� root ��ͬʱ������С�߽�low �����߽� high��ͨ���޼�������������ʹ�����нڵ��ֵ��[low, high]�С�
// �޼��� ��Ӧ�� �ı䱣�������е�Ԫ�ص���Խṹ (�������û�б��Ƴ���ԭ�еĸ����Ӵ���ϵ��Ӧ������)�� ����֤�������� Ψһ�Ĵ� ��
// ˼·������ �ݹ�ü����Һ���
public class Solution {
    int low = 0;
    int high = 0;
    public TreeNode trimBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high =high;
        TreeNode cur = root;
        // ��Ѱ�ҵ�һ�����ڵ㴦��low��high֮��
        while(cur!=null && (cur.val < low || cur.val > high)){
            if(cur.val < low){
                cur = cur.right;
            }
            if(cur.val > high){
                cur = cur.left;
            }
        }
        // ���cur = null ˵���Ҳ������ʵĸ�������null
        if(cur == null){
            return null;
        }
        
        // �ҵ����ʵĸ��ڵ�󣬷ֱ�ü����Һ���
        // ��ʱ low <= cur <= high �������������
        // ����cur.left��˵��һ������ cur.left < high ���޷�����cur.left > low
        // ����cur.right��˵��һ������cur.right > low ���޷�����cur.right < high
        cur.left = trimLeft(cur.left);
        cur.right = trimRight(cur.right);
        return cur;

    }
    // �ü�������
    public TreeNode trimRight(TreeNode cur){
        if(cur == null){
            return null;
        }
        // ��high��Ҫ��������
        if(cur.val > high){
            return trimRight(cur.left);
        }else{
            cur.right = trimRight(cur.right);
            return cur;
        }
    }
    // �ü�������
    public TreeNode trimLeft(TreeNode cur){
        if(cur == null){
            return null;
        }
        // ��lowС,Ҫ��������
        if(cur.val < low){
            return trimLeft(cur.right);
        }else{
            cur.left = trimLeft(cur.left);
            return cur;
        }
    }

    // �����ݹ�
    public TreeNode trimBSTSimple(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        } else if (root.val > high) {
            return trimBST(root.left, low, high);
        } else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }
    


}