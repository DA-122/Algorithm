// 1072.���з�ת�õ������ֵ������
// ˼·��������ϣ�������Ļ���|����������
// ֻ�ܱ䶯��ֵ����ֵ���ֻ���ǻ���������ȵ����
import java.util.HashSet;
import java.util.Set;

public class Solution{
    public static int maxEqualRowsAfterFlips(int[][] matrix) {
        int result = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        Set<Integer> set =new HashSet<>();
        for(int i = 0; i < n; i++){
            int cnt = 1;
            if(set.contains(i)){
                continue;
            }else{
                set.add(i);
            }
            for(int j = i+1; j < n; j++){
                if(set.contains(j)){
                    continue;
                }
                // �жϻ���
                int k = 0;
                while( k < m){
                    if(matrix[i][k] == matrix[j][k]){
                        break;
                    }
                    k++;
                }
                if(k == m){
                    set.add(j);
                    cnt++;
                }
                k = 0;
                // �ж����
                while( k < m){
                    if(matrix[i][k] != matrix[j][k]){
                        break;
                    }
                    k++;
                }
                if(k == m){
                    set.add(j);
                    cnt++;
                }
            }
            result = Math.max(cnt,result);
        }
        return result;
    }

    public static void main(String[] args){
        int matrix[][] = {{0,1},{1,1}};
        maxEqualRowsAfterFlips(matrix);
    }
}