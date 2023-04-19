// ����367 ��Ч����ȫƽ����

// ˼·��������69���һ��

public class Solution{
    public static boolean isPerfectSquare(int num) {
        // mid*mid��Խ�磬����������long
        long right = num;
        long left = 0;
        // left = right+1;
        while(left <= right){
            long mid = left + (right-left)/2;
            if(mid*mid > num){
                right = mid-1;
            }else if(mid*mid < num){
                left = mid+1;
            }else{
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        int num = 16;
        System.out.println(isPerfectSquare(num));
    }
}