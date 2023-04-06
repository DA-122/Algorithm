public class Solution {
    public static boolean primeSubOperation(int[] nums) {
        for(int i = nums.length-2; i >=0; i--){
            if(nums[i] >= nums[i+1]){
                int difference = nums[i]-nums[i+1];
                int prime = getPrime(difference);
                if(prime >= nums[i]){
                    return false;
                }
                nums[i] = nums[i] - prime;
            }
        }
        return true;
    }
    public static int getPrime(int difference){
        int prime = difference+1;
        while(!isPrime(prime)){
            prime++;
        }
        return prime;
    }
    public static boolean isPrime(int prime){
        // 1²»ÊÇËØÊý
        if(prime == 1){
            return false;
        }
        for(int i =2; i <= Math.sqrt(prime); i++){
            if(prime%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        int nums[] = {18,12,14,6};
        System.out.println(primeSubOperation(nums));
    }
}