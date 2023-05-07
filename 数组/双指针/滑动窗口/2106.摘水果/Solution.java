// ����2106.ժˮ��
// ˼·������ժˮ�����ƶ���Χ����Ϊһ����������
// 1.��startPosΪ�˵㣬��һ�������ƶ�������Ϊk
// 2.startPos���ڲ��㣬����һ�������ƶ���������һ�������ƶ�������Ϊ
// k = right - left + right - startPos
// k = right - left + startPos - left
// ����ʹ��ǰ׺��������Ԥ����

import javax.swing.plaf.nimbus.State;

public class Solution{
    public static int maxTotalFruits(int[][] fruits, int startPos, int k) {
        // posǰ׺����,��¼ˮ������
        int lastPos = fruits[fruits.length-1][0];
        int firstPos = fruits[0][0];
        int[] fruitsNum = new int[200001];
        int index = 0;
        if(firstPos == 0){
            fruitsNum[0] = fruits[0][1];
            index++;
        }
        for(int i = 1; i < fruitsNum.length&&index<fruits.length; i++){
            if(i == fruits[index][0]){
                fruitsNum[i] = fruitsNum[i-1] + fruits[index][1];
                index++;
            }else{
                fruitsNum[i] = fruitsNum[i-1];
            }
        }
        if(startPos - k >lastPos||startPos + k < firstPos){
            return 0;
        }
        int max = 0;
        for(int x = 0; x*2 <= k; x++){
            int y = k - 2 * x;
            int l1 = Math.max(startPos - x, 0);
            int r1 = Math.min(startPos + y, lastPos);
            int l2 = Math.max(startPos - y, 0); 
            int r2 = Math.min(startPos + x, lastPos);
            max =  l1 == 0? Math.max(fruitsNum[r1]-0,max): Math.max(fruitsNum[r1]-fruitsNum[l1-1],max);
            max =  l2 == 0? Math.max(fruitsNum[r2]-0,max): Math.max(fruitsNum[r2]-fruitsNum[l2-1],max);
        }
        return max;
    }
    public static void main(String[] args){
        int [][] fruits ={{0,9},{4,1},{5,7},{6,2},{7,4},{10,9}};
        int startPos = 5;
        int k = 4;
        maxTotalFruits(fruits,startPos,k);
    }
}