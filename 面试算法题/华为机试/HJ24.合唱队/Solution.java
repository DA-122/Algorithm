import java.util.Scanner;

// ˼·������ ��̬�滮
// ��Ҫ��������DP����
// ������������
// ���ݼ�������
// ʱ�临�Ӷ�O(n^2)
// �ռ临�Ӷ�O(n)

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int heights[] = new int[N + 2];
        for(int i = 1; i <= N ; i++ ){ // [1,n]��Χ�����������
            heights[i] = in.nextInt();
        }
        int dp1[] = new int[N+2]; // �洢ÿ��λ����������������г���
        int dp2[] = new int[N+2]; // �洢ÿ��λ���Ҳ������������г���
        for(int i = 1; i <= N; i++){
            for(int j = i - 1; j >=0; j--){
                if(heights[i] > heights[j]){
                    dp1[i] = Math.max(dp1[j] + 1, dp1[i]);
                }
            }
        }
        for(int i = N; i > 0; i--){
            for(int j = i + 1; j <= N+1; j++){
                if(heights[i] > heights[j]){
                    dp2[i] = Math.max(dp2[j] + 1,dp2[i]) ;
                }
            }
        }
        int res = 1;
        for(int i = 1; i <= N; i++){
            res = Math.max(dp1[i]+dp2[i]-1, res);
        }
        System.out.print(N - res);
    }
}