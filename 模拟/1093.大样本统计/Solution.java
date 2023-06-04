// 1093.������ͳ��
// ˼·������ ģ�⣨ע���ֹԽ��)

public class Solution {
    public double[] sampleStats(int[] count) {
        double ans[] = new double[5];
        int max = 0;
        int cnt = 0; 
        int minimum  = 0;
        int maximum  = count.length - 1; 
        while(count[minimum] == 0){
            minimum++;
        }
        while(count[maximum] == 0){
            maximum--;
        }
        int last = minimum;
        ans[0] = minimum;
        ans[1] = maximum;
        boolean isEven = false;
        int mid = 0;
        int total = 0;
        for(int i = minimum; i <= maximum; i++){
            total += count[i];
        }
        if(total % 2 == 0){
            mid = total / 2 ;
        }else{
            mid = total / 2 + 1;
        }

        for(int i = minimum; i <= maximum; i++){
            if(count[i] != 0){
                if(isEven){
                    ans[3] = (double)(i + last) / 2;
                    isEven = false;
                }
                // �ҵ���λ�����ڵ�����
                if(cnt  < mid && cnt + count[i] >= mid){
                    // ����
                    ans[3] = i;
                    if(total % 2 == 0 && cnt + count[i] == mid){
                        isEven = true;
                    }
                }
                last = i;
                // ����ƽ����
                ans[2] = ( ans[2] * cnt + i * count[i] ) /  (cnt+count[i]);
                cnt+= count[i];
                // ��������
                if(count[i] > max){
                    max = count[i];
                    ans[4] = i;
                }
            }
        }
        return ans;
    }
}