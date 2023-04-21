// ����283. �ƶ���
// ˼·�� ˫ָ��
public class Solution{
    // ���α�������һ�α����ҵ���0Ԫ�أ��������η��õ�������࣬����ʣ�ಿ�����0
    public void moveZeroes(int[] nums) {
        if(nums == null)
            return;
        // ��¼����Ԫ�ظ���
        int j = 0;
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i]!=0){
                // ����Ԫ�ط��õ��������
                nums[j++] = nums[i];
            }
        }
        // ʣ�����������
        for(int i = j; j < nums.length; i++){
            nums[i] = 0;
        }
    }
    // ����˼��,���ҵ���һ��0��Ȼ��ӵ�һ��0��ʼ������з�0Ԫ�ؾͺ͵�һ��0����
    public void moveZeroes2(int[] nums) {
        if(nums == null)
            return;
 		//����ָ��i��j
        int j = 0;
        for(int i=0;i<nums.length;i++) {
            // j �൱����ָ��Ϊ0��Ԫ��
            if(nums[i]!=0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }
}