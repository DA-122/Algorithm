// newPos = (pos + k)% n 
// ��1. ʹ�ö���Ŀռ�
// ��2. ��״�滻   ���⣺����жϱ����˶���Ԫ��
// �������߻ص�ԭ�㣬����aȦ,������b��Ԫ�� ��an = bk;
// an��n��k�Ĺ�����
// ���ڵ�һ�λص�ԭ��ͽ�����aҪ������С�����an��n��k����С������ lcm(n,k)
// b = lcm(n,k) / k�� һ�α�������ʵ�lcm(n,k) / k��Ԫ�أ�Ϊ�˷�������Ԫ�أ�Ҫ����
// n /(lcm(n,k)/k) = nk /(lcm(n,k)) = gcd(n,k) 

// ��3. ��תk��λ�ã�ʵ����ת k % n��λ��
// β����k % m ��λ�û��ƶ���ǰ k % m��λ��
// �ٷֱ�תͷ����β��

class Solution {
    // ��2. �����滻������������μ�¼��������
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


    // ��3 ��ת
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