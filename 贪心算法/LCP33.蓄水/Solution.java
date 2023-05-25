// LCP33. ��ˮ
// ��Ŀ������Ӧ������ˮͰ����������ˮ����֮ǰ�������������Ч�棨����+����ˮ*�����Ӳ�ͬ��
// ˼·����������С�����������������Է�Ϊ����������ˮ��,����Ҫͳ����ˮ��
// Ȼ�����Ҫ�����ˮ����ˮͰ��ʼ��������ÿ�ζ�������ˮ�����������н�����õ���С������
// �����+����


public class Solution {
    public int storeWater(int[] bucket, int[] vat) {

        // ��¼������
        int num1 = 0;
        // ��¼�ܲ�����
        int total = 0;
        int result = Integer.MAX_VALUE;
        // ��Ѽ�¼��������
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
            // ���²�����
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

    // �ٽ�1-ö���ܲ�����
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
    // �ٽ�2-̰��+���ȶ���

    public int storeWater3(int[] bucket, int[] vat) {
        int n = bucket.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);
        // cnt��ʾ������
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (bucket[i] == 0 && vat[i] != 0) {
                ++cnt;
                ++bucket[i];
            }
            // ���vat[i] = 0���Ͳ��÷������ȶ����У����ô���
            if (vat[i] > 0) {
                pq.offer(new int[]{(vat[i] + bucket[i] - 1) / bucket[i], i});
            }
        }
        if (pq.isEmpty()) {
            return 0;
        }
        // �ܲ�����
        int res = Integer.MAX_VALUE;
        // ��������С���ܲ�����ʱ�����µ����������ڵ����ܲ�����ʱ����ʱ����ˮ����1����ⷨ1�߽����ƣ����Ǳ�����
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