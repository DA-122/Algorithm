// ����1015.�ɱ�K��������С����
// ��Ŀ����:Ҫ���ҳ�������С�Ľ�����1�����ܱ�K������������
// ˼·������ģ����+��ϣ��
// ��Ӧ˼���������㣬��Ϊ����Ĵ𰸲�����64λ����������˿��ܻ��г�����������ģ���� ���������ܻᳬ��
// n % k == 0 ��ɱ�����,��������ʱ������n����
// (n*10+1) % k = ((n % k)*10 + 1) % k
// �����Ϳ����õ���һ������Ľ��
// �����������ظ�ʱ��˵����Զ�޷��ҵ�������

import java.util.HashSet;
import java.util.Set;

public class Solution{
    
    public static int smallestRepunitDivByK(int k) {
        // ż����֦
        if(k % 2 == 0){
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        int resid = 1%k;
        int len = 1;
        while(!(set.contains(resid) || resid == 0)){
            set.add(resid);
            resid = (resid *10 +1)%k;
            len++;
        }
        return resid == 0? len:-1;

    }
    public static void main(String[] args){
        int k = 3;
        smallestRepunitDivByK(k);
    }
}