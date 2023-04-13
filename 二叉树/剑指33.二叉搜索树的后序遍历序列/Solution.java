// ����������,����С�ڸ����Һ��Ӵ��ڸ�

// ������� ������ һ���ǵ���
// ������� ������
// �ݹ�鿴�������Ƿ�����ڸ��ڵ�
// ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(n)
public class Solution{
    public static boolean verifyPostorder(int[] postorder) {
        return isPostOrder(postorder,0,postorder.length-1);
    }
    // end��root
    public static boolean isPostOrder(int[]postorder, int start, int end){
        if(start >= end)
            return true; 
        int root = postorder[end];
        int rStart = end; 
        // �ҵ�������
        for(int i = start; i < end; i++){
            if(postorder[i] > root){
                rStart = i;
                break;
            }
        }
        // ����������ȫ�����ڸ��ڵ�
        for(int i = rStart; i < end; i++){
            if(postorder[i] < root){
                return false;
            }
        }
        return isPostOrder(postorder,start,rStart-1)&&isPostOrder(postorder,rStart,end-1);
    }
    public static void main(String[] args){
        int [] postorder = {1,6,3,2,5};
        System.out.println(verifyPostorder(postorder));
    }
}