import java.util.Scanner;

// ��̬�滮
// 0-1��������
// ״̬ת�� dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1])

// �����и����� ����/ ����1+���� / ����2 + ���� /����+����1+����2
// ����ת��Ϊʲô��? ֻ���������������Ĳ�ͬ����



public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // ����10��С���Ӷ�
        int N = in.nextInt() / 10 ; // ��Ǯ����������
        int m = in.nextInt(); // ��Ʒ����
        // int items[][] = new int[m+1][3];
        int weights[][] = new int[m + 1][4]; // Ǯ
        int values[][] = new int[m + 1][4]; // �����
        // ע�� hasNext �� hasNextLine ������
        for (int i = 1; i <= m; i++) { // ע�� while ������ case
            int p = in.nextInt() / 10; // �۸�
            int s = in.nextInt() * p; // �����
            int index = in.nextInt();
            // ����
            if (index == 0) {
                weights[i][0] = p;
                values[i][0] = s;
            } else if (weights[index][1] == 0) {
                // ����1
                weights[index][1] = p;
                values[index][1] = s;
            } else {
                // ����2
                weights[index][2] = p;
                values[index][2] = s;
            }
            in.nextLine();
        }

        for(int i = 1; i < m+1; i++){
            // ���������
            if(weights[i][0]!=0){
                weights[i][3] = weights[i][0] + weights[i][1] + weights[i][2];
                weights[i][1] += weights[i][0];
                weights[i][2] += weights[i][0];
                values[i][3] = values[i][0] + values[i][1] + values[i][2];
                values[i][1] += values[i][0];
                values[i][2] += values[i][0];
            } 
        }
        int dp[][] = new int[m + 1][N + 1];
        for (int i = 1; i <= m ; i++) {
            for (int j = 0; j <= N; j++) {
                // ����
                if (weights[i][0] != 0) {
                    // ��������
                    dp[i][j] = dp[i-1][j];
                    for (int k = 0; k < 4 && weights[i][0] != 0; k++) {
                        if (j - weights[i][k] >= 0) {
                            dp[i][j] = Math.max(dp[i - 1][j - weights[i][k]] + values[i][k], dp[i][j]);
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        System.out.print(dp[m][N]*10);
    }
}