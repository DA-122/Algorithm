// 1054.距离相等的条形码
// 思路分析：1. 原思路：排序后隔空插数，用例54/58 {2,2,1,3}没过。
// 问题： 应该按照频率排序而不是数值大小排序，排序之后隔空差数即可
// 2. 大根堆解法

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution{
    // 大根堆解法
    public static int[] rearrangeBarcodes2(int[] barcodes) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: barcodes){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        // 构建一个最大堆
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new int[]{entry.getValue(), entry.getKey()});
        }
        int n = barcodes.length;
        int ans[] = new int[n];
        for(int i = 0; i < n; i++){
            int[] fre = pq.poll();
            if(i == 0 || ans[i-1] != fre[1]){
                ans[i] = fre[1];
                if(--fre[0]>0){
                    pq.offer(fre);
                }
            }else{
                int [] fre2 = pq.poll();
                ans[i] = fre2[1];
                if(--fre2[0] > 0){
                    pq.offer(fre2);
                }
                pq.offer(fre);
            }
        }
        return ans;
    }
    public static int[] rearrangeBarcodes1(int[] barcodes) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: barcodes){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new int[]{entry.getValue(), entry.getKey()});
        }
        int n = barcodes.length;
        int ans[] = new int[n];
        int array[] = pq.poll();
        for(int i = 0; i < n;){
            while(i < n){
                ans[i] = array[1];
                i+=2;
                if(--array[0] ==0){
                    array = pq.poll();
                }
            }
        }
        for(int i = 1; i < n ;){
            while(i < n && array[0] > 0){
                ans[i] = array[1];
                i+=2;
                array[0]--;
            }
            array = pq.poll();
        }
        return ans;
    }
    public static void main(String[] args){
        int barcodes[] = {7,7,7,7,5,5,5,8,8};
        rearrangeBarcodes2(barcodes);
    }
}