// ��ָ64 ��1+2+��+n
// �� 1+2+...+n ��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
// ˼·�������ݹ� ���� ѭ��

public class Solution {
    public int sumNums(int n) {
        return n == 0? 0: sumNums(n-1)+n; 
    }
}
