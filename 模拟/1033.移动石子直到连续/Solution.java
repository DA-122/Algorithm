// ����1033 �ƶ�ʯ��ֱ������
// ģ��
import java.util.Arrays;

public class Solution{
    public int[] numMovesStones(int a, int b, int c) {
        int stones[] = new int[3];
        stones[0] = a; 
        stones[1] = b;
        stones[2] = c;
        Arrays.sort(stones);
        int ans[]  = new int[2];
        // ���ܺ����󣬼���stones[2]��stones[0]��k����λ������ȫ�������������
        ans[1] = stones[2]-stones[0]-2;
        // ��С���������
        if((stones[2]==stones[1]+1)&&(stones[1] == stones[0]+1)){
            ans[0] = 0;
        }else if(stones[2] - stones[1] <= 2 || stones[1] - stones[0] <=2 ){
            ans[0] = 1;
        }else{
            ans[0] = 2;
        }
        return ans;
    }
}