// ����342 2.�������
// ˼·�������򵥵ı���ʱ�临�Ӷ�O(N)
// ������ѧ �ݳ�ԭ��+�Ȳ��������

public class Solution{
    // ���� ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(1)
    public static int sumOfMultiples(int n) {
        int result = 0;
        for(int i = 3; i <= n ;i++){
            if(i%3 == 0 || i%5 ==0 || i%7 == 0){
                result+=i;
            }
        }
        return result;
    }
    // �ݳ�ԭ��+�Ȳ�����
    // ����M��[1,n],m�ı�����c = floor(n/m)����
    // m�ĺ� sum = (m+cm)*c/2
    // ��Ϊ����������ܱ�3,5,7������������
    // ��˸����ݳ�ԭ��Ҫ��ȥ3,5,7����С������
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