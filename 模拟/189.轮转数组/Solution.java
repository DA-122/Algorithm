// newPos = (pos + k)% n 
// 法1. 使用额外的空间
// 法2. 环状替换   问题：如何判断遍历了多少元素
// 设最终走回到原点，走了a圈,遍历了b个元素 即an = bk;
// an是n和k的公倍数
// 由于第一次回到原点就结束，a要尽可能小，因此an是n和k的最小公倍数 lcm(n,k)
// b = lcm(n,k) / k， 一次遍历会访问到lcm(n,k) / k个元素，为了访问所有元素，要遍历
// n /(lcm(n,k)/k) = nk /(lcm(n,k)) = gcd(n,k) 

// 法3. 轮转k个位置，实际轮转 k % n个位置
// 尾部的k % m 个位置会移动到前 k % m个位置
// 再分别翻转头部和尾部

class Solution {
    // 法2. 环形替换，问题在于如何记录遍历次数
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k,n);
        for(int start = 0; start < count; ++start){
            int current = start;
            int val = nums[start];
            do{
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = val;
                val = temp;
                current = next;
            }while(start !=current);
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }


    // 法3 翻转
    public void rotate3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}