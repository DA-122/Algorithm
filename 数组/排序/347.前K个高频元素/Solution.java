// 力扣347 前K个高频元素
// 思路分析: 哈希表统计频率，最大堆找前k
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;

public class Solution{
    // 优先队列
    public static int[] topKFrequent(int[] nums, int k) {
        int ans[] = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<int []> heap = new PriorityQueue<>((a,b)-> b[0]-a[0]);
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            heap.offer(new int[]{entry.getValue(),entry.getKey()});
        }
        for(int i = 0; i < k; i++){
            int []array = heap.poll();
            ans[i] = array[1];
        }
        return ans;

    }
    public static void main(String[] args){
        int nums[] = {1,1,1,2,2,3};
        int k = 2;
        topKFrequent(nums, k);
    }
}