// ��ָoffer04�� ��ά�����д����ҷǵݼ����д��ϵ��·ǵݼ�
// ˼·�������������ά������ʱ����ת45�ȣ���ô�����(0,m-1)��Ԫ��Ϊ���ڵ�͹�����һ�Ŷ���������
// ʱ�临�Ӷȣ� O(logN)
public class Solution {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length-1;
        int m = matrix[0].length-1;
        if(target > matrix[n][m]|| target<matrix[0][0]){
            return false;
        }
        return binarySearch(matrix,target,0,n,0,m);
    }
    public static boolean binarySearch(int[][] matrix, int target,int startN,int endN, int startM, int endM){
        int midN = (startN+endN)/2;
        int midM = (startM+endM)/2;
        if(midN == startN && midM==startM){
            for(int i = 0; i < endM; i++){
                if(matrix[endN][i] == target)
                    return true;
            }
            for(int j = 0; j < endN; j++){
                if(matrix[j][endM] == target){
                    return true;
                }
            }
        }else{
            if(target > matrix[midN][midN]){
                return binarySearch(matrix,target,midN,endN,midM,endM);
            }else if (target < matrix[midN][midM]){
                return binarySearch(matrix,target,startN,midN,startM,midM);
            }else{
                return true;
            }
        }
        return false;
    }    
    public static void main(String []args){
        int[][] nums = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;
        System.out.println(findNumberIn2DArray(nums, target));
    }
}