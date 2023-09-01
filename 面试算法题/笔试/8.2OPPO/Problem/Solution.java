import java.util.Scanner;

// ע����������Ϊ Main, ��Ҫ���κ� package xxx ��Ϣ
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        // ת��Ϊ��С����������ĺ� > һ��ֵ
        int [] nums = new int[n];
        int result = n + 1;
        for(int i = 0; i < n; i++){
            nums[i] = getZero(in.nextInt());
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        while(right < n && left <= right){
            if(sum < k){
                sum += nums[right];
                right++;
            }else{
                result = Math.min(right - left , result);
                sum -= nums[left];
                left++;
            }
        }
        System.out.print(result);
    }
    // ����ĩβ�м���0
    public static int getZero(int num){
        int cnt = 0;
        while(num % 2 == 0){
            num = num / 2;
            cnt++
        }
        return cnt;
    }
}