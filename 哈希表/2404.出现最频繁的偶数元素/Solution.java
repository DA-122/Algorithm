// 力扣2404 出现最频繁的偶数元素
// 思路分析： 哈希表存储出现频率，然后遍历哈希表，找频率最高的最小元素
import java.util.HashMap;
import java.util.Map;

public class Solution{
    public static int mostFrequentEven(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i]%2 == 0){
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }
        int res = -1;
        int cnt = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()>cnt || entry.getKey()<res&& cnt == entry.getValue()){
                res = entry.getKey();
                cnt = entry.getValue();
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums = {0,1,2,2,4,4,1};
        System.out.println(mostFrequentEven(nums));
    }
}