// ����1040 �ƶ�ʯ��ֱ��������(VERY HARD)
// ��Ŀ��������һ������ ���� �������ϣ��� i ��ʯ�ӵ�λ��Ϊ stones[i]�����һ��ʯ�ӵ�λ����С/�����ô��ʯ�ӱ����� �˵�ʯ�� ��
// ÿ���غϣ�����Խ�һ�� �˵�ʯ�� �����ƶ���һ��δռ�õ�λ�ã�ʹ�ø�ʯ�� ���� ��һ�Ŷ˵�ʯ�ӡ�
// �����޷������κ��ƶ�ʱ��������Щʯ�ӵ�λ������ʱ����Ϸ������Ҫʹ��Ϸ�����������ִ�е���С������ƶ������ֱ��Ƕ��٣� �Գ���Ϊ 2 ��������ʽ���ش𰸣�
public class Solution{
    public int[] numMovesStonesII(int[] stones) {
        int n = stones.length;
        Arrays.sort(stones);
        if (stones[n-1] - stones[0] + 1 == n) {
            return new int[]{0, 0};
        }
        int[] ans = new int[2];
        int mi = n;
        //��i��jΪ˫ָ��
        for (int i = 0, j = 0; i < n && j + 1 < n; ++i) {
            //�����ƶ�jʹ��i��j֮��������n��i��j֮������������ʯ��
            while (j + 1 < n && stones[j + 1] - stones[i] + 1 <= n) {
                ++j;
            }
            //����[1,2,3,4,x(x>5)],j=3,i=0,�ҵ���һ��ʯ���⣬����ʯ���������Ĵ��ڣ�������ƶ����ξ���,1->6,x->5;
            //�����[1,2,3,4,6]��Сֻ��Ҫһ�Σ���ô����i=1ʱ��j=4ʱ����minΪ 5-��4-1+1��=1;
            if (j - i + 1 == n - 1 && stones[j] - stones[i] + 1 == n - 1) {
                mi = Math.min(mi, 2);
            } else {
                //������������������
                mi = Math.min(mi, n - (j - i + 1));
            }
        }
        ans[1] = Math.max(stones[n-1]-stones[1]+2-n,stones[n-2]-stones[0]+2-n);
        ans[0] = mi;
        return ans;
    }   
    public static void main(String[] args){

    }
}