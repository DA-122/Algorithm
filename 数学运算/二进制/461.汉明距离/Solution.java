// ����461. ��������
// ˼·������ ���ͬ0����ͬ1
// �����ж�ÿһλ
class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;
        int mid = x^y;
        for(int i = 0; i < 32; i++){
            if((mid & 1) == 1){
                res++;
            }
            mid = mid>>1;
        }
        return res;
    }
}