// ����342. ���������������ֵ
// ˼·����������+��ϣ��
// ע������xС���ظ�Ԫ��ҲҪ����

import java.util.TreeMap;

public class Solution{
    //! ��ʱ����
    // ��������+��ϣ��O(U(n-k))  U = 50
    public static int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int result [] = new int[nums.length-k+1];
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i = 0; i < k; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int counter = 0;
        for(int key : map.keySet()){
            counter+=map.get(key);
            if(counter >= x){
                result[0] = key < 0 ? key : 0;
                break;
            }
        }
        for(int i = 1; i < nums.length-k+1; i++){
            map.put(nums[i-1],map.get(nums[i-1])-1);
            map.put(nums[i+k-1],map.getOrDefault(nums[i+k-1],0)+1);
            counter = 0;
            for(int key : map.keySet()){
                if(map.get(key) !=0)
                    counter+=map.get(key);
                if(counter >= x){
                    result[i] = key < 0 ? key : 0;
                    break;
                }
            }
        }
        return result;
    }
    // �ó���Ϊ50����������ʾ��ϣ��
    public int[] getSubarrayBeauty2(int[] nums, int k, int x) {
        int range = 50;
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int[] cnt = new int[range * 2 + 1];
        for (int i = 0; i < k - 1; ++i) // ������������� k-1 ����(��-50�����ƶ�50)
            cnt[nums[i] + range]++;
        for (int i = k - 1; i < n; ++i) {
            cnt[nums[i] + range]++; // ���һ�����ֽ��봰�ڣ���֤������ǡ�� k ������
            int counter = 0;
            for (int j = 0; j < range; ++j) { // ����ö�ٸ�����Χ [-50,-1]
                counter += cnt[j];
                if (counter >= 0) { // �ҵ�����ֵ
                    ans[i - k + 1] = j - range;
                    break;
                }
            }
            cnt[nums[i - k + 1] + range]--; // ���ڵ�һ�������뿪
        }
        return ans;
    }

    public static void main(String[] args){
        int nums[] = {-1,-2,-3,-4,-5};
        getSubarrayBeauty(nums, 2, 2);
    }
}

