// 周赛342 2.倍数求和
// 思路分析：简单的遍历时间复杂度O(N)
// 灵神：数学 容斥原理+等差数列求和

public class Solution{
    // 遍历 时间复杂度O(n) 空间复杂度O(1)
    public static int sumOfMultiples(int n) {
        int result = 0;
        for(int i = 3; i <= n ;i++){
            if(i%3 == 0 || i%5 ==0 || i%7 == 0){
                result+=i;
            }
        }
        return result;
    }
    // 容斥原理+等差数列
    // 对于M∈[1,n],m的倍数有c = floor(n/m)个，
    // m的和 sum = (m+cm)*c/2
    // 因为这里求的是能被3,5,7整除的整数和
    // 因此根据容斥原理要除去3,5,7的最小公倍数
    public int sumOfMultiples2(int n) {
        return s(n, 3) + s(n, 5) + s(n, 7) - s(n, 15) - s(n, 21) - s(n, 35) + s(n, 105);
    }

    private int s(int n, int m) {
        return (1 + n / m) * (n / m) / 2 * m;
    }
}


    public static void main(String[] args){
    
    }
}