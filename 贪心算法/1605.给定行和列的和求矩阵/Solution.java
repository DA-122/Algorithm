class Solution {
    // �������д����ÿ��Ԫ�رȽ�rowSum��ColSum��С��ѡ��С�Ľ�����䣬���ı�rowSum��colSum����
    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][]ans = new int[rowSum.length][colSum.length];
        for(int i = 0; i < rowSum.length; i++){
            for(int j = 0; j < colSum.length; j++){
                if(colSum[j] < rowSum[i]){
                    ans[i][j] = colSum[j];
                    rowSum[i] = rowSum[i]-colSum[j];
                    colSum[j] = 0;
                }else{
                    ans[i][j] = rowSum[i];
                    colSum[j] = colSum[j] - rowSum[i];
                    rowSum[i] = 0;
                }
            }
        }
        return ans;
    }
    // �Ż� ʱ�临�Ӷ�O(m+n)
    // ���colSum<rowSum����ͬ���·�Ԫ��ȫΪ0����֮��Ȼ��
    public static int[][] restoreMatrix2(int[] rowSum, int[] colSum) {
        int[][]ans = new int[rowSum.length][colSum.length];
        int k = 0;
        for(int i = 0; i < rowSum.length; i++){
            for(int j = k; j < colSum.length; j++){
                if(colSum[j] < rowSum[i]){
                    ans[i][j] = colSum[j];
                    rowSum[i] = rowSum[i]-colSum[j];
                    colSum[j] = 0;
                    k++;
                }else{
                    ans[i][j] = rowSum[i];
                    colSum[j] = colSum[j] - rowSum[i];
                    rowSum[i] = 0;
                    break;

                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[] rowSum = {3,8};
        int[] colSum = {4,7};
        int [][] ans = restoreMatrix2(rowSum, colSum);
        for(int i = 0; i < rowSum.length; i++ ){
            for(int j = 0; j < colSum.length; j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
}