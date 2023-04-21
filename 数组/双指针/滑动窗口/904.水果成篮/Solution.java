// ����904 ˮ������
// ˼·��������������

public class Solution{
    public static int totalFruit(int[] fruits) {
        // left rightָ��ǰ����ˮ��
        int left = 0;
        int right = left;
        int max = 0;
        while(right <fruits.length && fruits[right] == fruits[left]){
            right++;
        }
        if(right == fruits.length){
            return fruits.length;
        }
        // pivot Ѱ����һ�ֲ�ͬ��ˮ��
        int pivot = right+1;
        // leftL �� rightL��������ˮ�����һ�γ��ֵ�λ��
        int leftL = right-1;
        int rightL = right;
    
        while(right < fruits.length){
            while(pivot < fruits.length){
                if(fruits[pivot] == fruits[left]){
                    leftL = pivot;
                }else if(fruits[pivot] == fruits[right]){
                    rightL = pivot;
                }else{
                    break;
                }
                pivot++;
            }
            max = Math.max(pivot - left, max);
            right = pivot;
            pivot = right+1;
            // �µ����ˮ������һ���Ҳ�ˮ��
            left = Math.min(leftL, rightL)+1;
            // ��������ˮ����һ�γ��ֵ����λ�ã�һ����ǰ���ϵ��
            leftL = right -1;
            rightL = right;
        }
        return max;
    }
    public static void main(String[] args){
        int[] fruits ={1,0,3,4,3};
        System.out.println(totalFruit(fruits));
    }
}