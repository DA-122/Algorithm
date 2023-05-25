// LCP33. 蓄水
// 题目分析：应将升级水桶操作放在蓄水操作之前，这样才能最大化效益（升级+，蓄水*，算子不同）
// 思路分析：求最小操作数，操作数可以分为升级数和蓄水数,首先要统计蓄水数
// 然后从需要最大蓄水数的水桶开始升级，并每次都更新蓄水数，遍历所有结果，得到最小操作数
// 大根堆+遍历


public class Solution {
    public int storeWater(int[] bucket, int[] vat) {

        // 记录升级数
        int num1 = 0;
        // 记录总操作数
        int total = 0;
        int result = Integer.MAX_VALUE;
        // 大堆记录操作数量
        PriorityQueue<int []> heap = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        for(int i = 0; i < bucket.length; i++){
            int op = 0;
            if(bucket[i] == 0){
                if (vat[i] == 0){
                    op = 0;
                }else{
                    op = Integer.MAX_VALUE-100;
                }
            }else{
                op = (int)Math.ceil((double)vat[i] / bucket[i]);
            }
            heap.offer(new int[]{i,op});
        }
        int[] op = heap.poll();
        total = num1 + op[1];
        result = Math.min(result,total);
        if(total == 0){
            return 0;
        }
        while(op[1] > 1){
            // 更新操作数
            int i = op[0];
            bucket[i]++;
            num1++;
            op[1] = (int)Math.ceil((double)vat[i] / bucket[i]);
            heap.offer(op);
            op = heap.poll();
            total = num1 + op[1];
            result = Math.min(result,total);
        }
        return result;
    }

    // 官解1-枚举总操作数
    public int storeWater2(int[] bucket, int[] vat) {
        int n = bucket.length;
        int maxk = Arrays.stream(vat).max().getAsInt();
        if (maxk == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int k = 1; k <= maxk && k < res; ++k) {
            int t = 0;
            for (int i = 0; i < bucket.length; ++i) {
                t += Math.max(0, (vat[i] + k - 1) / k - bucket[i]);
            }
            res = Math.min(res, t + k);
        }
        return res;
    }
    // 官解2-贪心+优先队列

    public int storeWater3(int[] bucket, int[] vat) {
        int n = bucket.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);
        // cnt表示升级数
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (bucket[i] == 0 && vat[i] != 0) {
                ++cnt;
                ++bucket[i];
            }
            // 如果vat[i] = 0，就不用放入优先队列中（不用处理）
            if (vat[i] > 0) {
                pq.offer(new int[]{(vat[i] + bucket[i] - 1) / bucket[i], i});
            }
        }
        if (pq.isEmpty()) {
            return 0;
        }
        // 总操作数
        int res = Integer.MAX_VALUE;
        // 当升级数小于总操作数时（当新的升级数大于等于总操作数时，此时的蓄水数是1，与解法1边界相似，都是遍历）
        while (cnt < res) {
            int[] arr = pq.poll();
            int v = arr[0], i = arr[1];
            res = Math.min(res, cnt + v);
            if (v == 1) {
                break;
            }
            int t = (vat[i] + v - 2) / (v - 1);
            cnt += t - bucket[i];
            bucket[i] = t;
            pq.offer(new int[]{(vat[i] + bucket[i] - 1) / bucket[i], i});
        }
        return res;
    }

}