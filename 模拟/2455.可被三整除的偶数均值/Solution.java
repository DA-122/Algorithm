// ����2455. �ɱ�3������ż����ֵ
// ˼·��������6���������ľ�ֵ������

public class Solution {
    public int averageValue(int[] nums) {
        int result = 0;
        int total = 0;
        for(int num: nums){
            if(num % 6 ==0){
                result+=num;
                total +=1;
            }
        }
        return total == 0? total:result/total;
    }
}
