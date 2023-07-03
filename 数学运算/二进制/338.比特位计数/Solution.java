// 338.����λ����

// 1. �൱��10������ת2���� ʱ��O(nlogn) 
// 2. ��̬�滮 �������� res[i] = res[i-1] + 1 //���λΪ1��һ����ǰ���ż����һλ
// ����ż��res[i] = res[i/2] ��λ 1��λ������
// ʱ�临�Ӷ� O(N)
public class Solution{    
    public int[] countBits(int n) {
        int res [] = new int[n + 1];
        for(int i = 0; i <= n; i++){
            int num = i;
            while(num!=0){
                if(num % 2 == 1){
                    res[i]++;
                }
                num = num / 2;
            }
        }
        return res;
    }
    public int[] countBits2(int n){
        int res [] = new int[n + 1];
        for(int i = 0; i <= n; i++){
            if(i % 2  == 1){
                res[i] = res[i - 1] + 1;
            }else{
                res[i] = res[i / 2];
            }
        }
        return res;

    }
}