// ����1574. ɾ����̵�������ʹʣ����������
// ˼·������ Ҫ��ɾ��һ��������������飬ʹ��ʣ������Ԫ�طǵݼ�
// ������ɾ�����������ʣ�������Ԫ�ؿ϶�������һ�������һ��Ԫ�أ������Ҫ���������ͷ�����һ��Ԫ�ص����������飬�������������
// 1 ɾ����ͷһ�� ans = right;
// 2 ɾ��ĩβһ�� ans = arr.length-left-1
// 3 ɾ���м�һ�� ����right���̶�right(i)������left(j)��ɾ���ĳ���Ϊ i-j-1
public class Solution {
    public static int findLengthOfShortestSubarray(int[] arr) {
        int ans = arr.length-1;
        int left = 0;
        int right = arr.length-1;
        // ��ͷһ��
        for(int i = 1; i < arr.length; i++){
            if(arr[i] >= arr[i-1]){
                left = i;
            }else{
                break;
            }
        }
        if(left == arr.length-1){
            return 0;
        }
        // ĩβһ��
        for(int i = right-1; i>0; i--){
            if(arr[i] <= arr[i+1]){
                right =  i;
            }else{
                break;
            }
        }
        // ֻ��ĩβһ��
        ans = Math.min(right,ans);
        // ֻ����ͷһ��
        ans = Math.min(ans, arr.length-left-1);
        // �м�һ��
        for(int i = right; i < arr.length; i++){
            for(int j = left; j >= 0; j--){
                if(arr[i] >= arr[j]){
                    ans = Math.min(ans,i-j-1);
                    break;
                }
            }
        }
        return ans;
    }
    public static void main(String [] args){
        int[] arr = {1,2,3,10,0,7,8,9};
        System.out.println(findLengthOfShortestSubarray(arr));
    }
}