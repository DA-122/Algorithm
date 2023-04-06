// ����1630. �Ȳ�������
// ˼·������ ģ�ⷨ
// 1. ֱ�Ӹ�����������Ȼ��ȽϹ���
// 2. �����������ֵ��Сֵ���ù�ϣ���ж�Ԫ���Ƿ���Ϲ���
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for(int i = 0; i < l.length; i++){
            int left = l[i];
            int right = r[i];
            boolean result =true;
            ArrayList<Integer> list  = new ArrayList<>();
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < right-left+1;j++){
                list.add(nums[left+j]);
                max = Math.max(list.get(j),max);
                min = Math.min(list.get(j),min);
            }
            if((max-min)%(list.size()-1)!=0){
                ans.add(false);
                continue;
            }
            int difference = (max - min)/(list.size()-1);
            for(int j = 1; j < list.size(); j++){
                if(!list.contains(min+difference*j)){
                    result = false;
                    break;
                }
            }
            ans.add(result);
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums = {4,6,5,9,3,7};
        int[] l = {0,0,2};
        int[] r = {2,3,5};
        System.out.println(checkArithmeticSubarrays(nums, l, r) );
    }
}