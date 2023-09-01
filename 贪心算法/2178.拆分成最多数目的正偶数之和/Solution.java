// 2178. ��ֳ������Ŀ����ż��֮��
// ˼·������ ̰���㷨
// ��֤��֤��̰�ķ�������ȷ�ġ�
// �����ǵķ����ҵ���һ����2 + 4 + ... + 2n + k = finalsum���������Էֳ�n + 1������ ����k���ɼ������֣�����ζ��2n < k < (2n + 2) + (2n + 4) = 4n + 6��
// ���費ʹ��2~2n�е�ĳ����2x֮�󣬿��Խ�finalsum�ֳɸ����ż��������ζ�� k + 2x���Էֳ�3������2n������ ��k + 2x >= (2n + 2) + (2n + 4) + (2n + 6) = 6n + 12����k + 2x >= 6n + 12��
// ����k < 4n + 6����2x <= 2n������k + 2x < 6n + 6���������ì�ܣ�����������������2x

class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if(finalSum % 2 != 0){
            return res;
        }
        long even = 2;
        while(finalSum - even >= 0){
            res.add(even);
            finalSum -= even;
            even += 2;
        }

        long last = res.get(res.size() - 1);
        res.set(res.size() - 1, finalSum + last) ;
        return res; 
    }
}