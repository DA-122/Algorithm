// ����2432. ������ʱ���Ա��
// ģ��

class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int max = logs[0][1];
        int result = logs[0][0];
        for(int i = 1 ; i < logs.length; i++){
            if(logs[i][1] - logs[i-1][1]>max){
                max = logs[i][1] - logs[i-1][1];
                result = logs[i][0];
            }else if(logs[i][1] - logs[i-1][1] == max){
                result = Math.min(result,logs[i][0]);
            }
        }
        return result;
    }
}